package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for managing and manipulating test data.
 * This class provides functionality to handle data operations for test automation,
 * including reading, storing, and retrieving test data from various sources.
 *
 * <p>The class implements a thread-safe approach to handle test data in parallel execution
 * environments using ThreadLocal storage.
 *
**/
public class DataMap {

    public static ThreadLocal<Map<String, Object>> testDataMap = ThreadLocal.withInitial(HashMap::new);

    public static Map<String, Object> getDataMap(){
        return testDataMap.get();
    }
}
