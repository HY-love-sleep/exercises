package demo;

import java.util.HashMap;

public class LRUCache {

    static class DLinkedNode {
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode nex;

        DLinkedNode() {
        }

        ;

        DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size; // 缓存当前大小
    int capacity; // 缓存容量
    DLinkedNode head, tail;
    HashMap<Integer, DLinkedNode> cache;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.nex = tail;
        tail.pre = head;
        cache = new HashMap<>();
    }

    public void put(int key, int val) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, val);
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) { // 删除链表尾部节点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
            }
        } else {
            node.val = val;
            moveToHead(node);
        }
    }


    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            // 先将其移动到链表头部
            moveToHead(node);
            return node.val;
        }
    }

    private void moveToHead(DLinkedNode node) {
        // 删除节点
        removeNode(node);
        // 将其添加到链表头部
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.nex = head.nex;
        node.pre = head;
        head.nex.pre = node;
        head.nex = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.nex = node.nex;
        node.nex.pre = node.pre;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        size--;
        return res;
    }


}
