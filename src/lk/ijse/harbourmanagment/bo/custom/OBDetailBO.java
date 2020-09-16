package lk.ijse.harbourmanagment.bo.custom;

import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.OBDetailDTO;

import java.util.ArrayList;

public interface OBDetailBO extends SuperBO {
    public boolean saveOBDetail()throws Exception;
    public boolean updateOBDetail()throws Exception;
    public boolean deleteOBDetail(String ID)throws Exception;
    public OBDetailDTO searchOBDetail(String ID)throws Exception;
    public ArrayList<OBDetailDTO>getAllOBDetails()throws Exception;
    public ArrayList<String>getAllOBDetail()throws Exception;

}
