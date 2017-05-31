import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class BigMatrix {

    public HashMap<Integer, HashMap<Integer, Integer>> mapMatrix;

    public BigMatrix() {
        this.mapMatrix = new HashMap<>();
    }

    public void setValue(int row, int col, int value) {
        // check to see if the row exists
        if (mapMatrix.containsKey(row)) {
            HashMap<Integer, Integer> temp = mapMatrix.get(row);
            temp.put(col, value);
        }else{
            HashMap<Integer,Integer> temp = new HashMap<>();
            temp.put(col, value);
            mapMatrix.put(row, temp);
        }
    }

    public int getValue(int row, int col) {
        if (mapMatrix.containsKey(row)) {
            HashMap<Integer, Integer> temp = mapMatrix.get(row);
            if (temp.containsKey(col)) {
                return temp.get(col);
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
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
