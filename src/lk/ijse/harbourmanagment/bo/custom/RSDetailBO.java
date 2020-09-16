package lk.ijse.harbourmanagment.bo.custom;

import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.RSDetailDTO;

import java.util.ArrayList;

public interface RSDetailBO extends SuperBO {
    public boolean saveRSDetail()throws Exception;
    public boolean updateRSDetail()throws Exception;
    public boolean deleteRSDetail(String ID)throws Exception;
    public RSDetailDTO searchRSDetail(String ID)throws Exception;
    public ArrayList<RSDetailDTO>getAllRSDetails()throws Exception;
    public ArrayList<String>getAllRSDetail()throws Exception;
}
