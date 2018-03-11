package co.edu.escuelaing.is.lab7_calcrpc;

/**
 * Created by carlos on 9/03/18.
 */

public abstract class CalcService {

    String current;

    public CalcService(){
        current = "";
    }

    int checkInteger(String num) throws ServicesException{
        try{
            return Integer.parseInt(num);
        }catch(NumberFormatException ex){
            throw new ServicesException("Error integer conversion");
        }
    }

    double checkDouble(String num) throws ServicesException{
        try{
            return Double.parseDouble(num);
        }catch(NumberFormatException ex){
            throw new ServicesException("Error double conversion");
        }
    }

    boolean spaceValidation(){
        if(current.length()>0){
            if(current.substring(current.length()-1).equals(" ")){
                return true;
            }
        }else{
            return true;
        }
        return false;
    }

    boolean decimalValidation(){
        if(current.length()>0){
            String lastValue = current.substring(current.length()-1);
            if("+-*/^ .NS".indexOf(lastValue) >= 0){
                return true;
            }
        }else{
            return true;
        }
        return false;
    }

    void resetValues(){
        current = "";
    }

    abstract boolean TrigonometricValidation();

    abstract String addValue(String num);

    abstract String deleteLastValue();

    abstract String evalExpression();

}
