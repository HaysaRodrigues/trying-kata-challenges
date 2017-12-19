package haysarodrigues.application;

import java.util.Scanner;

/**
 * @author haysa
 */
public class ScanItems {

    public static void main(String[] args) {

        String text;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your product in the cart:");
        text = input.next();


        System.out.println(text);

    }
}
