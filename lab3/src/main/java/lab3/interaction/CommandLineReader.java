package lab3.interaction;

import lab3.functionality.Reader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandLineReader implements Reader {

    Scanner scanner = new Scanner(System.in);
    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public int readInt() {
        while (true) {
            try {
                System.out.print("Введите число: ");
                var result = scanner.nextInt();
                System.out.println();
                return result;
            } catch (InputMismatchException e) {
                System.out.println("Необходимо ввести число!");
            } finally {
                scanner.nextLine();
            }
        }
    }
}
