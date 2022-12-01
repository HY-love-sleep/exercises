package leetcode.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] height = new int[num];
        String[] name = new String[num];
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            height[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            name[i] = sc.next();
            map.put(name[i],height[i]);
        }

//        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);

        Arrays.sort(name, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int h1 = map.get(o1);
                int h2 = map.get(o2);
                if(h1 == h2){
                    return o1.compareTo(o2);
                }
                return h1 - h2;

            }
        });
        System.out.println(Arrays.toString(name));
    }
}
