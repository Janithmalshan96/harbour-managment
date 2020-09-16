package lk.ijse.harbourmanagment.bo.custom;

import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.FBDetailDTO;
import lk.ijse.harbourmanagment.dto.FishermanDetailDTO;
import lk.ijse.harbourmanagment.dto.ManageBoatDTO;
import lk.ijse.harbourmanagment.dto.ManageFishermanDTO;


import java.util.ArrayList;

public interface ManageFishermanBO extends SuperBO {
    public boolean saveFisherman (ArrayList<ManageFishermanDTO> fishermanDTOS, ArrayList<FBDetailDTO>dtos)throws Exception;
    public boolean updateFisherman (ManageFishermanDTO manageFishermanDTO,ManageBoatDTO boatDTO)throws Exception;
    public boolean deleteFisherman (String Id)throws Exception;
    public ManageFishermanDTO searchFisherman(String Id) throws Exception;
    public ArrayList<ManageFishermanDTO> getAllFishermans()throws Exception;
    public ArrayList<FishermanDetailDTO>getAllFisherman(String Id)throws Exception;
}
