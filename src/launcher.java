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
        System.out.println(m.getTotalSum());
        System.out.println(m.multiplyByConstant(2));
        System.out.println(m.getTotalSum());

    }
}
