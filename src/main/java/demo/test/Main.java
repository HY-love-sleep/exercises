package demo.test;

import demo.LRUCache;
// ["LRUCache","put","put","get","put","get","put","get","get","get"]
//        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

public class Main {
//    static class DLinkedNode {
//        int key;
//        int val;
//        DLinkedNode pre;
//        DLinkedNode nex;
//
//        DLinkedNode() {
//        }
//
//        ;
//
//        DLinkedNode(int key, int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
    public static void main (String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

}
