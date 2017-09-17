package memorys;

import java.lang.ref.SoftReference;

public class TestSoftReference {
    public static void main(String[] args) {
        String str = new String("hello world");
        SoftReference<String> softReference = new SoftReference<String>(str);
        str = null;
        System.out.println(softReference.get());
    }
}
