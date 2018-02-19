package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class Menu {
    //User Menu to prompt user for library options
    public int position;

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
                    if (library.gamelibrary.isEmpty()) {
                        System.out.println("There are no games to select from!");
                        startMenu();
                    } else {
                        System.out.println("You have chosen to remove a game from your library. \n" + "Here is a list of games, type the number of the one you would like to remove");

                        // create method to list all games availible
                        library.viewGameLibrary();
                        library.removeGame(input.nextInt());
                    }

                    break;
                case 3:
                    //View library
                    library.viewGameLibrary();
                    startMenu();
                    break;
                case 4:
                    //Check out
                    System.out.println("Which game would you like to remove? Type in its number");
                    library.viewGameLibrary();
                    library.checkoutGame(input.nextInt());
                    startMenu();
                    break;
                case 5:
                    //check in
                    if (library.gamelibrary.isEmpty()) {
                        System.out.println("There are no games to select from!");
                        startMenu();
                    } else System.out.println("What Game would you like to check in? Type in its number.");
                    library.viewCheckedOutGames();
                    library.checkInGame(input.nextInt());
                    startMenu();
                    break;
                case 6:
                    //view checked out
                    System.out.println("Here is a list of your checked out games");
                    library.viewCheckedOutGames();
                    break;
                case 7:
                    //exit
                    System.exit(0);
                    break;
                default:
                    // promopt user to pick a valid number and loop back to the menu
                    System.out.println("Pick a valid number!");
                    break;
            }
        } catch (InputMismatchException ime) {
            input.nextLine();

            System.out.println("Select a number from 1 - 7");
            startMenu();




        }
    }


}
