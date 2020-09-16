package lk.ijse.harbourmanagment.dto;

import java.util.ArrayList;

public class ManageFishermanDTO {
    private String fid;
    private String name;
    private String address;
    private String nic;
    private String contact;

    public ManageFishermanDTO() {
//        this.name = name;

    }

    public ManageFishermanDTO(String fid, String name, String address, String nic, String contact) {
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
        return "ManageFishermanDTO{" +
                "fid='" + fid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
