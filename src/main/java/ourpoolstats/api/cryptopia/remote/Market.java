package ourpoolstats.api.cryptopia.remote;
import java.math.BigDecimal;


public class Market {
    private Long tradePairId;
    private String label;
    private BigDecimal askPrice;
    private BigDecimal bidPrice;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal volume;
    private BigDecimal lastPrice;
    private BigDecimal buyVolume;
    private BigDecimal sellVolume;
    private BigDecimal change;
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal baseVolume;
    private BigDecimal baseBuyVolume;
    private BigDecimal baseSellVolume;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(BigDecimal askPrice) {
        this.askPrice = askPrice;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getBuyVolume() {
        return buyVolume;
    }

    public void setBuyVolume(BigDecimal buyVolume) {
        this.buyVolume = buyVolume;
    }

    public BigDecimal getSellVolume() {
        return sellVolume;
    }

    public void setSellVolume(BigDecimal sellVolume) {
        this.sellVolume = sellVolume;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(BigDecimal baseVolume) {
        this.baseVolume = baseVolume;
    }

    public BigDecimal getBaseBuyVolume() {
        return baseBuyVolume;
    }

    public void setBaseBuyVolume(BigDecimal baseBuyVolume) {
        this.baseBuyVolume = baseBuyVolume;
    }

    public BigDecimal getBaseSellVolume() {
        return baseSellVolume;
    }

    public void setBaseSellVolume(BigDecimal baseSellVolume) {
        this.baseSellVolume = baseSellVolume;
    }

    public Long getTradePairId() {
        return tradePairId;
    }

    public void setTradePairId(Long tradePairId) {
        this.tradePairId = tradePairId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Market{");
        sb.append("tradePairId=").append(tradePairId);
        sb.append(", label='").append(label).append('\'');
        sb.append(", askPrice=").append(askPrice);
        sb.append(", bidPrice=").append(bidPrice);
        sb.append(", low=").append(low);
        sb.append(", high=").append(high);
        sb.append(", volume=").append(volume);
        sb.append(", lastPrice=").append(lastPrice);
        sb.append(", buyVolume=").append(buyVolume);
        sb.append(", sellVolume=").append(sellVolume);
        sb.append(", change=").append(change);
        sb.append(", open=").append(open);
        sb.append(", close=").append(close);
        sb.append(", baseVolume=").append(baseVolume);
        sb.append(", baseBuyVolume=").append(baseBuyVolume);
        sb.append(", baseSellVolume=").append(baseSellVolume);
        sb.append('}');
        return sb.toString();
    }
}