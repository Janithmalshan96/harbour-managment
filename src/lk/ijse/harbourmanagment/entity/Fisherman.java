package lk.ijse.harbourmanagment.entity;

public class Fisherman {
    private String fid;
    private String name;
    private String address;
    private String nic;
    private String contact;

    public Fisherman() {

    }

    public Fisherman(String fid, String name, String address, String nic, String contact) {
        this.fid = fid;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.contact = contact;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Fisherman{" +
                "fbid='" + fid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
