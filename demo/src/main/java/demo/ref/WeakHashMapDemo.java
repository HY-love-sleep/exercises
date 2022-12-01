package demo.ref;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/19 19:37
 * @description：weakHashMap
 */
public class WeakHashMapDemo {
    public static void myHashMap() {
        Map<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String val = "HashMap";
        map.put(key, val);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }

    public static void myWeakHashMap() {
        Map<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String val = "WeakHashMap";
        map.put(key, val);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }

    public static void main(String[] args) {
        myHashMap();
        System.out.println("=======================");
        myWeakHashMap();
    }
}
