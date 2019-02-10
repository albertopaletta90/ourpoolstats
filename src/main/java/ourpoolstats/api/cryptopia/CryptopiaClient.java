package ourpoolstats.api.cryptopia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import ourpoolstats.api.cryptopia.remote.Currency;
import ourpoolstats.api.cryptopia.remote.Market;
import ourpoolstats.api.cryptopia.remote.TradePair;
import ourpoolstats.jsonparser.JsonParserCurrency;
import ourpoolstats.jsonparser.JsonParserMarket;
import ourpoolstats.jsonparser.JsonParserTradePair;


public class CryptopiaClient {
	private static final String ROOT_URL = "https://www.cryptopia.co.nz";
	private static final String PRIVATE_PATH = "api";

	private String jsonResponse;
	private List<Currency>list = new ArrayList<>();
	private List<TradePair> listTradePair = new ArrayList<>();

	private static CryptopiaClient instance;

	private CryptopiaClient() {}

	public static CryptopiaClient  getInstance() {

		if(instance == null) {

			instance = new CryptopiaClient();
		}

		return instance;
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

	public void initCurrency(){
		final String methodName = "GetCurrencies";
		jsonResponse = publicApiQuery(methodName);	
		JsonParserCurrency jsonParserCurrency = new JsonParserCurrency();
		jsonParserCurrency.parse(jsonResponse);
	}

	public List<TradePair> getTradePairs(){
		final String methodName = "GetTradePairs";
		final String jsonResponse = publicApiQuery(methodName);
		JsonParserTradePair jsonTradePair = new JsonParserTradePair();
		List<TradePair>list = jsonTradePair.parse(jsonResponse);
		return list;
	}


	public List<Market> getMarkets(){
		final String methodName = "GetMarkets";
		final String jsonResponse = publicApiQuery(methodName);
		JsonParserMarket jsonParserMarket = new JsonParserMarket();
		return jsonParserMarket.parse(jsonResponse);
	}

	public List<Market> getMarketsOrders(){
		final String methodName = "GetMarkets";
		final String jsonResponse = publicApiQuery(methodName);
		
		JsonParserMarket jsonParserMarket = new JsonParserMarket();
		return jsonParserMarket.parse(jsonResponse);
	}



}