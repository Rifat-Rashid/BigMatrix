import java.util.*;

public class BigMatrix {

    public HashMap<Integer, HashMap<Integer, Integer>> mapMatrix;

    public BigMatrix() {
        this.mapMatrix = new HashMap<>();
    }

    // add @Param value at (row, col)
    public void setValue(int row, int col, int value) {
        // check to see if the row exists
        if (mapMatrix.containsKey(row)) {
            HashMap<Integer, Integer> temp = mapMatrix.get(row);
            temp.put(col, value);
        } else {
            HashMap<Integer, Integer> temp = new HashMap<>();
            temp.put(col, value);
            mapMatrix.put(row, temp);
        }
    }

    // get value at (row, col)
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
        ArrayList<Integer> rows = new ArrayList<>();
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrix.entrySet()) {
            rows.add(entry.getKey());
        }
        return rows;
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

    // will return null if the row does not exist!!
    public int getRowSum(int row) {
        Integer sum = 0;
        if (mapMatrix.containsKey(row)) {
            HashMap<Integer, Integer> temp = mapMatrix.get(row);
            for (Object o : temp.values())
                sum += (Integer) o;
            return sum;
        }
        return sum;
    }

    public int getColSum(int col) {
        Integer sum = 0;
        // this is cancerous hf...
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrix.entrySet()) {
            HashMap<Integer, Integer> temp = entry.getValue();
            // check to see if @col has a value
            if (temp.containsKey(col)) {
                sum += temp.get(col);
            }
        }
        return sum;
    }

    // get sum of all elements in the array
    public int getTotalSum() {
        int sum = 0;
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrix.entrySet()) {
            sum += getRowSum(entry.getKey());
        }
        return sum;
    }

    public BigMatrix multiplyByConstant(int constant) {
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrix.entrySet()) {
            HashMap<Integer, Integer> temp = entry.getValue();

        }
        throw new UnsupportedOperationException();
    }

    public BigMatrix addMatrix(BigMatrix other) {
        throw new UnsupportedOperationException();
    }
}
