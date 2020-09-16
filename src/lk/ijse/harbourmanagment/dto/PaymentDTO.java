package lk.ijse.harbourmanagment.dto;

import java.sql.Time;
import java.util.Date;

public class PaymentDTO {
    private String pid;
    private String rid;
    private Double amount;
    private String p_date;

    public PaymentDTO() {
    }

    public PaymentDTO(String pid, String rid, Double amount, String p_date) {
        this.pid = pid;
        this.rid = rid;
        this.amount = amount;
        this.p_date = p_date;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }



    @Override
    public String toString() {
        return "PaymentDTO{" +
                "pid='" + pid + '\'' +
                ", rid='" + rid + '\'' +
                ", amount=" + amount +
                ", p_date=" + p_date +
                '}';
    }
}
