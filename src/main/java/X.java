/**
 * @author ：hongyan
 * @date ：Created in 2022/9/21 20:56
 * @description：
 */
public class X {
    public static void main(String[] args) {
        String s1 = "chinalife";
        String s2 = new String("chinalife");
        String s3 = "china";
        String s4 = "life";
        String s5 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
    }
}
