package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Library  {


    public final Menu menu;
    public  List<Game> gamelibrary = new ArrayList<Game>();
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

        gameIndex -= gameIndex;
        gamelibrary.remove(gameIndex);
        System.out.println("This game has been removed from your library");
        menu.startMenu();

    }
    protected void checkoutGame(int gameIndex) {
        gameIndex -= gameIndex;

        Game game = gamelibrary.get(gameIndex);

        checkedOutGames.add(game);
        Calendar calendar = Calendar.getInstance();
        System.out.println("You checked this game out on: " + dateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_YEAR,3);
        System.out.println("This game is due back on: " + dateFormat.format(calendar.getTime()));
        game.setDueDate(dateFormat.format(calendar.getTime()));
        gamelibrary.remove(gameIndex);
        menu.startMenu();

    }
    protected void checkInGame(int gameIndex) {

        gameIndex -= gameIndex;

        Game game = gamelibrary.get(gameIndex);

        checkedOutGames.remove(game);


    }
}
