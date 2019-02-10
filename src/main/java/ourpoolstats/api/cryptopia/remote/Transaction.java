package ourpoolstats.api.cryptopia.remote;


import java.math.BigDecimal;
import java.util.Date;

import ourpoolstats.api.cryptopia.data.enums.TransactionType;

/**
 * Created by Dylan Janeke on 2017/06/23.
 */
public class Transaction {
    private Long id;
    private String currency;
    private String txId;
    private TransactionType type;
    private BigDecimal amount;
    private BigDecimal fee;
    private String status;
    private Long confirmations;
    private Date time;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Long confirmations) {
        this.confirmations = confirmations;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("id=").append(id);
        sb.append(", currency='").append(currency).append('\'');
        sb.append(", txId='").append(txId).append('\'');
        sb.append(", type=").append(type);
        sb.append(", amount=").append(amount);
        sb.append(", fee=").append(fee);
        sb.append(", status='").append(status).append('\'');
        sb.append(", confirmations=").append(confirmations);
        sb.append(", time=").append(time);
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
