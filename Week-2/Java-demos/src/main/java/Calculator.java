public class Calculator {

    public int addNumber(int a,int b){
        return a + b;
    }

    public int subNumber(int a, int b){
        return a-b;
    }

    public int getCube(int number){
        return number*number*number;
    }

    public int findMaxNumber(int myArray[]){
        int max = myArray[0];

        for(int i = 0;i < myArray.length;i++){
            if(max < myArray[i]){
                max = myArray[i];
            }
        }
        return max;
    }

    // method that return reverse string
    public String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--){
            result += str.charAt(i);
        }
        return result;
    }
}
