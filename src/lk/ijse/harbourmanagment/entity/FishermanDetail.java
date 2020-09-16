package lk.ijse.harbourmanagment.entity;

public class FishermanDetail {
    private String name;
    private String addess;
    private String nic;

    public FishermanDetail() {

    }

    public FishermanDetail(String name, String addess, String nic) {
        this.name = name;
        this.addess = addess;
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddess() {
        return addess;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "FishermanDetail{" +
                "name='" + name + '\'' +
                ", addess='" + addess + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
