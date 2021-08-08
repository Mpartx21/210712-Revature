package screen;


public class FirstScreen extends Screen{
    public FirstScreen() {
        super("First");
    }

    @Override
    public void printScreen() {
        System.out.println("First Screen");
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("3: Close");
        System.out.println("+-------------------+");



        try{
            String userInput ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
