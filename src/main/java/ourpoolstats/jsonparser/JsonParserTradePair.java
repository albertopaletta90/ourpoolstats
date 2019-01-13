package ourpoolstats.jsonparser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import oupoolstats.api.cryptopia.remote.data.TradePair;
import oupoolstats.api.cryptopia.remote.data.enums.TradePairStatus;

public class JsonParserTradePair {


	private String responseReadePair;
	private String[] listTrade;
	private List<TradePair>list = new ArrayList<>();

	public List<TradePair> parse(String response){

		responseReadePair = response.replace("{\"Success\":true,\"Message\":null,\"Data\":[{", "");
		response = responseReadePair;
		responseReadePair = response.replace("}],\"Error\":null}", "");
		response = responseReadePair;
		responseReadePair = response.replace(",{","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Id\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Label\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Currency\":","");
		response = responseReadePair;
		responseReadePair = response.replace("Symbol\":","");
		response = responseReadePair;
		responseReadePair = response.replace("BaseCurrency\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"BaseSymbol\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Status\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"StatusMessage\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"TradeFee\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"TradeFee\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"MinimumTrade\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"MaximumTrade\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"MinimumBaseTrade\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"MaximumBaseTrade\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"MinimumPrice\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"MaximumPrice\":","");
		response = responseReadePair;
		responseReadePair = response.replace("{","");
		response = responseReadePair;
		responseReadePair = response.replace("\"","");
		response = responseReadePair;
		listTrade =response.split("}");

		for(int i = 0;	i<listTrade.length; i++) {
			String[]tmpItem = listTrade[i].split(",");
			TradePair tmp = new TradePair();
			tmp.setId(Long.parseLong(tmpItem[0]));
			tmp.setLabel(tmpItem[1]);
			tmp.setCurrency(tmpItem[2]);
			tmp.setSymbol(tmpItem[3]);
			tmp.setBaseCurrency(tmpItem[4]);
			tmp.setBaseSymbol(tmpItem[5]);
			tmp.setStatus(TradePairStatus.OK);
			tmp.setStatusMessage(tmpItem[7]);
			BigDecimal big = null;
			try {
				big = new BigDecimal(tmpItem[8]);
				tmp.setTradeFee(big);
			} catch (Exception e) {
				big =new BigDecimal("0.0");
				tmp.setTradeFee(big);
			}
			try {
				big= new BigDecimal(tmpItem[9]);
				tmp.setMinimumTrade(big);
			} catch (Exception e) {
				big= new BigDecimal("0.0");
				tmp.setMinimumTrade(big);
			}
			try {
				big = new BigDecimal(tmpItem[10]);
				tmp.setMaximumTrade(big);
			} catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setMaximumTrade(big);
			}
			try {
				big = new BigDecimal(tmpItem[11]);
				tmp.setMinimumBaseTrade(big);
			} catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setMinimumBaseTrade(big);
			}
			try {
				big = new BigDecimal(tmpItem[12]);
				tmp.setMaximumBaseTrade(big);
			} catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setMaximumBaseTrade(big);
			}
			try {
				big =  new BigDecimal(tmpItem[13]);
				tmp.setMinimumPrice(big);
			} catch (Exception e) {
				big =  new BigDecimal("0.0");
				tmp.setMinimumPrice(big);
			}
			try {
				big = new BigDecimal(tmpItem[14]);
				tmp.setMaximumPrice(big);
			} catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setMaximumPrice(big);
			}
			
			list.add(tmp);
		}

		return list;
	}
}
