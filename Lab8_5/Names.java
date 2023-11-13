package Lab8_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Names {
    public static void main(String[] args) {
        String[] names = {"Alexis", "Tim", "Kyleen","KRISTY"};
        Arrays.sort(names,String::compareToIgnoreCase);
        System.out.println(Arrays.asList(names));
    }
}
