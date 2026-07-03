package Nivo1;

import java.util.Scanner;

public class NumberValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesi broj telefona: ");
        String phoneNumber = scanner.nextLine();

        if (phoneNumber.matches("\\d{10}")) {
            System.out.println("Broj telefona je validan");
        } else {
            System.out.println("Samo 10 broja mora da bude unos");
        }

        scanner.close();
    }
}

