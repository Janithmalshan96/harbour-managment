package lk.ijse.harbourmanagment.dao;

import lk.ijse.harbourmanagment.dao.custom.FBDetailDAO;
import lk.ijse.harbourmanagment.dao.custom.impl.*;
import lk.ijse.harbourmanagment.entity.Fisherman;
import lk.ijse.harbourmanagment.entity.OBDetail;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public enum DAOTypes{
        BOAT, FBDETAIL,FISHERMAN,OBDETAIL,OWNER,PAYMENT,REGISTRATION,RSDETAIL,SCHEDULE;
    }

    public DAOFactory() {

    }
    public DAOFactory getInstance(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes)throws Exception{
        switch(daoTypes){

            case BOAT :
                return (T) new ManageBoatDAOImpl();
            case FBDETAIL :
                return (T) new FBDetailDAOImpl();
            case FISHERMAN :
                return (T) new ManageFishermanDAOImpl();
            case OBDETAIL :
                return (T) new OBDetailDAOImpl();
            case OWNER :
                return (T) new ManageOwnerDAOImpl();
            case PAYMENT :
                return (T) new PaymentDAOImpl();
            case REGISTRATION :
                return (T) new RegistrationDAOImpl();
            case RSDETAIL :
                return (T) new RSDetailDAOImpl();
            case SCHEDULE :
                return (T) new ManageScheduleDAOImpl();
                default :
                    return null;
        }
    }
}
