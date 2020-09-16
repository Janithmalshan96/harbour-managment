package lk.ijse.harbourmanagment.dao.custom.impl;

import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.ManageFishermanDAO;
import lk.ijse.harbourmanagment.dto.FishermanDetailDTO;
import lk.ijse.harbourmanagment.dto.ManageFishermanDTO;
import lk.ijse.harbourmanagment.entity.Fisherman;
import lk.ijse.harbourmanagment.entity.FishermanDetail;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageFishermanDAOImpl implements ManageFishermanDAO {

    @Override
    public boolean save(Fisherman entity) throws Exception {
//        System.out.println(entity.getName());
//        System.out.println(entity.getAddress());

        return CrudUtil.executeUpdate("insert into fisherman values(?,?,?,?,? ) ",
                entity.getFid(),
                entity.getName(),
                entity.getAddress(),
                entity.getNic(),
                entity.getContact()
        )>0;

    }

    @Override
    public boolean update(Fisherman entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Fisherman SET name=?, address=?,nic=? contact=? where fid=? ",
                entity.getName(),entity.getAddress(),entity.getNic(),entity.getContact(),entity.getFid())>0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Fisherman WHERE fid=? ",s)>0;
    }

    @Override
    public Fisherman search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Fisherman WHERE name=? ", s);
        if (resultSet.next()){
            System.out.println(resultSet);
            return new Fisherman(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Fisherman> getAll() throws Exception {
        ArrayList<Fisherman>fishermen=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * From Fisherman");
        while (rst.next()){
            fishermen.add(new Fisherman(rst.getString(1),rst.getString(2),
                    rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return fishermen;
    }

    @Override
    public ArrayList<FishermanDetail>boatFisherman(String Id) throws Exception {
        ResultSet query = CrudUtil.executeQuery("select f.name, f.address, f.nic from \n" +
                "boat b, fisherman f, fbdetail fb where\n" +
                "f.fid=fb.fid && fb.bid=b.bid && b.bid=? ",Id);
        ArrayList<FishermanDetail>list=new ArrayList<>();
        while (query.next()){
            list.add(new FishermanDetail(
                    query.getString(1),
                    query.getString(2),
                    query.getString(3)
            ));
        }
        return list;
    }

//    @Override
//    public ArrayList<Fisherman> searchFisherman(String s) throws Exception {
//        ResultSet set=CrudUtil.executeQuery("select fid, name, address, nic, contact from fisherman where name=?; ",s);
//        ArrayList<Fisherman>list=new ArrayList<>();
//        while (set.next()){
//            list.add(new Fisherman(set.getString(1),set.getString(2),set.getString(3),set.getString(4),
//                    set.getString(5)));
//        }
//        return list;
//    }
}
