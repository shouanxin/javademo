package strings;

public class TestStrings {
    public static void main(String[] args) {
        String a = new String("abs");
        String b = "abs";
        String c = "a"+"bs";
        String d = "bs";
        String f = "a" + d;

        System.out.println(a.intern() == b);
        System.out.println(a.intern() == f);
        System.out.println(c == f);
        System.out.println(b == c);
        Runtime.getRuntime().gc();
    }
}
