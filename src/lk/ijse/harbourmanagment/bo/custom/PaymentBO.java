package lk.ijse.harbourmanagment.bo.custom;

import lk.ijse.harbourmanagment.bo.SuperBO;
import lk.ijse.harbourmanagment.dto.PaymentDTO;
import lk.ijse.harbourmanagment.dto.RegistrationDTO;

import java.util.ArrayList;

public interface PaymentBO extends SuperBO {
    public boolean savePayment(PaymentDTO paymentDTO)throws Exception;
    public boolean updatePayment(PaymentDTO paymentDTO)throws Exception;
    public boolean deletePayment(String ID)throws Exception;
    public PaymentDTO searchPayment(String ID)throws Exception;
    public ArrayList<PaymentDTO>getAllPayments()throws Exception;
    public ArrayList<String>getAllPayment()throws Exception;
}
