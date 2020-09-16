package lk.ijse.harbourmanagment.dao.custom;

import lk.ijse.harbourmanagment.dao.CrudDAO;
import lk.ijse.harbourmanagment.entity.Boat;

import java.util.ArrayList;

public interface ManageBoatDAO extends CrudDAO<Boat,String> {
    public ArrayList<Boat> searchName(String s) throws Exception;
    public ArrayList<Boat> searchAllBoat(String name)throws Exception;

}
