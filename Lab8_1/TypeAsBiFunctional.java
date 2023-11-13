package Lab8_1;

//public class TypeAsBiFunctional {


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

 class LambdaDemo {
        public static void main(String[] args) {
            BiFunction<Double, Double, List<Double>> biFunction = (x, y) -> {
                List<Double> list = new ArrayList<>();
                list.add(Math.pow(x, y));
                list.add(x * y);
                return list;
            };

            // Attempt to use the biFunction
            List<Double> result = biFunction.apply(2.0, 3.0);

            // This will not compile because the lambda expression's return type does not match BiFunction's expected type.
        }
    }


