package lk.ijse.harbourmanagment.dao.custom;

import lk.ijse.harbourmanagment.dao.CrudDAO;
import lk.ijse.harbourmanagment.entity.Schedule;
import lk.ijse.harbourmanagment.entity.ScheduleDetail;

import java.util.ArrayList;

public interface ManageScheduleDAO extends CrudDAO<Schedule,String> {
//    ArrayList<Schedule>allSchedules(String Id)throws Exception;
    ArrayList<ScheduleDetail>getAllSchedules()throws Exception;
}
