package lk.ijse.harbourmanagment.dto;

public class FishermanDetailDTO {
    private String name;
    private String address;
    private String nic;

    public FishermanDetailDTO() {

    }

    public FishermanDetailDTO(String name, String address, String nic) {
        this.name = name;
        this.address = address;
        this.nic = nic;
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

    @Override
    public String toString() {
        return "FishermanDetailDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
