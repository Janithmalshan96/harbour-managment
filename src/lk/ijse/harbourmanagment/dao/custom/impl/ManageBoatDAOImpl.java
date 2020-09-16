package lk.ijse.harbourmanagment.dao.custom.impl;

import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.ManageBoatDAO;
import lk.ijse.harbourmanagment.entity.Boat;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageBoatDAOImpl implements ManageBoatDAO {
    @Override
    public boolean save(Boat entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Boat VALUES(?,?,?,?,?) ",
                entity.getBid(), entity.getName(), entity.getLength(), entity.getColour(), entity.getBoat_type())>0;
    }

    @Override
    public boolean update(Boat entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Boat SET name=?, length=?, colour=?, boat_type=? where bid=? ",
                entity.getName(),entity.getLength(),entity.getColour(),entity.getBoat_type(),entity.getBid())>0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Boat WHERE bid=? ",s)>0;
    }

    @Override
    public Boat search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Boat WHERE bid=? ", s);
        if (resultSet.next()){
            return new Boat(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4),resultSet.getString(5));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Boat> getAll() throws Exception {
       ArrayList<Boat>boats=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM Boat");
        while (rst.next()){
            boats.add(new Boat(rst.getString(1),rst.getString(2),rst.getDouble(3),
                    rst.getString(4),rst.getString(5)));
        }
        return boats;
    }

    @Override
    public ArrayList<Boat> searchName(String s) throws Exception {
        ResultSet set = CrudUtil.executeQuery("select b.bid, b.name, b.length, b.colour,b.boat_type   from " +
                "Owner o, Boat b, OBDetail ob where\n" +
                "ob.oid=o.oid && ob.bid=b.bid && o.name=?;",s);
        ArrayList<Boat>list=new ArrayList<>();
        while (set.next()){
            list.add(new Boat(set.getString(1),set.getString(2),set.getDouble(3),
                    set.getString(4), set.getString(5)));
        }
        return list;
    }

    @Override
    public ArrayList<Boat> searchAllBoat(String name) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("select b.bid,b.name,b.length,b.colour,b.boat_type from " +
                "owner o,obdetail d,boat b where o.oid=d.oid AND b.bid=d.bid AND o.name=? ", name);
        ArrayList<Boat>boats=new ArrayList<>();
        while (resultSet.next()){
            boats.add(new Boat(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5)));

        }
        return boats;
    }
}
