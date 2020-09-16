package lk.ijse.harbourmanagment.bo.custom.impl;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lk.ijse.harbourmanagment.bo.custom.ManageBoatsBO;
import lk.ijse.harbourmanagment.dao.custom.ManageBoatDAO;
import lk.ijse.harbourmanagment.dao.custom.ManageOwnerDAO;
import lk.ijse.harbourmanagment.dao.custom.OBDetailDAO;
import lk.ijse.harbourmanagment.dao.custom.impl.ManageBoatDAOImpl;
import lk.ijse.harbourmanagment.dao.custom.impl.ManageOwnerDAOImpl;
import lk.ijse.harbourmanagment.dao.custom.impl.OBDetailDAOImpl;
import lk.ijse.harbourmanagment.db.DBConnection;
import lk.ijse.harbourmanagment.dto.ManageBoatDTO;
import lk.ijse.harbourmanagment.dto.OBDetailDTO;
import lk.ijse.harbourmanagment.dto.OwnerDTO;
import lk.ijse.harbourmanagment.entity.Boat;
import lk.ijse.harbourmanagment.entity.OBDetail;
import lk.ijse.harbourmanagment.entity.Owner;

import java.sql.Connection;
import java.util.ArrayList;

public class ManageBoatsBOImpl implements ManageBoatsBO {
    private ManageOwnerDAO manageOwnerDAO=new ManageOwnerDAOImpl();
    private OBDetailDAO obDetailDAO=new OBDetailDAOImpl();

    private ManageBoatDAO manageBoatDAO=new ManageBoatDAOImpl();

    @Override
    public boolean saveBoat(ManageBoatDTO boatDTO, OwnerDTO ownerDTO, OBDetailDTO obDetailDTO) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
//        boolean result=false
//        System.out.println(boatDTO.getName());

        try{
            Boat boat=new Boat(boatDTO.getBid(),boatDTO.getName(),boatDTO.getLength(),boatDTO.getColour(),boatDTO.getBoat_type());

            boolean result = manageBoatDAO.save(boat);
            if(!result){
                connection.rollback();
                return false;
            }
            Owner owner1 = manageOwnerDAO.search(ownerDTO.getName());
            if (owner1==null){
                Owner owner=new Owner(ownerDTO.getOid(),ownerDTO.getName(),ownerDTO.getAddress(),ownerDTO.getNic(),ownerDTO.getContact());

//                System.out.println("Owner   : "+owner);

                result=manageOwnerDAO.save((owner));
                if(!result){
                    connection.rollback();
                    return false;
                }
                OBDetail obDetail=new OBDetail(0,obDetailDTO.getBid(),obDetailDTO.getOid());

                result=obDetailDAO.save((obDetail));
                if(!result){
                    connection.rollback();
                    return false;
                }
            }else {
                String id=owner1.getOid();
                OBDetail obDetail=new OBDetail(0,id,boatDTO.getBid());
                System.out.println("Boimpl   "+boatDTO.getBid());

                result=obDetailDAO.save((obDetail));
                if(!result){
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return true;


        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean updateBoat(ManageBoatDTO boatDTO, OBDetailDTO obDetailDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            Boat boat=new Boat(boatDTO.getBid(),boatDTO.getName(),boatDTO.getLength(),boatDTO.getColour(),
                    boatDTO.getBoat_type());
//            System.out.println("ERROR" + boat);
            boolean result = manageBoatDAO.update(boat);
            if(!result){
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;


        }finally {
            connection.setAutoCommit(true);
        }
    }


    @Override
    public boolean deleteBoat(String Id) throws Exception {
        return manageBoatDAO.delete(Id);
    }

    @Override
    public ManageBoatDTO searchBoat(String Id) throws Exception {
        Boat search = manageBoatDAO.search(Id);
        if(search==null){
            throw new Exception();
        }
        return new ManageBoatDTO(search.getBid(),search.getName(),
                search.getLength(),search.getColour(),search.getBoat_type());
    }

    @Override
    public ArrayList<ManageBoatDTO> getAllBoats() throws Exception {
        ArrayList<Boat> allBoat = manageBoatDAO.getAll();
        ArrayList<ManageBoatDTO> dtos = new ArrayList<>();
        for (Boat boat : allBoat ) {
            dtos.add(new ManageBoatDTO(

                    boat.getBid(),
                    boat.getName(),
                    boat.getLength(),
                    boat.getColour(),
                    boat.getBoat_type()
            ));
        }
        return dtos;
    }


    @Override
    public ArrayList<String> getAllBoat() throws Exception {
        return null;
    }

    @Override
    public ArrayList<ManageBoatDTO> getAllOwnerBoat(String name) throws Exception {
        ArrayList<Boat>boats=manageBoatDAO.searchAllBoat(name);
        ArrayList<ManageBoatDTO> dtos = new ArrayList<>();
        for (Boat boat : boats ) {
            dtos.add(new ManageBoatDTO(

                    boat.getBid(),
                    boat.getName(),
                    boat.getLength(),
                    boat.getColour(),
                    boat.getBoat_type()
            ));
        }
        return dtos;
    }

}
