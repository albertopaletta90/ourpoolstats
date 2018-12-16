package oupoolstats.api.cryptopia.remote.data;

import java.math.BigDecimal;

import oupoolstats.api.cryptopia.remote.data.enums.TradePairStatus;

public class TradePair {
    private Long id;
    private String label;
    private String currency;
    private String symbol;
    private String baseCurrency;
    private String baseSymbol;
    private TradePairStatus status;
    private String statusMessage;
    private BigDecimal tradeFee;
    private BigDecimal minimumTrade;
    private BigDecimal maximumTrade;
    private BigDecimal minimumBaseTrade;
    private BigDecimal maximumBaseTrade;
    private BigDecimal minimumPrice;
    private BigDecimal maximumPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public TradePairStatus getStatus() {
        return status;
    }

    public void setStatus(TradePairStatus status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public BigDecimal getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(BigDecimal tradeFee) {
        this.tradeFee = tradeFee;
    }

    public BigDecimal getMinimumTrade() {
        return minimumTrade;
    }

    public void setMinimumTrade(BigDecimal minimumTrade) {
        this.minimumTrade = minimumTrade;
    }

    public BigDecimal getMaximumTrade() {
        return maximumTrade;
    }

    public void setMaximumTrade(BigDecimal maximumTrade) {
        this.maximumTrade = maximumTrade;
    }

    public BigDecimal getMinimumBaseTrade() {
        return minimumBaseTrade;
    }

    public void setMinimumBaseTrade(BigDecimal minimumBaseTrade) {
        this.minimumBaseTrade = minimumBaseTrade;
    }

    public BigDecimal getMaximumBaseTrade() {
        return maximumBaseTrade;
    }

    public void setMaximumBaseTrade(BigDecimal maximumBaseTrade) {
        this.maximumBaseTrade = maximumBaseTrade;
    }

    public BigDecimal getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(BigDecimal minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public BigDecimal getMaximumPrice() {
        return maximumPrice;
    }

    public void setMaximumPrice(BigDecimal maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TradePair{");
        sb.append("id=").append(id);
        sb.append(", label='").append(label).append('\'');
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", symbol='").append(symbol).append('\'');
        sb.append(", baseCurrency='").append(baseCurrency).append('\'');
        sb.append(", baseSymbol='").append(baseSymbol).append('\'');
        sb.append(", status=").append(status);
        sb.append(", statusMessage='").append(statusMessage).append('\'');
        sb.append(", tradeFee=").append(tradeFee);
        sb.append(", minimumTrade=").append(minimumTrade);
        sb.append(", maximumTrade=").append(maximumTrade);
        sb.append(", minimumBaseTrade=").append(minimumBaseTrade);
        sb.append(", maximumBaseTrade=").append(maximumBaseTrade);
        sb.append(", minimumPrice=").append(minimumPrice);
        sb.append(", maximumPrice=").append(maximumPrice);
        sb.append('}');
        return sb.toString();
    }
}
