package lk.ijse.harbourmanagment.dao.custom.impl;

import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.OBDetailDAO;
import lk.ijse.harbourmanagment.entity.OBDetail;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OBDetailDAOImpl implements OBDetailDAO {
    @Override
    public boolean save(OBDetail entity) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO OBDetail VALUES(?,?,?) ",
                entity.getObid(),entity.getOid(),entity.getBid())>0;
    }

    @Override
    public boolean update(OBDetail entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE OBDetail SET bid=?, oid=? WHERE obid=? ",
                entity.getBid(),entity.getOid())>0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM OBDetail WHERE obid=? ",s)>0;
    }

    @Override
    public OBDetail search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM OBDetail WHERE obid=? ", s);
        if (resultSet.next()){
            return new OBDetail(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<OBDetail> getAll() throws Exception {
        ArrayList<OBDetail> obDetails = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM OBDetail");
        while (rst.next()) {
            obDetails.add(new OBDetail(rst.getInt(1), rst.getString(2), rst.getString(3)));
        }
        return obDetails;
    }
}
