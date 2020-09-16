package lk.ijse.harbourmanagment.dao.custom.impl;

import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.FBDetailDAO;
import lk.ijse.harbourmanagment.entity.FBDetail;

import java.util.ArrayList;

public class FBDetailDAOImpl implements FBDetailDAO {
    @Override
    public boolean save(FBDetail entity) throws Exception {
        return CrudUtil.executeUpdate("insert into FBDetail values(?,?,?)",
                entity.getFbid(),entity.getBid(),entity.getFid())>0;
    }

    @Override
    public boolean update(FBDetail entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public FBDetail search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<FBDetail> getAll() throws Exception {
        return null;
    }
}
