package lk.ijse.harbourmanagment.dao.custom;

import lk.ijse.harbourmanagment.dao.CrudDAO;
import lk.ijse.harbourmanagment.dto.FishermanDetailDTO;
import lk.ijse.harbourmanagment.dto.ManageFishermanDTO;
import lk.ijse.harbourmanagment.entity.Fisherman;
import lk.ijse.harbourmanagment.entity.FishermanDetail;

import java.util.ArrayList;

public interface ManageFishermanDAO extends CrudDAO<Fisherman, String> {

    public ArrayList<FishermanDetail> boatFisherman(String Id)throws Exception;
}
