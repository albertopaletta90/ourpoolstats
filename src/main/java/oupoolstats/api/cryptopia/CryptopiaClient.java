package oupoolstats.api.cryptopia;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

import oupoolstats.api.cryptopia.remote.CryptopiaClientException;
import oupoolstats.api.cryptopia.remote.data.Balance;
import oupoolstats.api.cryptopia.remote.data.Currency;
import oupoolstats.api.cryptopia.remote.data.DepositAddress;
import oupoolstats.api.cryptopia.remote.data.Market;
import oupoolstats.api.cryptopia.remote.data.MarketHistory;
import oupoolstats.api.cryptopia.remote.data.MarketOrder;
import oupoolstats.api.cryptopia.remote.data.MarketOrderGroup;
import oupoolstats.api.cryptopia.remote.data.MarketOrders;
import oupoolstats.api.cryptopia.remote.data.OpenOrder;
import oupoolstats.api.cryptopia.remote.data.SubmittedTrade;
import oupoolstats.api.cryptopia.remote.data.TradeHistory;
import oupoolstats.api.cryptopia.remote.data.TradePair;
import oupoolstats.api.cryptopia.remote.data.TradeSubmission;
import oupoolstats.api.cryptopia.remote.data.Transaction;
import oupoolstats.api.cryptopia.remote.data.enums.CurrencyListingStatus;
import oupoolstats.api.cryptopia.remote.data.enums.CurrencyStatus;
import oupoolstats.api.cryptopia.remote.data.enums.TransactionType;


public class CryptopiaClient {
	private static final String ROOT_URL = "https://www.cryptopia.co.nz";
	private static final String PRIVATE_PATH = "api";

	private String key;
	private String secretKey;
	private String jsonResponse;
	private String jsonResponseTmp;
	private Map<String,Currency> mapCoin;
	private List<Currency> selectMapCoin;
	private List<Currency>list = new ArrayList<>();

	private static CryptopiaClient instance;

	private CryptopiaClient() {}

	public static CryptopiaClient  getInstance() {

		if(instance == null) {

			instance = new CryptopiaClient();
		}

		return instance;
	}

	public CryptopiaClient setKey(String key) {
		this.key = key;
		return this;
	}

	public CryptopiaClient setSecretKey(String secretKey) {
		this.secretKey = secretKey;
		return this;
	}

	private static String publicApiQuery(String method) {
		BufferedReader in = null;
		try {
			final String urlMethod = String.format("%s/%s/%s", ROOT_URL, PRIVATE_PATH, method);
			final URLConnection con = new URL(urlMethod).openConnection();
			final HttpsURLConnection httpsConn = (HttpsURLConnection) con;
			httpsConn.setRequestMethod("GET");
			httpsConn.setInstanceFollowRedirects(true);
			con.setRequestProperty("Content-Type", "application/json");
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			final StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			return response.toString();
		} catch (Exception e) {
			throw new CryptopiaClientException("An error occurred communicating with Cryptopia.", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ignored) {}
			}
		}
	}

	private String privateApiQuery(String method, String postParam) {
		if (secretKey == null) {
			throw new CryptopiaClientException("Please set your secret key before attempting " +
					"to access any private API methods.");
		}
		if (key == null) {
			throw new CryptopiaClientException("Please set your key before attempting " +
					"to access any private API methods.");
		}
		BufferedReader in = null;
		try {
			final String urlMethod = String.format("%s/%s/%s", ROOT_URL, PRIVATE_PATH, method);
			final String nonce = String.valueOf(System.currentTimeMillis());
			final StringBuilder reqSignature = new StringBuilder();
			reqSignature
			.append(key)
			.append("POST")
			.append(URLEncoder.encode(urlMethod, StandardCharsets.UTF_8.toString()).toLowerCase())
			.append(nonce)
			.append(getMD5_B64(postParam));
			final StringBuilder auth = new StringBuilder();
			auth.append("amx ")
			.append(key)
			.append(":")
			.append(sha256_B64(reqSignature.toString()))
			.append(":")
			.append(nonce);
			final URLConnection con = new URL(urlMethod).openConnection();
			con.setDoOutput(true);
			final HttpsURLConnection httpsConn = (HttpsURLConnection) con;
			httpsConn.setRequestMethod("POST");
			httpsConn.setInstanceFollowRedirects(true);
			con.setRequestProperty("Authorization", auth.toString());
			con.setRequestProperty("Content-Type", "application/json");
			final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParam);
			wr.flush();
			wr.close();
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			return response.toString();
		}catch (Exception e) {
			throw new CryptopiaClientException("An error occurred communicating with Cryptopia.", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ignored) {}
			}
		}
	}

	private String getMD5_B64(String postParameter) throws Exception {
		return Base64.getEncoder().encodeToString(
				MessageDigest.getInstance("MD5").digest(postParameter.getBytes("UTF-8")));
	}

	private String sha256_B64(String msg) throws Exception {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "HmacSHA256");
		sha256_HMAC.init(secret_key);
		return Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(msg.getBytes("UTF-8")));
	}

	public void initCurrency(){

		final String methodName = "GetCurrencies";
		jsonResponse = publicApiQuery(methodName);	
		jsonResponseTmp = jsonResponse.replace("{\"Success\":true,\"Message\":null,\"Data\":[","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("],\"Error\":null}","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace(",{", "");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"Id\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"Name\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"Symbol\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"Algorithm\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"WithdrawFee\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"MinWithdraw\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"MaxWithdraw\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"MinBaseTrade\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"IsTipEnabled\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"MinTip\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"DepositConfirmations\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"Status\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"StatusMessage\":","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("{","");
		jsonResponse = jsonResponseTmp;
		jsonResponseTmp = jsonResponse.replace("\"","");
		jsonResponse = jsonResponseTmp;

		String[] items = jsonResponseTmp.split("}");
		list = createList(items);


	}

	private List<Currency> createList(String[] items) {

		for (int i = 0; i <items.length; i++) {
			String[]tmpItem = items[i].split(",");
			Currency tmp = new Currency();
			tmp.setId(Long.parseLong(tmpItem[0]));
			tmp.setName(tmpItem[1]);
			tmp.setSymbol(tmpItem[2]);
			tmp.setAlgorithm(tmpItem[3]);
			BigDecimal big = new BigDecimal(tmpItem[4]);
			big =  new BigDecimal(tmpItem[5]);
			tmp.setWithdrawFee(big);
			tmp.setTipEnabled(Boolean.parseBoolean(tmpItem[6]));
			big = new BigDecimal(tmpItem[7]);
			tmp.setMinTip(big);
			//tmp.setDepositConfirmations(Long.parseLong(tmpItem[8]));
			tmp.setStatus(CurrencyStatus.OK);
			tmp.setStatusMessage(tmpItem[9]);
			tmp.setListingStatus(CurrencyListingStatus.ACTIVE);
			list.add(tmp);

		}
		createMapCoinCryptopia();

		return list;

	}


	public void createMapCoinCryptopia(){

		for(int i = 0; i<list.size();	i++) {
			mapCoin.put(list.get(i).getName(), list.get(i));
		}

	}

	public List<Currency> getMapCoinCryptopia(List<String>list){

		for(int i = 0; i<list.size();	i++) {
			selectMapCoin.add(mapCoin.get(list.get(i)));
		}

		return selectMapCoin;
	}


//	public List<TradePair> getTradePairs() throws ParseException {
//		final String methodName = "GetTradePairs";
//		final String jsonResponse = publicApiQuery(methodName);
//		final ApiResponse<List<TradePair>> resp =
//				new ApiResponse<>();
//		final List<TradePair> data = new ArrayList<>();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		final JsonArray dataArray = rootObject.get("Data").getAsJsonArray();
//		resp.setJson(jsonResponse);
//		resp.setMessage(rootObject.get("Message").toString());
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		validateResponse(resp);
//		for (final JsonElement element : dataArray) {
//			final TradePair result = new TradePair();
//			data.add(result);
//			final JsonObject object = element.getAsJsonObject();
//			result.setId(object.get("Id").getAsLong());
//			result.setLabel(object.get("Label").toString());
//			result.setCurrency(object.get("Currency").toString());
//			result.setSymbol(object.get("Symbol").toString());
//			result.setBaseCurrency(object.get("BaseCurrency").toString());
//			result.setBaseSymbol(object.get("BaseSymbol").toString());
//			result.setStatus(TradePairStatus.byLabel(object.get("Status").toString().replace("\"","")));
//			result.setStatusMessage(object.get("StatusMessage").toString());
//			result.setTradeFee(object.get("TradeFee").getAsBigDecimal());
//			result.setMinimumTrade(object.get("MinimumTrade").getAsBigDecimal());
//			result.setMaximumTrade(object.get("MaximumTrade").getAsBigDecimal());
//			result.setMinimumBaseTrade(object.get("MinimumBaseTrade").getAsBigDecimal());
//			result.setMaximumBaseTrade(object.get("MaximumBaseTrade").getAsBigDecimal());
//			result.setMinimumPrice(object.get("MinimumPrice").getAsBigDecimal());
//			result.setMaximumPrice(object.get("MaximumPrice").getAsBigDecimal());
//		}
//		return data;
//	}
//
//	public List<Market> getMarkets() throws ParseException {
//		final String methodName = "GetMarkets";
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseGetMarketsResponse(jsonResponse);
//	}
//
//	public List<Market> getMarkets(String baseMarket) throws ParseException {
//		final String methodName = String.format("GetMarkets/%s", baseMarket);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseGetMarketsResponse(jsonResponse);
//	}
//
//
//	public List<Market> getMarkets(Integer hours) throws ParseException {
//		final String methodName = String.format("GetMarkets/%d", hours);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseGetMarketsResponse(jsonResponse);
//	}
//
//	public List<Market> getMarkets(String baseMarket, Integer hours) throws ParseException {
//		final String methodName = String.format("GetMarkets/%s/%d", baseMarket, hours);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseGetMarketsResponse(jsonResponse);
//	}
//
//	public Market getMarket(String tradePair) throws ParseException {
//		final String methodName = String.format("GetMarket/%s", tradePair);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseGetMarketResponse(jsonResponse);
//	}
//
//	public Market getMarket(String tradePair, Integer hours) throws ParseException {
//		final String methodName = String.format("GetMarket/%s/%d", tradePair, hours);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseGetMarketResponse(jsonResponse);
//	}
//
//
//	public List<MarketHistory> getMarketHistory(String tradePair) throws ParseException {
//		final String methodName = String.format("GetMarketHistory/%s", tradePair);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseMarketHistoryResponse(jsonResponse);
//	}
//
//	public List<MarketHistory> getMarketHistory(String tradePair, Integer hours) throws ParseException {
//		final String methodName = String.format("GetMarketHistory/%s/%d", tradePair, hours);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseMarketHistoryResponse(jsonResponse);
//	}
//
//
//	public MarketOrders getMarketOrders(String tradePair) throws ParseException {
//		final String methodName = String.format("GetMarketOrders/%s", tradePair);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseMarketOrdersResponse(jsonResponse);
//	}
//
//	public MarketOrders getMarketOrders(String tradePair, Long orderCount) throws ParseException {
//		final String methodName = String.format("GetMarketOrders/%s/%d", tradePair, orderCount);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseMarketOrdersResponse(jsonResponse);
//	}
//
//	public List<MarketOrderGroup> getMarketOrderGroups(List<String> marketNames) throws ParseException {
//		final String methodName = String.format("GetMarketOrderGroups/%s", String.join("-", marketNames));
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseMarketOrderGroupsResponse(jsonResponse);
//	}
//
//	public List<MarketOrderGroup> getMarketOrderGroups(List<String> marketNames, Integer orderCount) throws ParseException {
//		final String methodName = String.format("GetMarketOrderGroups/%s/%d", String.join("-", marketNames), orderCount);
//		final String jsonResponse = publicApiQuery(methodName);
//		return parseMarketOrderGroupsResponse(jsonResponse);
//	}
//
//	public List<Balance> getBalance(String currency) throws ParseException {
//		final String methodName = "GetBalance";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("Currency", currency);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseBalances(jsonResponse);
//	}
//
//	public List<Balance> getBalance(Long currencyId) throws ParseException {
//		final String methodName = "GetBalance";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("CurrencyId", currencyId);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseBalances(jsonResponse);
//	}
//
//	public DepositAddress getDepositAddress(String currency) throws ParseException {
//		final String methodName = "GetDepositAddress";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("Currency", currency);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseDepositAddress(jsonResponse);
//	}
//
//	public DepositAddress getDepositAddress(Long currencyId) throws ParseException {
//		final String methodName = "GetDepositAddress";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("CurrencyId", currencyId);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseDepositAddress(jsonResponse);
//	}
//
//	public List<OpenOrder> getOpenOrders(String market) throws ParseException {
//		final String methodName = "GetOpenOrders";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("Market", market);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseOpenOrders(jsonResponse);
//	}
//
//	public List<OpenOrder> getOpenOrders(Long tradePairId) throws ParseException {
//		final String methodName = "GetOpenOrders";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("TradePairId", tradePairId);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseOpenOrders(jsonResponse);
//	}
//
//	public List<OpenOrder> getOpenOrders(String market, Long count) throws ParseException {
//		final String methodName = "GetOpenOrders";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("Market", market);
//		jo.addProperty("Count", count);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseOpenOrders(jsonResponse);
//	}
//
//	public List<OpenOrder> getOpenOrders(Long tradePairId, Long count) throws ParseException {
//		final String methodName = "GetOpenOrders";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("TradePairId", tradePairId);
//		jo.addProperty("Count", count);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseOpenOrders(jsonResponse);
//	}
//
//
//	public List<TradeHistory> getTradeHistory(String market) throws ParseException {
//		final String methodName = "GetTradeHistory";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("Market", market);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseTradeHistory(jsonResponse);
//	}
//
//	public List<TradeHistory> getTradeHistory(Long tradePairId) throws ParseException {
//		final String methodName = "GetTradeHistory";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("TradePairId", tradePairId);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseTradeHistory(jsonResponse);
//	}
//
//	public List<TradeHistory> getTradeHistory(String market, Long count) throws ParseException {
//		final String methodName = "GetTradeHistory";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("Market", market);
//		jo.addProperty("Count", count);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseTradeHistory(jsonResponse);
//	}
//
//	public List<TradeHistory> getTradeHistory(Long tradePairId, Long count) throws ParseException {
//		final String methodName = "GetTradeHistory";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("TradePairId", tradePairId);
//		jo.addProperty("Count", count);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseTradeHistory(jsonResponse);
//	}
//
//
//	public List<Transaction> getTransactions(TransactionType type) throws ParseException {
//		final String methodName = "GetTransactions";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("Type", type.getLabel());
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseTransactions(jsonResponse);
//	}
//
//	public List<Transaction> getTransactions(TransactionType type, Long count) throws ParseException {
//		final String methodName = "GetTransactions";
//		final JsonObject jo = new JsonObject();
//		jo.addProperty("Type", type.getLabel());
//		jo.addProperty("Count", count);
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		return parseTransactions(jsonResponse);
//	}
//
//	public SubmittedTrade submitTrade(TradeSubmission submission) throws ParseException {
//		final String methodName = "SubmitTrade";
//		final JsonObject jo = new JsonObject();
//		if (submission.getMarket() != null) {
//			jo.addProperty("Market", submission.getMarket());
//		}
//		if (submission.getMarketId() != null) {
//			jo.addProperty("MarketId", submission.getMarketId());
//		}
//		jo.addProperty("TradeType", submission.getType().getLabel());
//		jo.addProperty("Rate", submission.getRate());
//		jo.addProperty("Amount", submission.getAmount());
//		final String jsonResponse = privateApiQuery(methodName, jo.toString());
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		final ApiResponse<SubmittedTrade> resp = new ApiResponse<>();
//		resp.setJson(jsonResponse);
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		resp.setMessage(rootObject.get("Error").toString());
//		validateResponse(resp);
//		final JsonObject object = rootObject.get("Data").getAsJsonObject();
//		final SubmittedTrade trade = new SubmittedTrade();
//		trade.setOrderId(object.get("OrderId").getAsLong());
//		trade.setFilledOrders(new ArrayList<>());
//		final JsonArray jsonArray = object.get("FilledOrders").getAsJsonArray();
//		for (JsonElement arrayElement : jsonArray) {
//			final JsonObject jFilledOrder = arrayElement.getAsJsonObject();
//			trade.getFilledOrders().add(jFilledOrder.getAsLong());
//		}
//		return trade;
//	}
//
//	private List<Transaction> parseTransactions(String jsonResponse) throws ParseException {
//		final ApiResponse<List<Transaction>> resp = new ApiResponse<>();
//		final List<Transaction> data = new ArrayList<>();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		resp.setJson(jsonResponse);
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		resp.setMessage(rootObject.get("Error").toString());
//		validateResponse(resp);
//		final JsonArray jsonArray = rootObject.get("Data").getAsJsonArray();
//		for (final JsonElement element : jsonArray) {
//			final JsonObject object = element.getAsJsonObject();
//			final Transaction item = new Transaction();
//			data.add(item);
//			item.setId(object.get("Id").getAsLong());
//			item.setCurrency(object.get("Currency").toString());
//			item.setTxId(object.get("TxId").toString());
//			item.setType(TransactionType.byLabel(object.get("Type").toString().replace("\"","")));
//			item.setAmount(object.get("Amount").getAsBigDecimal());
//			item.setFee(object.get("Fee").getAsBigDecimal());
//			item.setStatus(object.get("Status").toString());
//			item.setConfirmations(object.get("Confirmations").getAsLong());
//			item.setTime(new Date(object.get("TimeStamp").getAsLong()));
//			item.setAddress(object.get("Address").toString());
//		}
//		return data;
//	}
//
//
//
//	private List<TradeHistory> parseTradeHistory(String jsonResponse) throws ParseException {
//		final ApiResponse<List<TradeHistory>> resp = new ApiResponse<>();
//		final List<TradeHistory> data = new ArrayList<>();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		resp.setJson(jsonResponse);
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		resp.setMessage(rootObject.get("Error").toString());
//		validateResponse(resp);
//		final JsonArray jsonArray = rootObject.get("Data").getAsJsonArray();
//		for (final JsonElement element : jsonArray) {
//			final JsonObject object = element.getAsJsonObject();
//			final TradeHistory item = new TradeHistory();
//			data.add(item);
//			item.setTradeId(object.get("TradeId").getAsLong());
//			item.setTradePairId(object.get("TradePairId").getAsLong());
//			item.setMarket(object.get("Market").toString());
//			item.setType(object.get("Type").toString());
//			item.setRate(object.get("Rate").getAsBigDecimal());
//			item.setAmount(object.get("Amount").getAsBigDecimal());
//			item.setTotal(object.get("Total").getAsBigDecimal());
//			item.setFee(object.get("Fee").getAsBigDecimal());
//			item.setTime(new Date(object.get("TimeStamp").getAsLong()));
//		}
//		return data;
//	}
//
//	private List<OpenOrder> parseOpenOrders(String jsonResponse) throws ParseException {
//		final ApiResponse<List<OpenOrder>> resp = new ApiResponse<>();
//		final List<OpenOrder> data = new ArrayList<>();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		resp.setJson(jsonResponse);
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		resp.setMessage(rootObject.get("Error").toString());
//		validateResponse(resp);
//		final JsonArray jsonArray = rootObject.get("Data").getAsJsonArray();
//		for (final JsonElement element : jsonArray) {
//			final JsonObject object = element.getAsJsonObject();
//			final OpenOrder item = new OpenOrder();
//			data.add(item);
//			item.setOrderId(object.get("OrderId").getAsLong());
//			item.setTradePairId(object.get("TradePairId").getAsLong());
//			item.setMarket(object.get("Market").toString());
//			item.setType(object.get("Type").toString());
//			item.setRate(object.get("Rate").getAsBigDecimal());
//			item.setAmount(object.get("Amount").getAsBigDecimal());
//			item.setTotal(object.get("Total").getAsBigDecimal());
//			item.setRemaining(object.get("Remaining").getAsBigDecimal());
//			item.setTime(new Date(object.get("TimeStamp").getAsLong()));
//		}
//		return data;
//	}
//
//
//	private DepositAddress parseDepositAddress(String jsonResponse) throws ParseException {
//		final ApiResponse<DepositAddress> resp =
//				new ApiResponse<>();
//		final DepositAddress data = new DepositAddress();
//		resp.setData(data);
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		resp.setJson(jsonResponse);
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		resp.setMessage(rootObject.get("Error").toString());
//		validateResponse(resp);
//		final JsonObject object = rootObject.get("Data").getAsJsonObject();
//		final DepositAddress da = new DepositAddress();
//		da.setCurrency(object.get("Currency").toString());
//		da.setBaseAddress(object.get("BaseAddress").toString());
//		da.setAddress(object.get("Address").toString());
//		return da;
//	}
//
//	private List<Balance> parseBalances(String jsonResponse) throws ParseException {
//		final ApiResponse<List<Balance>> resp = new ApiResponse<>();
//		final List<Balance> data = new ArrayList<>();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		resp.setJson(jsonResponse);
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		resp.setMessage(rootObject.get("Error").toString());
//		validateResponse(resp);
//		final JsonArray jsonArray = rootObject.get("Data").getAsJsonArray();
//		for (final JsonElement element : jsonArray) {
//			final JsonObject object = element.getAsJsonObject();
//			final Balance bal = new Balance();
//			data.add(bal);
//			bal.setCurrencyId(object.get("CurrencyId").getAsLong());
//			bal.setSymbol(object.get("Symbol").toString());
//			bal.setTotal(object.get("Total").getAsBigDecimal());
//			bal.setAvailable(object.get("Available").getAsBigDecimal());
//			bal.setUnconfirmed(object.get("Unconfirmed").getAsBigDecimal());
//			bal.setHeldForTrades(object.get("HeldForTrades").getAsBigDecimal());
//			bal.setPendingWithdraw(object.get("PendingWithdraw").getAsBigDecimal());
//			bal.setAddress(object.get("Address").toString());
//			bal.setBaseAddress(object.get("BaseAddress").toString());
//			bal.setStatus(object.get("Status").toString());
//			bal.setStatusMessage(object.get("StatusMessage").toString());
//		}
//		return data;
//	}
//
//	private List<MarketOrderGroup> parseMarketOrderGroupsResponse(String jsonResponse) throws ParseException {
//		final ApiResponse<List<MarketOrderGroup>> resp = new ApiResponse<>();
//		final List<MarketOrderGroup> data = new ArrayList<>();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		resp.setJson(jsonResponse);
//		resp.setMessage(rootObject.get("Message").toString());
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		validateResponse(resp);
//		final JsonArray jsonArray = rootObject.get("Data").getAsJsonArray();
//		for (final JsonElement element : jsonArray) {
//			final JsonObject object = element.getAsJsonObject();
//			final MarketOrderGroup group = new MarketOrderGroup();
//			data.add(group);
//			group.setTradePairId(object.get("TradePairId").getAsLong());
//			group.setMarket(object.get("Market").toString());
//			group.setBuy(parseMarketOrders(object.get("Buy").getAsJsonArray()));
//			group.setSell(parseMarketOrders(object.get("Sell").getAsJsonArray()));
//		}
//		return data;
//	}
//
//	private MarketOrders parseMarketOrdersResponse(String jsonResponse) throws ParseException {
//		final ApiResponse<MarketOrders> resp = new ApiResponse<>();
//		final MarketOrders data = new MarketOrders();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		resp.setJson(jsonResponse);
//		resp.setMessage(rootObject.get("Message").toString());
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		final JsonObject dataObject = rootObject.get("Data").getAsJsonObject();
//		data.setBuy(parseMarketOrders(dataObject.get("Buy").getAsJsonArray()));
//		data.setSell(parseMarketOrders(dataObject.get("Sell").getAsJsonArray()));
//		validateResponse(resp);
//		return data;
//	}
//
//	private List<MarketOrder> parseMarketOrders(JsonArray dataArray) {
//		final List<MarketOrder> data = new ArrayList<>();
//		for (final JsonElement element : dataArray) {
//			final MarketOrder result = new MarketOrder();
//			data.add(result);
//			final JsonObject object = element.getAsJsonObject();
//			result.setTradePairId(object.get("TradePairId").getAsLong());
//			result.setLabel(object.get("Label").toString());
//			result.setPrice(object.get("Price").getAsBigDecimal());
//			result.setVolume(object.get("Volume").getAsBigDecimal());
//			result.setTotal(object.get("Total").getAsBigDecimal());
//		}
//		return data;
//	}
//
//	private List<MarketHistory> parseMarketHistoryResponse(String jsonResponse) throws ParseException {
//		final ApiResponse<List<MarketHistory>> resp = new ApiResponse<>();
//		final List<MarketHistory> data = new ArrayList<>();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		final JsonArray dataArray = rootObject.get("Data").getAsJsonArray();
//		resp.setJson(jsonResponse);
//		resp.setMessage(rootObject.get("Message").toString());
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		validateResponse(resp);
//		for (final JsonElement element : dataArray) {
//			final MarketHistory result = new MarketHistory();
//			data.add(result);
//			final JsonObject object = element.getAsJsonObject();
//			result.setTradePairId(object.get("TradePairId").getAsLong());
//			result.setLabel(object.get("Label").toString());
//			result.setType(object.get("Type").toString());
//			result.setPrice(object.get("Price").getAsBigDecimal());
//			result.setAmount(object.get("Amount").getAsBigDecimal());
//			result.setTotal(object.get("Total").getAsBigDecimal());
//			result.setTime(new Date(object.get("Timestamp").getAsLong()));
//		}
//		return data;
//	}
//
//	private Market parseGetMarketResponse(String jsonResponse) throws ParseException {
//		final ApiResponse<Market> resp = new ApiResponse<>();
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		resp.setJson(jsonResponse);
//		resp.setMessage(rootObject.get("Message").toString());
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		validateResponse(resp);
//		final Market market = parseMarketObject(rootObject.get("Data").getAsJsonObject());
//		resp.setData(market);
//		return market;
//	}
//
//	private List<Market> parseGetMarketsResponse(String jsonResponse) throws ParseException {
//		final ApiResponse<List<Market>> resp = new ApiResponse<>();
//		final List<Market> data = new ArrayList<>();
//		resp.setData(data);
//		final JsonElement jElement = (JsonElement) parser.parse(jsonResponse);
//		final JsonObject rootObject = jElement.getAsJsonObject();
//		final JsonArray dataArray = rootObject.get("Data").getAsJsonArray();
//		resp.setJson(jsonResponse);
//		resp.setMessage(rootObject.get("Message").toString());
//		resp.setSuccess(rootObject.get("Success").getAsBoolean());
//		for (final JsonElement element : dataArray) {
//			final JsonObject object = element.getAsJsonObject();
//			final Market result = parseMarketObject(object);
//			data.add(result);
//		}
//		validateResponse(resp);
//		return data;
//	}
//
//	private Market parseMarketObject(JsonObject object) {
//		final Market result = new Market();
//		result.setTradePairId(object.get("TradePairId").getAsLong());
//		result.setLabel(object.get("Label").toString());
//		result.setAskPrice(object.get("AskPrice").getAsBigDecimal());
//		result.setBidPrice(object.get("BidPrice").getAsBigDecimal());
//		result.setLow(object.get("Low").getAsBigDecimal());
//		result.setHigh(object.get("High").getAsBigDecimal());
//		result.setVolume(object.get("Volume").getAsBigDecimal());
//		result.setLastPrice(object.get("LastPrice").getAsBigDecimal());
//		result.setBuyVolume(object.get("BuyVolume").getAsBigDecimal());
//		result.setSellVolume(object.get("SellVolume").getAsBigDecimal());
//		result.setChange(object.get("Change").getAsBigDecimal());
//		result.setOpen(object.get("Open").getAsBigDecimal());
//		result.setClose(object.get("Close").getAsBigDecimal());
//		result.setBaseVolume(object.get("BaseVolume").getAsBigDecimal());
//		result.setBaseBuyVolume(object.get("BuyBaseVolume").getAsBigDecimal());
//		result.setBaseSellVolume(object.get("SellBaseVolume").getAsBigDecimal());
//		return result;
//	}
//
//
//	private static void validateResponse(ApiResponse response) {
//		if (response.isSuccess()) {
//			return;
//		}
//		throw new CryptopiaClientException(response.getMessage());
//	}
}