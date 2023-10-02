import java.util.Random;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Object> a = new ArrayList<Object>();
        a.add(1);
        a.add("a");
        System.out.println(a.get(0) instanceof String);
    }
}
