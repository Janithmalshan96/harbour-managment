package lk.ijse.harbourmanagment.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.harbourmanagment.dao.CrudUtil;
import lk.ijse.harbourmanagment.dao.custom.PaymentDAO;
import lk.ijse.harbourmanagment.entity.Payment;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment entity) throws Exception {
        System.out.println("DAOImpl :"+entity);
        return CrudUtil.executeUpdate("INSERT INTO Payment VALUES(?,?,?,?) ",
                entity.getPid(),entity.getRid(),entity.getAmount(),entity.getP_date())>0;
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Payment SET rid=?, amount=?, p_date=? WHERE pid=? ",
                entity.getRid(),entity.getAmount(),entity.getP_date(),entity.getPid())>0;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Payment WHERE pid=? ",s)>0;
    }

    @Override
    public Payment search(String s) throws Exception {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM Payment WHERE pid=? ", s);
        if (resultSet.next()){
            return new Payment(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getDouble(3),resultSet.getString(4));
        }else {
            return null;
        }
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        ArrayList<Payment>payments=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Payment ");
        while (rst.next()){
            payments.add(new Payment(rst.getString(1),rst.getString(2),rst.getDouble(3),
                    rst.getString(4)));
        }
        return payments;
    }
}
