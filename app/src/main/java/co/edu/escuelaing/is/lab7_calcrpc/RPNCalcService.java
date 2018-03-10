package co.edu.escuelaing.is.lab7_calcrpc;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by carlos on 9/03/18.
 */

public class RPNCalcService extends CalcService{

    public RPNCalcService(){
        super();
    }

    private Double compute(String[] expr) throws ArithmeticException, EmptyStackException, ServicesException {
        Stack<Double> stack = new Stack<>();

        for (String token : expr) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    double divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                case "^":
                    double exponent = stack.pop();
                    stack.push(Math.pow(stack.pop(), exponent));
                    break;
                case "SIN":
                    if(stack.size()>0){
                        stack.push(Math.sin(stack.pop()));
                    }
                    break;
                case "COS":
                    if(stack.size()>0){
                        stack.push(Math.cos(stack.pop()));
                    }
                    break;
                case "TAN":
                    if(stack.size()>0){
                        stack.push(Math.tan(stack.pop()));
                    }
                    break;
                default:
                    stack.push(checkDouble(token));
                    break;
            }
        }
        Double eval = stack.pop();
        System.out.println("Final Answer: " + eval);
        return eval;
    }



    @Override
    public String addValue(String num) {
        current += num;
        return current;
    }

    @Override
    public String deleteLastValue() {
        if(current.length()>0){
            current = current.substring(0,current.length()-1);
        }
        return current;
    }

    @Override
    public String evalExpression() {
        String[] splitValues = current.split(" ");
        try{
            Double evalCompute = compute(splitValues);
            if((evalCompute > Math.floor(evalCompute))){
                String roundCalc = Double.toString(evalCompute);
                if(roundCalc.length()>6){
                    return roundCalc.substring(0,6);
                }
                return roundCalc;
            }else{
                return Integer.toString(evalCompute.intValue());
            }
        }catch(ArithmeticException | EmptyStackException | ServicesException ex){
            return null;
        }

    }


}
