package three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class NumberTester {

    private final String fileName;
    //Map<Integer, Integer> numberMap;
    private NumberTest oddEvenTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    public NumberTester(String fileName) {
        this.fileName=fileName;

    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddEvenTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
             this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] parts = line.split(" ");
                int testType = Integer.parseInt(parts[0]);
                int number = Integer.parseInt(parts[1]);

                switch (testType) {
                    case 1:

                        if (oddEvenTester.testNumber(number)) {
                            System.out.println("EVEN");
                        } else {
                            System.out.println("ODD");
                        }
                        break;
                    case 2:

                        if (primeTester.testNumber(number)) {
                            System.out.println("PRIME");
                        } else {
                            System.out.println("NO PRIME");
                        }
                        break;
                    case 3:

                        if (palindromeTester.testNumber(number)) {
                            System.out.println("PALINDROME");
                        } else {
                            System.out.println("NO PALINDROME");
                        }
                        break;

                }
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public static void main (String[]args) {
            NumberTester numberTester = new NumberTester("5.txt");
            numberTester.setOddEvenTester(number -> number % 2 == 0);
            numberTester.setPrimeTester(number -> {
                for (int i = 2; i < number; i++)
                    if (number % i == 0)return false;
                return true;
            });

            numberTester.setPalindromeTester(number -> {
                if (number < 0) return false;

                int original = number, reversed = 0;

                while (number != 0) {
                    reversed = reversed * 10 + number % 10;
                    number /= 10;
                }
                return original == reversed;
            });
            numberTester.testFile();




        }
    }


