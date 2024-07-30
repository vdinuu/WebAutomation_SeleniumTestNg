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
}
