package task2;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.*;

public class Main extends Input {
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        Collection<T> noDuplicatesColl = new HashSet<>(collection);
        System.out.println("Task №1\n" + "Input collection:");
        System.out.println(collection);
        System.out.println("Collection without duplicates: ");
        System.out.println(noDuplicatesColl + "\n");
        return noDuplicatesColl;
    }

    public static <K, V> Map<V, Collection<K>> invertKeysAndValues(Map<? extends K, ? extends V> map) {
        System.out.println("Task №2\nInput Map:");
        System.out.println(map);
        Map<V, Collection<K>> invertedMap = new TreeMap<>();

        Set<? extends K> key1 = map.keySet();
        for (K key : key1) {
            V value = map.get(key);
            invertedMap.compute(value, (v, key2) -> {
                if (key2 == null) {
                    key2 = new TreeSet<>();
                }
                key2.add(key);
                return key2;
            });
        }
        System.out.println("Invert Map:\n" + invertedMap + "\n");
        return invertedMap;
    }

    public static void main(String[] args) throws IOException {
        removeDuplicates(getCollection());
        invertKeysAndValues(getMap());
        Player findPlayer = new Player();
        findPlayer.start();
    }
}
