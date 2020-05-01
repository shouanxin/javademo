package strings;

import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.Map;

public class TestStrings {
    public static void main(String[] args) {
//        String a = new String("abs");
//        String b = "abs";
//        String c = "a"+"bs";
//        String d = "bs";
//        String f = "a" + d;
//
//        System.out.println(a.intern() == b);
//        System.out.println(a.intern() == f);
//        System.out.println(c == f);
//        System.out.println(b == c);
//        Runtime.getRuntime().gc();
//        String a = "abcdeeref";
//        a = a.substring(3);
//        System.out.println(a);
//        Integer a = null;
//        System.out.println(a.equals(null));
        Map<String, Object> defaultReteMap = Maps.newHashMap();
        BigDecimal defaultReteb = (BigDecimal)defaultReteMap.get("deliver_rate");
        System.out.println(defaultReteb);
    }
}
