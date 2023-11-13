package Lab8_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product {
    final String title;
    final double price;
    final int model;
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public int getModel() {
        return model;
    }
    public Product(String title, Double price, int model) {
        this.title = title;
        this.price = price;
        this.model = model;
    }
    @Override
    public String toString() {
        return String.format("\n %s : %s : %s", title, price, model);
    }

    public static void main(String[] args) {
        PriceComparato myComparator = new PriceComparato();
        List<Product> list = Arrays.asList(new Product("Phone",2000.00,5),
                new Product("Watch",500.00,4),
                new Product("Laptop",1500.00,2));
        Collections.sort(list,myComparator);
        System.out.println("Sorting According to thier price");
        System.out.println(Arrays.asList(list));

        TitleComparator titleComparator = new TitleComparator();
        Collections.sort(list,titleComparator);
        System.out.println("Sorting According to thier title");
        System.out.println(list);

        CompratorInfor compratorInfor = new CompratorInfor(CompratorInfor.SortedMethod.BYPRICE);
        compratorInfor.sortMethod(list);
        System.out.println(list);

        CompratorInfor compratorInfor1 = new CompratorInfor(CompratorInfor.SortedMethod.BYTITLE);
        compratorInfor.sortMethod(list);
        System.out.println(list);



        //Compare tittle using Lamda
        Comparator<Product> com = (t1,t2)->t1.getTitle().compareTo(t2.getTitle());
        Collections.sort(list,com);
        System.out.println("using Lambda");
        System.out.println(list);

        Comparator<Product> pr= (d,t) -> Double.compare(d.getPrice(),t.getPrice());
        Collections.sort(list,pr);
        System.out.println(list);
        System.out.println("If the title is same use model as another attribute to sort. Do this by using lambdas.(Java 8 Way)");
        Collections.sort(list,(l1,l2)->{
                int compTitle = l1.getTitle().compareTo(l2.getTitle());
                if(compTitle ==0){
                    return Double.compare(l1.model,l2.model);
                }
                return compTitle;
        });

    }
}

class PriceComparato implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.price < o2.price) return -1;
        if(o1.price > o2.price) return 1;
        else return 0;
    }
}
class TitleComparator implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return o1.title.compareTo(o2.title);
    }
}


class CompratorInfor{
    enum SortedMethod{BYPRICE,BYTITLE};
    private SortedMethod method;
    CompratorInfor(SortedMethod method){
        this.method = method;
    }
    public void sortMethod(List<Product> list){
        if(method == SortedMethod.BYPRICE){
            Collections.sort(list,new PriceComparato());
        } else if (method == SortedMethod.BYTITLE) {
            Collections.sort(list,new TitleComparator());
        }
    }

}

