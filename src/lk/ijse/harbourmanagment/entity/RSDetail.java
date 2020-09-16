package lk.ijse.harbourmanagment.entity;

public class RSDetail {
    private int rsid;
    private String rid;
    private String sid;

    public RSDetail() {

    }

    public RSDetail(int rsid, String rid, String sid) {
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
        return "RSDetail{" +
                "rsid='" + rsid + '\'' +
                ", rid='" + rid + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }
}
