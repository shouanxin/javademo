package memorys;

import java.util.Random;

public class TestGCDemo {
    public static void main(String[] args) {
        Random rand = new Random();
        String str = "hello->" ;
        while(true){
            str += str + rand.nextInt(999999);
            str.intern();
            System.out.println(str);
        }
    }
}
