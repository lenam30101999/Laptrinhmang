package readAndWriteFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        int choices;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your choice: ");
            System.out.println("0. Out");
            System.out.println("1. Add a student");
            System.out.println("2. Show all student");
            choices = scanner.nextInt();

            switch (choices){
                case 0:
                    break;
                case 1:
                    controller.input();
                    break;
                case 2:
                    controller.output();
                    break;
            }
        }while (choices != 0);
    }
}
