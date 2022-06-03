package String;

import org.apache.commons.lang.StringUtils;

public class split_test {
    public static void main(String[] args) {
        String[] s={"a","b","c"};
        System.out.println(split_pro.joins(s));

        String ss= StringUtils.join(s,":");
        System.out.println(ss);
    }
}
