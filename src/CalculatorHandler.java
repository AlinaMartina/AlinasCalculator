import java.util.StringTokenizer;
/***
 * CalculatorHandler
 *
 * @author Alina Halmesalo Sundberg
 * @version 1.0
 */

public class CalculatorHandler {
    private String countedNumber; // e.g. "3+4"

    public CalculatorHandler() {
        this.countedNumber = "";
    }

    public String getCountedNumber() {
        return this.countedNumber;
    }

    public void setCountedNumber(String button) {
        ButtonPressed(button);
    }

    public void ButtonPressed(String button){
        if(button == "="){
            this.CalculateAnswer();
        } else if (button == "C"){
            this.countedNumber = "";
        } else {
            this.countedNumber = this.countedNumber + button;
        }
    }

    public void CalculateAnswer() {
        try {
            while (true) {
                countedNumber = countedNumber.replace("+", " + ");
                countedNumber = countedNumber.replace("-", " - ");
                countedNumber = countedNumber.replace("*", " * ");
                countedNumber = countedNumber.replace("/", " / ");

                // This if-statement handles negative numbers
                if (countedNumber.startsWith(" - ")) {
                    countedNumber = countedNumber.replaceFirst(" - ", "-");
                }

                // StringTokenizer is used to divide the mathematical expression into the attributes:
                // first number, operator, second number and rest
                StringTokenizer st = new StringTokenizer(countedNumber);

                // If the mathematical expression is e.g. 2*3-5+4: firstNumber = 2,
                // operator = * and secondNumber = 3
                int firstNumber = Integer.parseInt(st.nextToken());
                String operator = st.nextToken();
                int secondNumber = Integer.parseInt(st.nextToken());

                // The remaining part of the mathematical expression, rest = -5+4
                //(In case the expression is e.g. 2*3 then rest = "")
                String rest = "";
                if (st.hasMoreTokens()) {
                    rest = st.nextToken("");
                }

                PerformCalculation(firstNumber, operator, secondNumber);

                if (rest == "") {
                    break;
                } else {
                    countedNumber = countedNumber + rest;
                }
            }

        } catch (Exception e) {
            this.countedNumber = "error";
        }
    }

    public void PerformCalculation ( int firstNumber, String operator, int secondNumber){
       switch (operator) {
           case "+": this.countedNumber = String.valueOf(firstNumber + secondNumber);
           break;

           case "-": this.countedNumber = String.valueOf(firstNumber - secondNumber);
           break;

           case "*": this.countedNumber = String.valueOf(firstNumber * secondNumber);
           break;

           case "/": this.countedNumber = String.valueOf(firstNumber / secondNumber);
           break;
       }
    }
}

