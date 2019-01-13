package ourpoolstats.jsonparser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import oupoolstats.api.cryptopia.remote.data.Market;

public class JsonParserMarket {
	private String responseReadePair;
	private List<Market> list = new ArrayList<>();
	private String[] listMartket;

	public List<Market> parse(String response){

		responseReadePair = response.replace("{\"Success\":true,\"Message\":null,\"Data\":[{", "");
		response = responseReadePair;
		responseReadePair = response.replace("}],\"Error\":null}", "");
		response = responseReadePair;
		responseReadePair = response.replace(",{","");
		response = responseReadePair;
		responseReadePair = response.replace("\"TradePairId\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Label\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"AskPrice\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"BidPrice\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Low\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"High\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Volume\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"LastPrice\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"BuyVolume\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"SellVolume\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Change\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Open\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"Close\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"BaseVolume\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"BaseBuyVolume\":","");
		response = responseReadePair;
		responseReadePair = response.replace("\"BaseSellVolume\":","");
		response = responseReadePair;
		responseReadePair = response.replace("{","");
		response = responseReadePair;
		responseReadePair = response.replace("\"","");
		response = responseReadePair;
		listMartket =response.split("}");

		for(int i = 0;	i<listMartket.length; i++) {
			String[]tmpItem = listMartket[i].split(",");
			Market tmp = new Market();
			tmp.setTradePairId(Long.parseLong(tmpItem[0]));
			tmp.setLabel(tmpItem[1]);
			BigDecimal big = new BigDecimal("0");
			try {
				big = new BigDecimal(tmpItem[2]);
				tmp.setAskPrice(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setAskPrice(big);
			}
			try {
				big = new BigDecimal(tmpItem[3]);
				tmp.setBidPrice(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setBidPrice(big);
			}
			try {
				big = new BigDecimal(tmpItem[4]);
				tmp.setLow(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setLow(big);
			}
			try {
				big = new BigDecimal(tmpItem[5]);
				tmp.setHigh(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setHigh(big);
			}
			try {
				big = new BigDecimal(tmpItem[6]);
				tmp.setVolume(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setVolume(big);
			}
			try {
				big = new BigDecimal(tmpItem[7]);
				tmp.setLastPrice(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setLastPrice(big);
			}
			try {
				big = new BigDecimal(tmpItem[8]);
				tmp.setBuyVolume(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setBuyVolume(big);
			}
			try {
				big = new BigDecimal(tmpItem[9]);
				tmp.setSellVolume(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setSellVolume(big);
			}
			try {
				big = new BigDecimal(tmpItem[10]);
				tmp.setChange(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setChange(big);
			}
			try {
				big = new BigDecimal(tmpItem[11]);
				tmp.setOpen(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setOpen(big);
			}
			try {
				big = new BigDecimal(tmpItem[12]);
				tmp.setClose(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setClose(big);
			}
			try {
				big = new BigDecimal(tmpItem[13]);
				tmp.setBaseVolume(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setBaseVolume(big);
			}
			try {
				big = new BigDecimal(tmpItem[14]);
				tmp.setBaseBuyVolume(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setBaseBuyVolume(big);
			}
			try {
				big = new BigDecimal(tmpItem[15]);
				tmp.setBuyVolume(big);
			}
			catch (Exception e) {
				big = new BigDecimal("0.0");
				tmp.setBuyVolume(big);
			}

			list.add(tmp);
		}

		return list;
	}
}
