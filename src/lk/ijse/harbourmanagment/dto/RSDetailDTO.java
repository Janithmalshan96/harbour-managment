package lk.ijse.harbourmanagment.dto;

public class RSDetailDTO {
    private int rsid;
    private String rid;
    private String sid;

    public RSDetailDTO() {

    }

    public RSDetailDTO(int rsid, String rid, String sid) {
        this.rsid = rsid;
        this.rid = rid;
        this.sid = sid;
    }

    public int getRsid() {
        return rsid;
    }

    public void setRsid(int rsid) {
        this.rsid = rsid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }


    @Override
    public String toString() {
        return "RSDetailDTO{" +
                "rsid='" + rsid + '\'' +
                ", rid='" + rid + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}
