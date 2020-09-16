package lk.ijse.harbourmanagment.entity;

public class Boat {
    private String bid;
    private String name;
    private double length;
    private String colour;
    private String boat_type;

    public Boat(String bid) {

    }

    public Boat(String bid, String name, double length, String colour, String boat_type) {
        this.bid = bid;
        this.name = name;
        this.length = length;
        this.colour = colour;
        this.boat_type = boat_type;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getBoat_type() {
        return boat_type;
    }

    public void setBoat_type(String boat_type) {
        this.boat_type = boat_type;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "bid='" + bid + '\'' +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", colour='" + colour + '\'' +
                ", boat_type='" + boat_type + '\'' +
                '}';
    }
}

