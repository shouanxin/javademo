package collectiondemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCollection{
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        array.add("hello");

        Iterator<String> iterator = array.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
