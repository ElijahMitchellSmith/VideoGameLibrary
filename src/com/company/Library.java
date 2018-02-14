package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Library {


    public final Menu menu;
    public List<Game> gamelibrary = new ArrayList<Game>();
    private List<Game> checkedOutGames = new ArrayList<Game>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");


    public Library(Menu menu) {
        this.menu = menu;

    }

    protected void addGame(Game game) {
        // code goes here to add game to where ever we are savaing game things to
        //Save game title
        //add name to a view list
        gamelibrary.add(game);
        menu.startMenu();


    }

    protected void removeGame(int gameIndex) {


        gameIndex--;
        gamelibrary.remove(gameIndex);
        System.out.println("This game has been removed from your library");
        menu.startMenu();


    }

    protected void checkoutGame(int gameIndex) {
        gameIndex--;

        Game game = gamelibrary.get(gameIndex);
        Calendar calendar = Calendar.getInstance();
        System.out.println("You checked this game out on: " + dateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        System.out.println("This game is due back on: " + dateFormat.format(calendar.getTime()));
        game.setDueDate(dateFormat.format(calendar.getTime()));
        checkedOutGames.add(game);
        gamelibrary.remove(gameIndex);
        menu.startMenu();

    }

    protected void checkInGame(int gameIndex) {

        gameIndex--;
        Calendar calendar = Calendar.getInstance();

        Game game = checkedOutGames.get(gameIndex);
        System.out.println("You have returned this game on " + dateFormat.format(calendar.getTime()));

        checkedOutGames.remove(game);


    }

    protected void viewGameLibrary() {
        int position = 1;
        for (int i = 0; i < gamelibrary.size(); i++) {
            System.out.println(position + ". " + gamelibrary.get(i).getTitle());
            position++;
        }
    }

    protected void viewCheckedOutGames() {
        int position = 1;

        for (int i = 0; i < checkedOutGames.size(); i++) {
            System.out.println(position + ". " + checkedOutGames.get(i).getTitle());
            position++;
        }

    }

}





