package ourpoolstats.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ourpoolstats.type.CurrencyType;

public class ConvertCurrency {

	private BigDecimal usd = new BigDecimal("1.13") ;
	private BigDecimal btc = new BigDecimal("3.59644");
	private static ConvertCurrency instance;
	
	private ConvertCurrency() {}
	
	public static ConvertCurrency getInstace() {
		
		if(instance == null) {
			instance  = new ConvertCurrency();
		}
		
		return instance;
	}
	
	
	public BigDecimal convertTo(CurrencyType type,BigDecimal value) {
		BigDecimal valueConvet = new BigDecimal("1") ;
		switch (type) {
		case USD:
			valueConvet = value.multiply(usd);
			break;

		case EURO:
			valueConvet = value.divide(usd,7, RoundingMode.HALF_UP);
			break;
		case BTC:
			valueConvet = value.divide(btc,7, RoundingMode.HALF_UP);
			break;
		}
		
		return valueConvet;
	}
	
}
