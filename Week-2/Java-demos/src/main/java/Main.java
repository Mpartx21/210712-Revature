import org.apache.log4j.*;


public class Main {

    private static  final Logger logger = LogManager.getLogger(Main.class);


    public static int add (int a,int b){

        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.DEBUG);
        consoleAppender.setLayout(new PatternLayout("%d [%p|%c|%c{1}]"));
        consoleAppender.activateOptions();
        LogManager.getRootLogger().addAppender(consoleAppender);

        try{

        }catch (Exception e){
            logger.warn(e.getMessage(),e);
        }
        logger.debug("hello this is a debug message");
        logger.info("hello this is a info message");

        int c = a+b;
        return c;
    }
    public static void main(String[] args) {
        System.out.println(add(12,258));
    }
}
