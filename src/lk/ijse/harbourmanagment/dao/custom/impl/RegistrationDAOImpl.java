package lk.ijse.harbourmanagment.dao.custom.impl;

import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.RegistrationDAO;
import lk.ijse.harbourmanagment.entity.Registration;

import java.util.ArrayList;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean save(Registration entity) throws Exception {
        System.out.println(entity.getRid());
        return CrudUtil.executeUpdate("INSERT INTO Registration VALUES(?,?,?) ",
                entity.getRid(),entity.getBid(),entity.getR_date())>0;
    }

    @Override
    public boolean update(Registration entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Registration search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
        return null;
    }
}
