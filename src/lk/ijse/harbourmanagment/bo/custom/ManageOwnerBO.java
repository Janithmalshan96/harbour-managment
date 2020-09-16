package lk.ijse.harbourmanagment.bo.custom;

import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.OwnerDTO;

import java.util.ArrayList;

public interface ManageOwnerBO extends SuperBO {
    public boolean saveOwner()throws Exception;
    public boolean updateOwner()throws Exception;
    public boolean deleteOwner(String ID)throws Exception;
    public OwnerDTO searchOwner(String ID)throws Exception;
    public ArrayList<OwnerDTO>getAllOwners()throws Exception;
    public ArrayList<String>getAllOwner()throws Exception;

}
