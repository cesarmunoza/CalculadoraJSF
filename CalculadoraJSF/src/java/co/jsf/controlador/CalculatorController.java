package co.jsf.controlador;

import co.jsf.modelo.CalculatorBO;
import co.jsf.modelo.CalculatorBean;

public class CalculatorController {
    private CalculatorBean numbers;
    private CalculatorBO calculador = new CalculatorBO();
    private boolean selectOperationFormRendered=false;
    private boolean newOperationCommandRendered=true;

    public CalculatorBean getNumbers() {
        return numbers;
    }

    public void setNumbers(CalculatorBean numbers) {
        this.numbers = numbers;
    }

    public boolean isSelectOperationFormRendered() {
        return selectOperationFormRendered;
    }

    public void setSelectOperationFormRendered(boolean selectOperationFormRendered) {
        this.selectOperationFormRendered = selectOperationFormRendered;
    }

    public boolean isNewOperationCommandRendered() {
        return newOperationCommandRendered;
    }

    public void setNewOperationCommandRendered(boolean newOperationCommandRendered) {
        this.newOperationCommandRendered = newOperationCommandRendered;
    }
    
    public String doNewOperation(){
        selectOperationFormRendered=true;
        newOperationCommandRendered=false;
        return null;
    }
    
    public String doSelectOperation(){
        selectOperationFormRendered=false;
        newOperationCommandRendered=true;
        return null;
    }
    
    public String doOperation(){
        String operation = numbers.getOperation();
        int primerNumero = numbers.getPrimerNumero();
        int segundoNumero = numbers.getSegundoNumero();
        int result = 0;
        String resultStr = "OK";
        
        if(operation.equals("+")){
            result=calculador.sumar(primerNumero, segundoNumero);
        }else if(operation.equals("-")){
            result=calculador.restar(primerNumero, segundoNumero);
        }
        else if(operation.equals("*")){
            result=calculador.multiplicar(primerNumero, segundoNumero);
        }
        else if(operation.equals("/")){
            result=calculador.dividir(primerNumero, segundoNumero);
        }else
            resultStr="not-OK";
        
        numbers.setResult(result);
        return resultStr;
    }
}
