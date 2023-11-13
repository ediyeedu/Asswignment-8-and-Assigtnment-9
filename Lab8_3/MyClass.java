package Lab8_3;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MyClass {
    int x ;
    String y;
    public MyClass(int x, String y) {
        this.x = x;
        this.y = y;
    }
    // testing method to check the equality
    public void myMethod(MyClass cl) {
//Implement
        boolean res = this.equals(cl);
        System.out.println(res);
    }
    @Override
    public boolean equals(Object ob) {
        if(ob == null) return false;
        if(ob.getClass() != getClass()) return false;
        MyClass mc = (MyClass)ob;
        return mc.x == x && mc.y.equals(y);
    }
    public static void main(String[] args) {
        MyClass myclass = new MyClass(1, "A");
        MyClass myclass1 = new MyClass(1,"B");
        MyClass myclass2 = new MyClass(1,"B");

        myclass.myMethod(myclass);
        myclass.myMethod(myclass1);

        System.out.println();
        BiFunction<MyClass,MyClass,Boolean> func = (cl1,cl2)->cl1.equals(cl2);
        System.out.println(func.apply(myclass1,myclass2));
    }
}
