import java.util.HashMap;

/**
 * Created by DevWork on 5/30/17.
 */
public class launcher {
    public static void main(String[] args){
        BigMatrix m = new BigMatrix();
        // tests
        m.setValue(0, 1, 10);
        m.setValue(0, 2, 10);
        m.setValue(1, 1, 9);
        m.toString();
        System.out.println("--------------------------------");
        BigMatrix second = m.multiplyByConstant(2);
        second.toString();
        System.out.println("--------------------------------");
        m.toString();
        System.out.println("--------------------------------");
        BigMatrix c = m.addMatrix(second);
        c.toString();


    }
}
