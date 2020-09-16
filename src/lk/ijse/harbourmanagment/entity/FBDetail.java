package lk.ijse.harbourmanagment.entity;

public class FBDetail {
    private int fbid;
    private String bid;
    private String fid;

    public FBDetail() {

    }

    public FBDetail(int fbid, String bid, String fid) {
        this.fbid = fbid;
        this.bid = bid;
        this.fid = fid;
    }

    public int getFbid() {
        return fbid;
    }

    public void setFbid(int fbid) {
        this.fbid = fbid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}
