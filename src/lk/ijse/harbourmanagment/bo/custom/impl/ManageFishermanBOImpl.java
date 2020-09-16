package lk.ijse.harbourmanagment.bo.custom.impl;

import lk.ijse.harbourmanagment.bo.custom.ManageFishermanBO;
import lk.ijse.harbourmanagment.dao.custom.FBDetailDAO;
import lk.ijse.harbourmanagment.dao.custom.ManageFishermanDAO;
import lk.ijse.harbourmanagment.dao.custom.ManageScheduleDAO;
import lk.ijse.harbourmanagment.dao.custom.impl.FBDetailDAOImpl;
import lk.ijse.harbourmanagment.dao.custom.impl.ManageFishermanDAOImpl;
import lk.ijse.harbourmanagment.db.DBConnection;
import lk.ijse.harbourmanagment.dto.*;
import lk.ijse.harbourmanagment.entity.FBDetail;
import lk.ijse.harbourmanagment.entity.Fisherman;
import lk.ijse.harbourmanagment.entity.FishermanDetail;
import lk.ijse.harbourmanagment.entity.Schedule;

import java.sql.Connection;
import java.util.ArrayList;

public class ManageFishermanBOImpl implements ManageFishermanBO {
    private ManageFishermanDAO manageFishermanDAO=new ManageFishermanDAOImpl();
    private FBDetailDAO fbDetailDAO=new FBDetailDAOImpl();

    @Override
    public boolean saveFisherman(ArrayList<ManageFishermanDTO> fishermanDTOS, ArrayList<FBDetailDTO>dtos) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);


        try {
            boolean result=false;
            for (ManageFishermanDTO manageFishermanDTO : fishermanDTOS ){
                Fisherman fisherman=new Fisherman(
                        manageFishermanDTO.getFid(),
                        manageFishermanDTO.getName(),
                        manageFishermanDTO.getAddress(),
                        manageFishermanDTO.getNic(),
                        manageFishermanDTO.getContact()
                );

                System.out.println("Fisherman Entity  :"+fisherman);

                result=manageFishermanDAO.save(fisherman);
                if (!result){
                    connection.rollback();
                    return false;
                }
            }

            for (FBDetailDTO dto:dtos) {
                result = fbDetailDAO.save(new FBDetail(0,dto.getBid(),dto.getFid()));
                if (!result){
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
    public boolean updateFisherman(ManageFishermanDTO manageFishermanDTO, ManageBoatDTO boatDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            Fisherman fisherman = new Fisherman(
                    manageFishermanDTO.getFid(),
                    manageFishermanDTO.getName(),
                    manageFishermanDTO.getAddress(),
                    manageFishermanDTO.getNic(),
                    manageFishermanDTO.getContact()
            );
            boolean update = manageFishermanDAO.update(fisherman);
            if (!update) {
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean deleteFisherman(String Id) throws Exception {
        return manageFishermanDAO.delete(Id);
    }

    @Override
    public ManageFishermanDTO searchFisherman(String string) throws Exception {
        System.out.println("ManageBOImpl " + string);
        Fisherman search = manageFishermanDAO.search(string);
        System.out.println("Search    "+search);
        if(search == null){
            throw new Exception();
        }

        return new ManageFishermanDTO(search.getFid(),search.getName(),
                search.getAddress(),search.getNic(),search.getContact());
    }

    @Override
    public ArrayList<ManageFishermanDTO> getAllFishermans() throws Exception {
        ArrayList<Fisherman> allFisherman= manageFishermanDAO.getAll();
        ArrayList<ManageFishermanDTO>dtos=new ArrayList<>();
        for (Fisherman fisherman : allFisherman ){
            dtos.add(new ManageFishermanDTO(
                    fisherman.getFid(),
                    fisherman.getName(),
                    fisherman.getAddress(),
                    fisherman.getNic(),
                    fisherman.getContact()
            ));
        }
        return dtos;
    }

    @Override
    public ArrayList<FishermanDetailDTO> getAllFisherman(String Id) throws Exception {
        ArrayList<FishermanDetail>details=manageFishermanDAO.boatFisherman(Id);
        ArrayList<FishermanDetailDTO>list=new ArrayList<>();
        for (FishermanDetail fishermanDetail : details){
//            System.out.println(fishermanDetail);
            list.add(new FishermanDetailDTO(
                    fishermanDetail.getName(),
                    fishermanDetail.getAddess(),
                    fishermanDetail.getNic()
            ));
        }
        return list;
    }
}
