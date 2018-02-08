package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    //User Menu to prompt user for library options

    private Scanner input = new Scanner(System.in);
    public void startMenu() {

        System.out.println("Welcome to the video game library. What would you like to do? \n" +
                "1. Add a Game to the library \n" +
                "2. Remove a game from the library \n" +
                "3. View what is currently in the library \n" +
                "4. Check out a game \n" +
                "5. Check in a game \n" +
                "6. View checked out games \n" +
                "7. Exit");
        try {


            switch (input.nextInt()) {
                case 1:
                    //Add game
                    System.out.println("What is the name of the game you would like to add?");

                    break;
                case 2:
                    //Remove game
                    break;
                case 3:
                    //View library
                    break;
                case 4:
                    //Check out
                    break;
                case 5:
                    //check in
                    break;
                case 6:
                    //view checked out
                    break;
                case 7:
                    //exit
                    break;
                default:
                    // promopt user to pick a valid number and loop back to the menu
                    break;
            }
        } catch (InputMismatchException ime) {
            input.nextLine();

            System.out.println("Select a number from 1 - 7");
            startMenu();




        }
    }


}
