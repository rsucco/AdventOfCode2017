import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File("data.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> statements = new ArrayList<String>();
        //Copy file to statements ArrayList
        while (scanner.hasNextLine()) {
            statements.add(scanner.nextLine());
        }
        ArrayList<String> registers = initRegisters(statements); //Initialize the registers to 0


        for (String statement : statements) {
            String expression = statement.substring(statement.indexOf("if") + 3, statement.length());
            if (evalExpression(getFirstOperand(expression), getSecondOperand(expression), getOperator(expression), registers)) {
                registers = executeCommand(statement, registers);
            }
        }
        int biggestVal = 0;
        for (String register : registers) {
            register = register.substring(0, register.indexOf("="));
            if (getRegValue(registers, register) > biggestVal)
                biggestVal = getRegValue(registers, register);
        }
        System.out.println (biggestVal);
    }

    public static ArrayList<String> executeCommand(String statement, ArrayList<String>registers) {
        String command = statement.substring(0, statement.indexOf("if"));
        char incdec = getIncDec(command);
        int num = getSecondOperand(command);
        String register = statement.substring(0, statement.indexOf(" "));
        if (incdec == 'i') {
            registers = setRegisters(registers, register, getRegValue(registers, register) + num);
        } else {
            registers = setRegisters(registers, register, getRegValue(registers, register) - num);
        }
        return registers;

    }

    //Initializes all registers and sets their values to 0
    public static ArrayList<String> initRegisters(ArrayList<String> statements) {
        ArrayList<String> registers = new ArrayList<String>();
        for (String statement : statements)
            if (!registers.contains(statement.substring(0, statement.indexOf(" ")) + "=0"))
                registers.add(statement.substring(0, statement.indexOf(" ")) + "=0");
        return registers;
    }

    public static int getRegister(ArrayList<String> registers, String register) {
        for (String reg : registers)
            if (reg.substring(0, reg.indexOf("=")).equals(register))
                return Integer.parseInt(reg.substring(reg.indexOf("=") + 1, reg.length()));
        return 0;
    }

    public static ArrayList<String> setRegisters(ArrayList<String> registers, String register, int num) {
        ArrayList<String> newRegisters = new ArrayList<String>();
        for (String reg : registers) {
            if (reg.substring(0, reg.indexOf("=")).equals(register))
                newRegisters.add(register + "=" + num);
            else
                newRegisters.add(reg);
        }
        return newRegisters;
    }

    //Gets the register to evaluate the expression on
    public static String getFirstOperand(String statement) {
        return statement.substring(0, statement.indexOf(" "));
    }

    //Gets the number to evaluate the expression on
    public static int getSecondOperand(String statement) {
        char[] statementC = statement.toCharArray();
        String operand = new String();
        for (char character : statementC) {
            if (Character.isDigit(character) || character == '-')
                operand = operand + character;
        }
        return Integer.parseInt(operand);
    }

    //Gets the operator to evaluate the expression on
    public static String getOperator(String statement) {
        if (statement.contains(" > ")) {
            return ">";
        } else if (statement.contains(" == ")) {
            return "==";
        } else if (statement.contains(" < ")) {
            return "<";
        } else if (statement.contains(" <= ")) {
            return "<=";
        } else if (statement.contains(" >= ")) {
            return ">=";
        } else {
            return "!=";
        }
    }

    //Evaluates the expression
    public static boolean evalExpression(String regOperand, int numOperand, String operator, ArrayList<String> registers) {
        switch (operator) {
            case "==":
               if (getRegValue(registers, regOperand) == numOperand)
                   return true;
               else
                   return false;
            case "!=":
                if (getRegValue(registers, regOperand) != numOperand)
                    return true;
                else
                    return false;
            case ">":
                if (getRegValue(registers, regOperand) > numOperand)
                    return true;
                else
                    return false;
            case "<":
                if (getRegValue(registers, regOperand) < numOperand)
                    return true;
                else
                    return false;
            case ">=":
                if (getRegValue(registers, regOperand) >= numOperand)
                    return true;
                else
                    return false;
            case "<=":
                if (getRegValue(registers, regOperand) <= numOperand)
                    return true;
                else
                    return false;
        }

        return true;
    }

    public static int getRegValue(ArrayList<String> registers, String register)  {
        for (String reg : registers) {
                if (reg.length() >= register.length()) {
                    if ((reg.substring(0, reg.indexOf("=")) + " ").equals(register + " ")) {
                        return Integer.parseInt(reg.substring(reg.indexOf("=") + 1, reg.length()));
                    }
                }
        }
        return 0;
    }

    public static char getIncDec(String command) {
        if (command.contains("inc"))
            return 'i';
        else
            return 'd';
    }

}