package demo.test;

import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            int[] nums = new int[strs.length - 1];
            int k = Integer.parseInt(strs[strs.length - 1]);
            for (int i = 0; i < strs.length - 1; i++) {
                nums[i] = Integer.parseInt(strs[i]);
            }
            int[] ans = heapSort(k, nums);
            Arrays.sort(ans);
            for (int i = 0; i < k; i++) {
                System.out.print(i == (k - 1) ? ans[i] : ans[i] + " ");
            }
        }
    }

    // 最小的K个数那就用大根堆
    public static int[] heapSort(int k, int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
//        while (!heap.isEmpty()) {
//            res[i++] = heap.poll();
//        }
        for (int e : heap) {
            res[i++] = e;
        }
        return res;
    }
}