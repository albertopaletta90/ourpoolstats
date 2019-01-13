package oupoolstats.api.cryptopia.remote.data;

import java.util.List;

public class MarketOrders {
    private List<MarketOrder> buy;
    private List<MarketOrder> sell;

    public List<MarketOrder> getBuy() {
        return buy;
    }

    public void setBuy(List<MarketOrder> buy) {
        this.buy = buy;
    }

    public List<MarketOrder> getSell() {
        return sell;
    }

    public void setSell(List<MarketOrder> sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MarketOrders{");
        sb.append("buy=").append(buy);
        sb.append(", sell=").append(sell);
        sb.append('}');
        return sb.toString();
    }
}
