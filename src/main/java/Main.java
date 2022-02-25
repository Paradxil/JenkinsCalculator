import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String [] args) throws IOException {
        Calculator calc = new Calculator();

        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Enter command:");
        String input = reader.readLine();

        while(!input.equals("exit") && !input.equals("quit")) {
            String[] inputs = input.split(" ");
            String cmd = inputs[0];
            Integer[] values = new Integer[inputs.length - 1];

            for(int i = 1; i < inputs.length; i++) {
                values[i - 1] = Integer.parseInt(inputs[i]);
            }

            Integer output = null;
            String op = null;

            switch (cmd) {
                case "add":
                    output = calc.add(values[0], values[1]);
                    op = "+";
                    break;
                case "sub":
                    output = calc.subtract(values[0], values[1]);
                    op = "-";
                    break;
                case "multiply":
                    output = calc.multiply(values[0], values[1]);
                    op = "*";
                    break;
                case "divide":
                    output = calc.divide(values[0], values[1]);
                    op = "/";
                    break;
                case "fib":
                    System.out.println(calc.fibonacciNumberFinder(values[0]));
                    break;
                case "binary":
                    System.out.println(calc.intToBinaryNumber(values[0]));
                    break;
                case "help":
                    System.out.println("  add <x> <y>");
                    System.out.println("  sub <x> <y>");
                    System.out.println("  multiply <x> <y>");
                    System.out.println("  divide <x> <y>");
                    System.out.println("  fib <x>");
                    System.out.println("  binary <x>");
                    System.out.println("  \"quit\" or \"exit\" to exit.");
                    break;
                default:
                    System.out.println("Invalid input. Type \"help\" for a list of commands.");
            }

            if(output != null) {
                System.out.println(values[0].toString() + " " + op + " " + values[1].toString() + " = " + output.toString());
            }

            // Reading next command
            System.out.println("Enter command:");
            input = reader.readLine();
        }
    }
}
