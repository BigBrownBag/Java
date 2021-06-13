package task2;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Player extends Input{
    static BiFunction<Integer, Integer, Integer> bFunc = Integer::sum;

    public void start() {
        playersList(getString());
    }

    public static void playersList(String data) {
        Map<String, Integer> map = new HashMap<>();

        String[] stringArray = data.replace("\"", "").split(",");
        for (String a : stringArray) {
            String[] mapStr = a.split(" ");

            map.merge(mapStr[0], Integer.parseInt(mapStr[1]), bFunc);
        }
        getWinner(map, stringArray);
    }

    public static void getWinner(Map<String, Integer> map, String[] stringArray) {
        int maxValue = Collections.max(map.values());
        Map<String, Integer> newMap = new HashMap<>();

        for (String a : stringArray) {
            String[] mapStr = a.split(" ");
            newMap.merge(mapStr[0], Integer.parseInt(mapStr[1]), bFunc);
            if (Collections.max(newMap.values()) == maxValue) {
                for (Map.Entry<String, Integer> entry : newMap.entrySet()) {
                    if (entry.getValue() == maxValue) {
                        String maxKey = entry.getKey();
                        System.out.println("Winner with " + maxValue + " points is " + maxKey);
                    }
                }
                break;
            }
        }
    }
}
