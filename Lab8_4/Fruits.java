package Lab8_4;

import java.util.Arrays;
import java.util.List;

public class Fruits {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana","Orange","Cherries","blums");
        System.out.println("USING LAMBDA");
        fruits.forEach(x-> System.out.println(x));
        System.out.println("USING METHOD REFERENCE");
        fruits.forEach(System.out::println);
    }
}
