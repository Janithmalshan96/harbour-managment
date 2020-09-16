package lk.ijse.harbourmanagment.common;

import lk.ijse.harbourmanagment.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IDController {
    public static String getLastID(String tblName,String coloumName)throws Exception{
        String sql="SELECT "+coloumName+ " FROM " +tblName+ " order by 1 desc limit 1";
        Connection connection= DBConnection.getInstance().getConnection();
        Statement statement=connection.createStatement();
        ResultSet set = statement.executeQuery(sql);
        if (set.next()){
            return set.getString(1);
        }
        return null;
    }
}
