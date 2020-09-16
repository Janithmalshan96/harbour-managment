package lk.ijse.harbourmanagment.bo.custom.impl;

import lk.ijse.harbourmanagment.bo.custom.ManageScheduleBO;
import lk.ijse.harbourmanagment.dao.custom.ManageScheduleDAO;
import lk.ijse.harbourmanagment.dao.custom.RSDetailDAO;
import lk.ijse.harbourmanagment.dao.custom.RegistrationDAO;
import lk.ijse.harbourmanagment.dao.custom.impl.ManageScheduleDAOImpl;
import lk.ijse.harbourmanagment.dao.custom.impl.RSDetailDAOImpl;
import lk.ijse.harbourmanagment.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.harbourmanagment.db.DBConnection;
import lk.ijse.harbourmanagment.dto.ManageScheduleDTO;
import lk.ijse.harbourmanagment.dto.RSDetailDTO;
import lk.ijse.harbourmanagment.dto.RegistrationDTO;
import lk.ijse.harbourmanagment.dto.ScheduleDetailDTO;
import lk.ijse.harbourmanagment.entity.RSDetail;
import lk.ijse.harbourmanagment.entity.Registration;
import lk.ijse.harbourmanagment.entity.Schedule;
import lk.ijse.harbourmanagment.entity.ScheduleDetail;

import java.sql.Connection;
import java.util.ArrayList;

public class ManageScheduleBOImpl implements ManageScheduleBO {

    private ManageScheduleDAO manageScheduleDAO=new ManageScheduleDAOImpl();
    private RegistrationDAO registrationDAO=new RegistrationDAOImpl();
    private RSDetailDAO rsDetailDAO=new RSDetailDAOImpl();

    @Override
    public boolean saveSchedule(RegistrationDTO registrationDTO, ManageScheduleDTO manageScheduleDTO, RSDetailDTO rsDetailDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            Schedule schedule = new Schedule(manageScheduleDTO.getSid(),
                    manageScheduleDTO.getStart_date(),
                    manageScheduleDTO.getEnd_date(),
                    manageScheduleDTO.getCount()
            );

            boolean result = manageScheduleDAO.save((schedule));
            if (!result) {
                connection.rollback();
            }
            Registration registration = new Registration(registrationDTO.getRid(),
                    registrationDTO.getBid(),
                    registrationDTO.getR_date());
            result = registrationDAO.save((registration)
            );

            if (!result) {
                connection.rollback();
                return false;
            }
            RSDetail rsDetail = new RSDetail(0, rsDetailDTO.getRid(),
                    rsDetailDTO.getSid()
            );

            result = rsDetailDAO.save((rsDetail));
            if (!result) {
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
    public boolean updateSchedule(RegistrationDTO registrationDTO, ManageScheduleDTO manageScheduleDTO, RSDetailDTO rsDetailDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {
            Schedule schedule=new Schedule(manageScheduleDTO.getSid(),
                    manageScheduleDTO.getStart_date(),
                    manageScheduleDTO.getEnd_date(),
                    manageScheduleDTO.getCount()
            );

            System.out.println("BOimpl :"+schedule);

            boolean update = manageScheduleDAO.update(schedule);
            if (!update){
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
    public boolean deleteSchedule(String ID) throws Exception {
        return false;
    }

    @Override
    public ManageScheduleDTO searchSchedule(String ID) throws Exception {
        return null;
    }

    @Override
    public ArrayList<ScheduleDetailDTO> getAllSchedules() throws Exception {
        ArrayList<ScheduleDetail>schedules=manageScheduleDAO.getAllSchedules();
        ArrayList<ScheduleDetailDTO>list=new ArrayList<>();
        for (ScheduleDetail scheduleDetail : schedules){
            list.add(new ScheduleDetailDTO(
                    scheduleDetail.getSid(),
                    scheduleDetail.getStart_date(),
                    scheduleDetail.getEnd_date(),
                    scheduleDetail.getCount(),
                    scheduleDetail.getBid()
            ));
        }

        return list;
    }

    @Override
    public ArrayList<ManageScheduleDTO> getAllSchedule() throws Exception {
        ArrayList<Schedule> allSchedule = manageScheduleDAO.getAll();
        ArrayList<ManageScheduleDTO> dtos = new ArrayList<>();
        for (Schedule schedule : allSchedule) {
            dtos.add(new ManageScheduleDTO(
                    schedule.getSid(),
                    schedule.getStart_date(),
                    schedule.getEnd_date(),
                    schedule.getCount()
            ));
        }
        return dtos;
    }
}
