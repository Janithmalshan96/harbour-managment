package lk.ijse.harbourmanagment.dao.custom.impl;

import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.RSDetailDAO;
import lk.ijse.harbourmanagment.entity.RSDetail;

import java.util.ArrayList;

public class RSDetailDAOImpl implements RSDetailDAO {
    @Override
    public boolean save(RSDetail entity) throws Exception {
        System.out.println("DAOImpl :"+entity.toString());
        return CrudUtil.executeUpdate("INSERT INTO RSDetail VALUES(?,?,?) ",
                entity.getRsid(),entity.getRid(),entity.getSid())>0;
    }

    @Override
    public boolean update(RSDetail entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public RSDetail search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RSDetail> getAll() throws Exception {
        return null;
    }
}
