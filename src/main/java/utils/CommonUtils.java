package utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class CommonUtils {

    public static String getRandomNumber(int size){
        Random random = new Random();
        List<Integer> randomSingleDigits = Stream.generate(() -> random.nextInt(10))
                .limit(size)
                .toList();
        StringBuilder result = new StringBuilder();
        randomSingleDigits.forEach(result::append);
        return result.toString();
    }

    public static String getRandomAlphaNumeric(int size, boolean isLower){
        String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+"1234567890";
        StringBuffer sb = new StringBuffer(size);
        for(int y=0; y<size; y++){
            int index = (int) (alphaString.length()*Math.random());
            sb.append(alphaString.charAt(index));
        }
        return isLower? sb.toString().toLowerCase(): sb.toString().toUpperCase();
    }

    public static String generateEmailId(){
        return getRandomAlphaNumeric(10, true)+"@gmail.com";
    }
}
