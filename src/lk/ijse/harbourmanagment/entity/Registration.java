package lk.ijse.harbourmanagment.entity;

import java.util.Date;

public class Registration {
    private String rid;
    private String bid;
    private String r_date;

    public Registration() {

    }

    public Registration(String rid, String bid, String r_date) {
        this.rid = rid;
        this.bid = bid;
        this.r_date = r_date;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getR_date() {
        return r_date;
    }

    public void setR_date(String r_date) {
        this.r_date = r_date;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "rid='" + rid + '\'' +
                ", bid='" + bid + '\'' +
                ", r_date='" + r_date + '\'' +
                '}';
    }
}
