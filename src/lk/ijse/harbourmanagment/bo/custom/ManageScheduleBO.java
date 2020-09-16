package lk.ijse.harbourmanagment.bo.custom;

import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.ManageScheduleDTO;
import lk.ijse.harbourmanagment.dto.RSDetailDTO;
import lk.ijse.harbourmanagment.dto.RegistrationDTO;
import lk.ijse.harbourmanagment.dto.ScheduleDetailDTO;

import java.util.ArrayList;

public interface ManageScheduleBO extends SuperBO {
    public boolean saveSchedule(RegistrationDTO registrationDTO, ManageScheduleDTO manageScheduleDTO, RSDetailDTO rsDetailDTO)throws Exception;
    public boolean updateSchedule(RegistrationDTO registrationDTO, ManageScheduleDTO manageScheduleDTO, RSDetailDTO rsDetailDTO)throws Exception;
    public boolean deleteSchedule(String ID)throws Exception;
    public ManageScheduleDTO searchSchedule(String ID)throws Exception;
    public ArrayList<ScheduleDetailDTO>getAllSchedules()throws Exception;
    public ArrayList<ManageScheduleDTO>getAllSchedule()throws Exception;
}
