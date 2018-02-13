package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    //User Menu to prompt user for library options

    private Scanner input = new Scanner(System.in);
    private Library library = new Library(this);
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
                    System.out.println("You have chosen to add a game. \n" + "What is the name of the game you would like to add?");
                    input.nextLine();
                    Game game = new Game(input.nextLine());
                    System.out.println("You have added " + game.getTitle() + " to your library, this game can now be checked out.");
                    library.addGame(game);
                    break;
                case 2:
                    //Remove game
                    System.out.println("You have chosen to remove a game from your library. \n" + "Here os a list of games, type the number of the one you would like to remove");
                    // create method to list all games availible
                    library.removeGame(input.nextInt());
                    break;
                case 3:
                    //View library
                    System.out.println(library.gamelibrary);
                    startMenu();
                    break;
                case 4:
                    //Check out
                    System.out.println("Which game would you like to remove? Type in its number");
                    library.checkoutGame(input.nextInt());
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
