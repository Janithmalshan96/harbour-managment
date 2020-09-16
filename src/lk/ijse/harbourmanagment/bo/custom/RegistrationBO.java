package lk.ijse.harbourmanagment.bo.custom;

import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.RegistrationDTO;

import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {
    public boolean saveRegistration()throws Exception;
    public boolean updateRegistration()throws Exception;
    public boolean deleteRegistration(String ID)throws Exception;
    public RegistrationDTO searchRegistration(String ID)throws Exception;
    public ArrayList<RegistrationDTO>getAllRegistrations()throws Exception;
    public ArrayList<String>getAllRegistration()throws Exception;
}
