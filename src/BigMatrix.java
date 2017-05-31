import java.util.HashMap;
import java.util.List;

public class BigMatrix {

    public HashMap<Integer, HashMap<Integer, Integer>> mapMatrix;

    public BigMatrix() {
        this.mapMatrix = new HashMap<>();
        throw new UnsupportedOperationException();
    }

    public void setValue(int row, int col, int value) {
        // check to see if the row exists
        if(mapMatrix.containsKey(row)){
            
        }
        throw new UnsupportedOperationException();
    }

    public int getValue(int row, int col) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> getNonEmptyRows() {
        throw new UnsupportedOperationException();
    }

    public List<Integer> getNonEmptyRowsInColumn(int col) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> getNonEmptyCols() {
        throw new UnsupportedOperationException();
    }

    public List<Integer> getNonEmptyColsInRow(int row) {
        throw new UnsupportedOperationException();
    }

    public int getRowSum(int row) {
        throw new UnsupportedOperationException();
    }

    public int getColSum(int col) {
        throw new UnsupportedOperationException();
    }

    public int getTotalSum() {
        throw new UnsupportedOperationException();
    }

    public BigMatrix multiplyByConstant(int constant) {
        throw new UnsupportedOperationException();
    }

    public BigMatrix addMatrix(BigMatrix other) {
        throw new UnsupportedOperationException();
    }
}
