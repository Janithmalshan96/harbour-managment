package lk.ijse.harbourmanagment.bo.custom;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.FBDetailDTO;

import java.util.ArrayList;

public interface FBDetailBO extends SuperBO {
    public boolean saveFBDetail()throws Exception;
    public boolean updateFBDetail()throws Exception;
    public boolean deleteFBDetail(String ID)throws Exception;
    public FBDetailDTO searchFBDetail(String ID)throws Exception;
    public ArrayList<FBDetailDTO>getAllFBDetails()throws Exception;
    public ArrayList<String>getAllFBDetail()throws Exception;
}
