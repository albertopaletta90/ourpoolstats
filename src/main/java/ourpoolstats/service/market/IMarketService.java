package ourpoolstats.service.market;

import java.math.BigDecimal;

import ourpoolstats.type.DataBaseOperation;

public interface IMarketService {
	
	public boolean buy(String username, String coin,BigDecimal initialCurrency, BigDecimal totalCurrency,BigDecimal quantity);
	public boolean sell(int index,DataBaseOperation operation,BigDecimal quantity);
	public BigDecimal getCurrentCurrencyCoin(String nameCoin);
	

}
