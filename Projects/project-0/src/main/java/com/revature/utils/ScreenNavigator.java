package com.revature.utils;


import com.revature.screen.Screen;

import java.util.HashSet;

public class ScreenNavigator {
    private HashSet<Screen> screens = new HashSet<>();

    public HashSet<Screen> getScreens(){return screens;}

    public ScreenNavigator addScreen(Screen name){
        //this method is to help add Screens in a stream while returning
//        the same ScreenNavigator to
        screens.add(name);
        return this;
    }

    public void navigate(String screenName){
//        screens.stream()
//                .findAny()
//                .orElseThrow(() -> new RuntimeException("Did not find that com.revature.screen"))
//                .printScreen();
        screens.forEach(screen -> {
            if(screen.getName().equals(screenName)){
             screen.printScreen();
            }
        });

    }
}
