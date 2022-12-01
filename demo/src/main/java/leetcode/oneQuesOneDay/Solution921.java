package leetcode.oneQuesOneDay;

/**
 * @author ：hongyan
 * @date ：Created in 2022/8/9 22:59
 * @description：使括号有效的最小添加次数
 */
public class Solution921 {
    public int minAddToMakeValid(String s) {
        int needLfet = 0, needRight = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                needRight += 1;
            } else {
                needRight -= 1;
                if (needRight == -1) {
                    needLfet += 1;
                    needRight = 0;
                }
            }
        }
        return needLfet + needRight;
    }
}
