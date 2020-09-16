package lk.ijse.harbourmanagment.bo.custom;

import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.ManageBoatDTO;
import lk.ijse.harbourmanagment.dto.OBDetailDTO;
import lk.ijse.harbourmanagment.dto.OwnerDTO;
import lk.ijse.harbourmanagment.entity.OBDetail;

import java.util.ArrayList;

public interface ManageBoatsBO extends SuperBO {
    public boolean saveBoat (ManageBoatDTO boatDTO, OwnerDTO ownerDTO, OBDetailDTO obDetailDTO)throws Exception;
    public boolean updateBoat (ManageBoatDTO boatDTO, OBDetailDTO obDetailDTO)throws Exception;
    public boolean deleteBoat(String Id)throws Exception;
    public ManageBoatDTO searchBoat(String Id) throws Exception;
    public ArrayList<ManageBoatDTO>getAllBoats()throws Exception;
    public ArrayList<String>getAllBoat()throws Exception;
    public ArrayList<ManageBoatDTO>getAllOwnerBoat(String name)throws Exception;


}
