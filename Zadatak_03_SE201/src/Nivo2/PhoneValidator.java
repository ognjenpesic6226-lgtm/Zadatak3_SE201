package Nivo2;

import java.util.Scanner;

public class PhoneValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite broj telefona:");

        String phone = scanner.nextLine();

        String regex = "^\\+[0-9]{1,3}\\s[0-9]{3}-[0-9]{3}-[0-9]{4}$";

        if (phone.matches(regex)) {
            System.out.println("Validan broj");
        } else {
            System.out.println("Los broj");
        }
    }
}