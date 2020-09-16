package lk.ijse.harbourmanagment.common;

import java.text.NumberFormat;

public class IDGenarator {
    public static String getNewId(String tblName, String colName, String prifix)throws  Exception{
        String lastId=IDController.getLastID(tblName, colName);
        if (lastId!=null){
            int id = Integer.parseInt(lastId.split(prifix)[1]);
            id++;
            NumberFormat numberFormat=NumberFormat.getNumberInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newId=numberFormat.format(id);
            return prifix + newId;
        }else{
            return prifix + "001";

        }
    }
}
