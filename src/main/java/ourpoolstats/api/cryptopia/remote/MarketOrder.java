package ourpoolstats.api.cryptopia.remote;

import java.math.BigDecimal;


public class MarketOrder {
    private Long tradePairId;
    private String label;
    private BigDecimal price;
    private BigDecimal volume;
    private BigDecimal total;

    public Long getTradePairId() {
        return tradePairId;
    }

    public void setTradePairId(Long tradePairId) {
        this.tradePairId = tradePairId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MarketOrder{");
        sb.append("tradePairId=").append(tradePairId);
        sb.append(", label='").append(label).append('\'');
        sb.append(", price=").append(price);
        sb.append(", volume=").append(volume);
        sb.append(", total=").append(total);
        sb.append('}');
        return sb.toString();
    }
}
