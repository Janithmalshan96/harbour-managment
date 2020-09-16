package lk.ijse.harbourmanagment.dao.custom.impl;

import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.ManageOwnerDAO;
import lk.ijse.harbourmanagment.entity.Owner;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageOwnerDAOImpl implements ManageOwnerDAO {
    @Override
    public boolean save(Owner entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Owner VALUES(?,?,?,?,?) ",
                entity.getOid(),entity.getName(),entity.getAddress(),entity.getNic(),entity.getContact())>0;
    }

    @Override
    public boolean update(Owner entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Owner SET name=?, address=?, nic=?, contact=? WHERE oid=? ",
                entity.getName(),entity.getAddress(),entity.getNic(),entity.getContact(),entity.getOid())>0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Owner WHERE oid=? ",s)>0;
    }

    @Override
    public Owner search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Owner WHERE name=? ", s);
        if(resultSet.next()){
            return new Owner(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                    resultSet.getString(4),resultSet.getString(5));
        }
        return null;
    }

    @Override
    public ArrayList<Owner> getAll() throws Exception {
        ArrayList<Owner>owners=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Owner");
        while (rst.next()){
            owners.add(new Owner(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getString(5)));
        }
        return owners;
    }
}
