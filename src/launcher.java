/**
 * Created by DevWork on 5/30/17.
 */
public class launcher {
    public static void main(String[] args){
        BigMatrix m = new BigMatrix();
        m.setValue(0, 1, 10);
        System.out.println(m.getValue(1, 1));
    }
}
