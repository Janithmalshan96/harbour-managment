package lk.ijse.harbourmanagment.bo.custom.impl;

import lk.ijse.harbourmanagment.bo.custom.RegistrationBO;
import lk.ijse.harbourmanagment.dao.custom.RegistrationDAO;
import lk.ijse.harbourmanagment.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.harbourmanagment.db.DBConnection;
import lk.ijse.harbourmanagment.dto.RegistrationDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBO {

    private RegistrationDAO registrationDAO=new RegistrationDAOImpl();

    @Override
    public boolean saveRegistration() throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();

        boolean result=false;

        return false;
    }

    @Override
    public boolean updateRegistration() throws Exception {
        return false;
    }

    @Override
    public boolean deleteRegistration(String ID) throws Exception {
        return false;
    }

    @Override
    public RegistrationDTO searchRegistration(String ID) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegistrations() throws Exception {
        return null;
    }

    @Override
    public ArrayList<String> getAllRegistration() throws Exception {
        return null;
    }
}
