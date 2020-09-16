package lk.ijse.harbourmanagment.dto;

public class OwnerDTO {
    private String oid;
    private String name;
    private String address;
    private  String nic;
    private String contact;

    public OwnerDTO() {

    }

    public OwnerDTO(String oid, String name, String address, String nic, String contact) {
        this.oid = oid;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.contact = contact;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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
        return "Owner{" +
                "oid='" + oid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
