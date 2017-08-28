package org.food.safety.trace.util;

/**
 * Created by tom on 2017/8/28.
 */
public class StringUitls {
    /**
     * 首字母小写
     * @param name
     * @return
     */
    public static String captureName(String name) {
        char[] cs=name.toCharArray();
        cs[0]+=32;
        return String.valueOf(cs);
    }
}
