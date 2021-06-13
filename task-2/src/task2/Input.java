package task2;
import java.util.*;
import java.util.function.BiFunction;

public class Input {
    public static <T> Collection<T> getCollection() {
        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int num = 5 + random.nextInt(10);
            arrList.add(num);
        }
        return (Collection<T>) arrList;
    }

    public static <K, V> Map<V, K> getMap() {
        Map newMap = new TreeMap();
        newMap.put("fruit", "banana");
        newMap.put("car", "volvo");
        newMap.put("animal", "cat");
        return newMap;
    }

    public static String getArray() {
        System.out.println("Task №3");
        System.out.println("Input array:");
        System.out.println("Пример данных: \"Ivan 5\",\"Petr 3\",\"Alex 10\",\"Petr 8\",\"Ivan 6\",\"Alex 5\",\"Ivan 1\",\"Petr 5\",\"Alex 1\"");
        Scanner inputData = new Scanner(System.in);
        String data = inputData.nextLine();
        return data;
    }
}
