package lk.ijse.harbourmanagment.dto;

public class ScheduleDetailDTO {
    private String sid;
    private String start_date;
    private String end_date;
    private int count;
    private String bid;

    public ScheduleDetailDTO() {

    }

    public ScheduleDetailDTO(String sid, String start_date, String end_date, int count, String bid) {
        this.sid = sid;
        this.start_date = start_date;
        this.end_date = end_date;
        this.count = count;
        this.bid = bid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "ScheduleDetailDTO{" +
                "sid='" + sid + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", count=" + count +
                ", bid='" + bid + '\'' +
                '}';
    }
}
