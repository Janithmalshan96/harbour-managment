package lk.ijse.harbourmanagment.validation;

public class Validation {
    public static boolean nameValidation(String name){
        if (name.trim().isEmpty()){
            return false;
        }
        if (!name.matches("[A-z.]+")){
            return false;
        }
        return true;
    }
    public static boolean contactNoValidation(String number){
        if (number.trim().isEmpty()){
            return false;
        }
        if (!number.matches("[0-9]{10}")){
            return false;
        }
        return true;
    }
    public static boolean addressValidation(String address){
        if (address.trim().isEmpty()){
            return false;
        }
        if (!address.matches("[A-z,]+")){
            return false;
        }
        return true;
    }
    public static boolean isNotEmptyValidation(String text){
        if (!text.trim().isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean doubleValueValidation(String value){
        if (value.trim().isEmpty()){
            return false;
        }
        if(!value.matches("\\d+(\\.\\d{2}|\\.\\d{1})?")){
            return false;
        }
        return true;
    }
    public static boolean intValueValidation(String value){
        if (value.trim().isEmpty()){
            return false;
        }
        if (!value.matches("[0-9]+")){
            return false;
        }
        return true;
    }
    public static boolean nicValidation(String nic){
        if (nic.trim().isEmpty()){
            return false;
        }
        if (!nic.matches("[0-9]{9}[vVwW]")){
            return false;
        }
        return true;
    }
    public static boolean passportNoValidation(String id){
        if (id.trim().isEmpty()){
            return false;
        }
        if (!id.trim().isEmpty()){
            return false;
        }
        return true;
    }
}
