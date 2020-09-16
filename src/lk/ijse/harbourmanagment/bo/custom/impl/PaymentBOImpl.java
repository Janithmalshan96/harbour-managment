package lk.ijse.harbourmanagment.bo.custom.impl;

import lk.ijse.harbourmanagment.bo.custom.PaymentBO;
import lk.ijse.harbourmanagment.dao.custom.PaymentDAO;
import lk.ijse.harbourmanagment.dao.custom.RegistrationDAO;
import lk.ijse.harbourmanagment.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.harbourmanagment.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.harbourmanagment.db.DBConnection;
import lk.ijse.harbourmanagment.dto.PaymentDTO;
import lk.ijse.harbourmanagment.dto.RegistrationDTO;
import lk.ijse.harbourmanagment.entity.Payment;
import lk.ijse.harbourmanagment.entity.Registration;

import java.sql.Connection;
import java.util.ArrayList;

public class PaymentBOImpl implements PaymentBO {

    private PaymentDAO paymentDAO=new PaymentDAOImpl();

    @Override
    public boolean savePayment(PaymentDTO paymentDTO) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            Payment payment=new Payment(
                    paymentDTO.getPid(),
                    paymentDTO.getRid(),
                    paymentDTO.getAmount(),
                    paymentDTO.getP_date()
            );
            boolean result=paymentDAO.save(payment);
            if (!result){
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
    public boolean updatePayment(PaymentDTO paymentDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            Payment payment = new Payment(
                    paymentDTO.getPid(),
                    paymentDTO.getRid(),
                    paymentDTO.getAmount(),
                    paymentDTO.getP_date()
            );
            System.out.println("BOIMPL :"+paymentDTO.getPid());
            System.out.println("BOImpl  :"+payment);
            boolean update = paymentDAO.update(payment);
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
    public boolean deletePayment(String ID) throws Exception {
        return paymentDAO.delete(ID);
    }

    @Override
    public PaymentDTO searchPayment(String ID) throws Exception {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayments() throws Exception {
        ArrayList<Payment>list=paymentDAO.getAll();
        ArrayList<PaymentDTO>paymentDTOS=new ArrayList<>();
        for (Payment payment : list){
            paymentDTOS.add(new PaymentDTO(
                    payment.getPid(),
                    payment.getRid(),
                    payment.getAmount(),
                    payment.getP_date()
            ));
        }
        return paymentDTOS;
    }

    @Override
    public ArrayList<String> getAllPayment() throws Exception {
        return null;
    }
}
