package printdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestPrint {
    private int a = 0xDada_Cafe;
    private float b = 0x1.fffffep+127f;
    private float c = 1996;
   // private float d = 1995.2;
    //private int f = 8888e2;
    private double g = 22e3;
    private float h = 0x1.fffep-12f;
   // private float i = 1.fffep-12f;
    private long p = 0b1_1_1_0_1;
    private long q = 0b1_1_1_0;

    public static void main(String[] args) {
        float b = 0x1.fffffep+127f;
        System.out.println(b);
        打印();
        Map map = new HashMap<String,String>();
        String str = (String) map.put("key1","value1");
        str = (String) map.put("key1","value2");
        str = (String) map.put("key1","value3");
        Set set = map.entrySet();
        Iterator s = set.iterator();

        while(s.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry<String, String>) s.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
            entry.setValue("valuereplace");
            System.out.println(entry.getValue());
            //System.out.println(s.next());
        }
        System.out.println(map.get("key1"));
        System.out.println(str);
    }
    public static void 打印(){
        System.out.println("打印");
    }
}
