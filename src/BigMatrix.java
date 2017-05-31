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
        ArrayList<Integer> rows = new ArrayList<>();
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrix.entrySet()) {
            HashMap<Integer, Integer> temp = entry.getValue();
            if (temp.containsKey(col)) {
                rows.add(entry.getKey());
            }
        }
        return rows;
    }

    public List<Integer> getNonEmptyCols() {
        ArrayList<Integer> cols = new ArrayList<>();
        List<Integer> allRows = getNonEmptyRows();
        for (int i : allRows) {
            HashMap<Integer, Integer> temp = mapMatrix.get(i);
            for (Integer o : temp.keySet()) {
                cols.add(o);
            }
        }
        // remove duplicate cols
        Set<Integer> t = new HashSet<>();
        t.addAll(cols);
        cols.clear();
        cols.addAll(t);
        return cols;
    }

    public List<Integer> getNonEmptyColsInRow(int row) {
        ArrayList<Integer> cols = new ArrayList<>();
        HashMap<Integer, Integer> temp = mapMatrix.get(row);
        for (Integer i : temp.keySet()) {
            cols.add(i);
        }
        return cols;
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

    // i give up
    public BigMatrix multiplyByConstant(int constant) {
        BigMatrix tempMatrix = new BigMatrix();
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrix.entrySet()) {
            HashMap<Integer, Integer> temp = entry.getValue();
            for (Map.Entry<Integer, Integer> tempEntry : temp.entrySet()) {
                tempMatrix.setValue(entry.getKey(), tempEntry.getKey(), constant * tempEntry.getValue());
            }
        }
        return tempMatrix;
    }

    public BigMatrix addMatrix(BigMatrix other) {
        BigMatrix secondTemp = other;
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrix.entrySet()) {
            if (secondTemp.mapMatrix.containsKey(entry.getKey())) {
                HashMap<Integer, Integer> temp = entry.getValue();  // our matrix
                HashMap<Integer, Integer> otherTemp = secondTemp.mapMatrix.get(entry.getKey());
                for (Map.Entry<Integer, Integer> tempEntry : temp.entrySet()) {
                    if (otherTemp.containsKey(tempEntry.getKey())) {
                        int valueOfMatrix1 = tempEntry.getValue();
                        int valueOfMatrix2 = otherTemp.get(tempEntry.getKey());
                        secondTemp.setValue(entry.getKey(), tempEntry.getKey(), valueOfMatrix1 + valueOfMatrix2);
                    } else {
                        secondTemp.setValue(entry.getKey(), tempEntry.getKey(), tempEntry.getValue());
                    }
                }
            }else{
                HashMap<Integer, Integer> t = mapMatrix.get(entry.getKey());
                secondTemp.mapMatrix.put(entry.getKey(), t);
            }
        }
        return secondTemp;
    }

    @Override
    public String toString() {
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrix.entrySet()) {
            HashMap<Integer, Integer> temp = entry.getValue();
            System.out.print("Row " + entry.getKey() + ": ");
            for (Map.Entry<Integer, Integer> tempEntry : temp.entrySet()) {
                System.out.print(tempEntry.getValue() + ", ");
            }
            System.out.println();
        }
        return "";
    }
}
