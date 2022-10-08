

import org.junit.Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] p = sc.next().split(",");
        System.out.println(matched(s, p));
    }

    public static boolean matched(String s, String[] p) {
        for (int i = 0; i < p.length; i++) {
            int tmp = strStr(s, p[i]);
            while (tmp != -1) {
                s = s.substring(0, tmp) + s.substring(tmp + p[i].length());
                tmp = strStr(s, p[i]);
            }
        }
        return s.length() == 0;
    }

    private static int strStr(String haystack, String needle) {
        int i=0,j=0;
        int[] next=getNext(needle);
        while (i< haystack.length() && j<needle.length()){
            if (j==-1 || haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if (j==needle.length()) {
            return i-j;
        }
        else {
            return -1;
        }
    }


    //求next[]数组,next[0]=-1 当遇到冲突时直接查next数组并且返回到相应位置
    private static int[] getNext(String sub){
        int[] next=new int[sub.length()+1];
        int i=0;
        int j=-1;
        next[0]=-1;
        while (i<sub.length()){
            if (j==-1 || sub.charAt(i) == sub.charAt(j)){
                next[++i]=++j;
            }else {
                j=next[j];
            }
        }
        return next;
    }

    @Test
    public void test() {

    }

}