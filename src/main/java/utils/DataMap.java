package utils;

import java.util.HashMap;
import java.util.Map;

public class DataMap {

    public static ThreadLocal<Map<String, Object>> testDataMap = ThreadLocal.withInitial(HashMap::new);

    public static Map<String, Object> getDataMap(){
        return testDataMap.get();
    }
}
