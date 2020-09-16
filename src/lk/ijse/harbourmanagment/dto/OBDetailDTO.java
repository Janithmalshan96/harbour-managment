package lk.ijse.harbourmanagment.dto;

public class OBDetailDTO {
    private int obid;
    private String oid;
    private String bid;

    public OBDetailDTO() {

    }

    public OBDetailDTO(String oid, String bid) {
        this.oid = oid;
        this.bid = bid;
    }

    public OBDetailDTO(int obid, String oid, String bid) {
        this.obid = obid;
        this.oid = oid;
        this.bid = bid;
    }

    public int getObid() {
        return obid;
    }

    public void setObid(int obid) {
        this.obid = obid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "OBDetailDTO{" +
                "obid=" + obid +
                ", oid='" + oid + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }
}
