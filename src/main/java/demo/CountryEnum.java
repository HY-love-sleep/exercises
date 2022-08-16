package demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hongyan
 */
public enum CountryEnum {
    ONE(0, "秦"), TWO(1, "齐"), THREE(2, "楚"), FOUR(3, "燕"), FIVE(4, "韩"), SIX(5, "赵"), SEVEN(6, "魏");

    private Integer retCode;
    private String retMsg;

    CountryEnum(int code, String message) {
        this.retCode = code;
        this.retMsg = message;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public static CountryEnum getEnum(int index) {
        for (CountryEnum element : CountryEnum.values()) {
            if (index == element.getRetCode()) {
                return element;
            }
        }
        return null;
    }
}
