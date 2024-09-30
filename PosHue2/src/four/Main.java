package four;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose calculator:");
            System.out.println("1 = Rational calculator");
            System.out.println("2 = Vector calculator");
            System.out.println("3 = Complex calculator");
            System.out.println("4 = Exit program");
            System.out.print("> ");
            int calculatorChoice = Integer.parseInt(scanner.nextLine());

            if (calculatorChoice == 4) {
                running = false;
                System.out.println("Exiting program...");
                continue;
            }

            System.out.print("Enter number x a> ");
            double xA = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter number x b> ");
            double xB = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter number y a> ");
            double yA = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter number y b> ");
            double yB = Double.parseDouble(scanner.nextLine());

            Number x = new Number(xA, xB);
            Number y = new Number(yA, yB);

            while (true) {
                System.out.println("Choose operation:");
                System.out.println("1 = add");
                System.out.println("2 = subtract");
                System.out.println("3 = multiply");
                System.out.println("4 = divide");
                System.out.println("5 = enter numbers again");
                System.out.print("> ");
                int operationChoice = Integer.parseInt(scanner.nextLine());

                if (operationChoice == 5) {
                    System.out.print("Enter number x a> ");
                    x.setA(Double.parseDouble(scanner.nextLine()));
                    System.out.print("Enter number x b> ");
                    x.setB(Double.parseDouble(scanner.nextLine()));
                    System.out.print("Enter number y a> ");
                    y.setA(Double.parseDouble(scanner.nextLine()));
                    System.out.print("Enter number y b> ");
                    y.setB(Double.parseDouble(scanner.nextLine()));
                    continue;
                }

                AbstractCalculator calculator ;

                switch (calculatorChoice) {
                    case 1:
                        calculator = new RationalCalculator();
                        break;
                    case 2:
                        calculator = new VectorCalculator();
                        break;
                    case 3:
                        calculator = new ComplexCalculator();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        continue;
                }

                Number result;
                switch (operationChoice) {
                    case 1:
                        result = calculator.add(x, y);
                        break;
                    case 2:
                        result = calculator.subtract(x, y);
                        break;
                    case 3:
                        result = calculator.multiply(x, y);
                        break;
                    case 4:
                        result = calculator.divide(x, y);
                        break;
                    default:
                        System.out.println("Invalid operation. Please try again.");
                        continue;
                }

                System.out.println();
                System.out.println("Solution:");
                System.out.println("Result: a = " + result.getA() + ", b = " + result.getB());
                System.out.println();
                break;
            }
        }
    }
}

