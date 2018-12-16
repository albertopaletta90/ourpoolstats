package ourpoolstats.jsonparser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import oupoolstats.api.cryptopia.remote.data.Currency;
import oupoolstats.api.cryptopia.remote.data.enums.CurrencyListingStatus;
import oupoolstats.api.cryptopia.remote.data.enums.CurrencyStatus;


public class JsonParserCurrency {
	private String jsonResponseTmp;
	private List<Currency>list = new ArrayList<>();

	public List<Currency> parse(String jsonResponse){
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
		return list;
	}
}
