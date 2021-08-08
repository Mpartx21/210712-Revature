package utils;

import dao.*;
import screen.FirstScreen;


import java.sql.SQLException;
import java.util.Scanner;

public class ProgramManager {
    private Scanner scanner;
    private ScreenNavigator screenNavigator;
    private boolean running;

    public ProgramManager(){
        running = true;
        scanner = new Scanner(System.in);
        //Initalizing the DAOs
        try {
            UserDAO userDAO = UserDAOFactory
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        screenNavigator = new ScreenNavigator();
        screenNavigator.addScreen(new FirstScreen());
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ScreenNavigator getScreenNavigator() {
        return screenNavigator;
    }

    public void setScreenNavigator(ScreenNavigator screenNavigator) {
        this.screenNavigator = screenNavigator;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
