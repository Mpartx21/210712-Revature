package utils;



import java.util.HashSet;

public class ScreenNavigator {
    private HashSet<Scree> screens = new HashSet<>();

    public HashSet<Screen> getScreens(){return screens;}

    public ScreenNavigator addScreen ( name){
        //this method is to help add Screens in a stream while returning
//        the same ScreenNavigator to
        screens.add(name);
        return this;
    }

    public void navigate(String screenName){
//        screens.stream()
//                .findAny()
//                .orElseThrow(() -> new RuntimeException("Did not find that screen"))
//                .printScreen();
//        screens.forEach(screen -> {
//            if(screen.getName().equals(screenName)){
//             screen.printScreen();
//            }
//        });

    }
}
