import java.util.SplittableRandom;

public class StringExample {
    public boolean compareFirstAndLastCharactersAreSame(String str){
        if(str.length() <= 1){
            return false;
        }else if (str.length() == 2){
                return false;
            }
        String first2Char = str.substring(0,2);
        String last2Char = str.substring(2,str.length());
        return first2Char.equals(last2Char);
    }
}
