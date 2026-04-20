package util;

import java.util.Scanner;

public class TextUI {

    private Scanner scan = new Scanner(System.in);


    public void displayMessage(String message){
        System.out.println(message);
    }

    public String getUserInput(String prompt){
        System.out.println(prompt);
        return scan.nextLine();
    }

    public String promptForUsername(){
        System.out.println("Indtast brugernavn: ");
        return scan.nextLine();

    }
    public String promptForPassword(){
        System.out.println("Indtast password: ");
        return scan.nextLine();

    }

}
