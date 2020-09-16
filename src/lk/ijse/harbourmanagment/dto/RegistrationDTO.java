package lk.ijse.harbourmanagment.dto;


public class RegistrationDTO {
    private String rid;
    private String bid;
    private String r_date;

    public RegistrationDTO(String rid) {
        this.rid = rid;
        this.bid = bid;
    }

    public RegistrationDTO(String rid, String bid, String r_date) {
        this.rid = rid;
        this.bid = bid;
        this.r_date = r_date;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String sid) {
        this.rid = sid;
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
        return "RegistrationDTO{" +
                "sid='" + rid + '\'' +
                ", bid='" + bid + '\'' +
                ", r_date=" + r_date +
                '}';
    }
}
