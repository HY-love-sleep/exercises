package leetcode.test;

/**
 * @author ：hongyan
 * @date ：Created in 2022/9/13 14:25
 * @description：99乘法表
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 1, j = 1; i <= 9; j++) {     //i作为行数，j作为列数
            System.out.print(j + "*" + i + "=" + i * j + "\t");
            if (i == j) {  //行数等于列数，列数归0，行数加1，继续执行循环
                j = 0;
                i++;
                System.out.println();
            }
        }
    }
}
