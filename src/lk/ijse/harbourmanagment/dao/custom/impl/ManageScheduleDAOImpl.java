package lk.ijse.harbourmanagment.dao.custom.impl;

import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.ManageFishermanDAO;
import lk.ijse.harbourmanagment.dao.custom.ManageScheduleDAO;
import lk.ijse.harbourmanagment.entity.Fisherman;
import lk.ijse.harbourmanagment.entity.Schedule;
import lk.ijse.harbourmanagment.entity.ScheduleDetail;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ManageScheduleDAOImpl implements ManageScheduleDAO {

    @Override
    public boolean save(Schedule entity) throws Exception {
        System.out.println("Schedule Query  "+entity);
        return CrudUtil.executeUpdate("INSERT INTO Schedule VALUES(?,?,?,?) ",
                entity.getSid(),entity.getStart_date(),entity.getEnd_date(),entity.getCount())>0;
    }

    @Override
    public boolean update(Schedule entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Schedule SET start_date=?, end_date=? WHERE sid=? ",
                entity.getStart_date(),entity.getEnd_date(),entity.getCount(),entity.getSid())>0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Schedule search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT*FROM Schedule WHERE sid=? ", s);
        if (resultSet.next()){
            return new Schedule(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
        }
        return null;
    }

    @Override
    public ArrayList<Schedule> getAll() throws Exception {
        ArrayList<Schedule>schedules=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Schedule ");
        while (rst.next()){
            schedules.add(new Schedule(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4)));
        }
        return schedules;
    }

    @Override
    public ArrayList<ScheduleDetail> getAllSchedules() throws Exception {

        ResultSet resultSet = CrudUtil.executeQuery("select s.sid, s.start_date, s.end_date, s.count, b.bid from \n" +
                "boat b, registration r, rsdetail rs, schedule s where\n" +
                "b.bid=r.bid && r.rid=rs.rid && s.sid=rs.sid " );
        ArrayList<ScheduleDetail>list=new ArrayList<>();
        while (resultSet.next()){
            list.add(new ScheduleDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            ));
        }

        return list;
    }

//    @Override
//    public ArrayList<Schedule> allSchedules(String Id) throws Exception {
//        ResultSet resultSet = CrudUtil.executeQuery("\n" +
//                "select s.sid, s.start_date, s.end_date, s.count, b.bid from \n" +
//                "boat b, registration r, rsdetail rs, schedule s where\n" +
//                "b.bid=r.bid && r.rid=rs.rid && s.sid=rs.sid && s.sid=? ", Id);
//        ArrayList<Schedule>schedules=new ArrayList<>();
////        while(resultSet.next()){
////            schedules.add(new Schedule(resultSet.getString(1),
////                    resultSet.getString(2),
////                    resultSet.getString(3),
////                    resultSet.getInt(4),
////                    resultSet.getString(5)
////                    ));
////        }
//        return schedules;
//    }


}
