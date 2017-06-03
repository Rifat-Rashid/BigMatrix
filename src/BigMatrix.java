import java.util.*;
import java.util.stream.Collectors;

public class BigMatrix {

    // mapping of rows to columns
    public HashMap<Integer, HashMap<Integer, Integer>> mapMatrixRowCol;
    // mapping of columns to rows
    public HashMap<Integer, HashMap<Integer, Integer>> mapMatrixColRow;

    public BigMatrix() {
        this.mapMatrixRowCol = new HashMap<>();
        this.mapMatrixColRow = new HashMap<>();
    }

    // add @Param value at (row, col)
    public void setValue(int row, int col, int value) {
        // check to see if the row exists
        if (mapMatrixRowCol.containsKey(row)) {
            HashMap<Integer, Integer> temp = mapMatrixRowCol.get(row);
            temp.put(col, value);
        } else {
            HashMap<Integer, Integer> temp = new HashMap<>();
            temp.put(col, value);
            mapMatrixRowCol.put(row, temp);
        }

        // Columns to row mapping...
        if (mapMatrixColRow.containsKey(col)) {
            HashMap<Integer, Integer> temp = mapMatrixColRow.get(col);
            temp.put(row, value);
        } else {
            HashMap<Integer, Integer> temp = new HashMap<>();
            temp.put(row, value);
            mapMatrixColRow.put(col, temp);
        }
    }

    /*
     *  returns the value at the given row/column position.
     *  It should return 0 if no value has been set at the given location.
     */
    public int getValue(int row, int col) {
        if (mapMatrixRowCol.containsKey(row)) {
            HashMap<Integer, Integer> temp = mapMatrixRowCol.get(row);
            if (temp.containsKey(col)) {
                return temp.get(col);
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    //  returns a list of the rows that have at least one column with a non-zero value
    public List<Integer> getNonEmptyRows() {
        ArrayList<Integer> rows = new ArrayList<>();
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrixRowCol.entrySet()) {
            // check to see if the sum of the row is not 0
            if (getRowSum(entry.getKey()) != 0)
                rows.add(entry.getKey());
        }
        return rows;
    }

    //  returns a list of rows that have at least one non-zero value in the given column.
    public List<Integer> getNonEmptyRowsInColumn(int col) {
        ArrayList<Integer> rows = new ArrayList<>();
        HashMap<Integer, Integer> temp = mapMatrixColRow.get(col);
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            if (entry.getValue() != 0) {
                rows.add(entry.getKey());
            }
        }
        return rows;
    }

    //  returns a list of the columns that have at least one row with a non-zero value
    public List<Integer> getNonEmptyCols() {
        ArrayList<Integer> cols = new ArrayList<>();
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrixColRow.entrySet()) {
            if (getColSum(entry.getKey()) != 0)
                cols.add(entry.getKey());
        }
        return cols;
    }


    //  returns a list of columns that have at least one non-zero value in the given row
    public List<Integer> getNonEmptyColsInRow(int row) {
        /*
        ArrayList<Integer> rows = new ArrayList<>();
        HashMap<Integer, Integer> temp = mapMatrixRowCol.get(row);
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            if (entry.getValue() != 0) {
                rows.add(entry.getKey());
            }
        }
        return rows;
        */
        return mapMatrixRowCol.get(row).entrySet().stream().filter(e -> e.getValue() != 0).map(e -> e.getKey()).collect(Collectors.toList());
    }

    // will return null if the row does not exist!!
    public int getRowSum(int row) {
        Integer sum = 0;
        if (mapMatrixRowCol.containsKey(row)) {
            HashMap<Integer, Integer> temp = mapMatrixRowCol.get(row);
            for (Object o : temp.values())
                sum += (Integer) o;
            return sum;
        }
        return sum;
    }

    public int getColSum(int col) {
        int sum = 0;
        if (mapMatrixColRow.containsKey(col)) {
            HashMap<Integer, Integer> temp = mapMatrixColRow.get(col);
            for (Integer i : temp.values())
                sum += i;
        }

        return sum;
    }

    // get sum of all elements in the array
    public int getTotalSum() {
        int sum = 0;
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrixRowCol.entrySet()) {
            sum += getRowSum(entry.getKey());
        }
        return sum;
    }

    // i give up
    public BigMatrix multiplyByConstant(int constant) {
        BigMatrix tempMatrix = new BigMatrix();
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrixRowCol.entrySet()) {
            HashMap<Integer, Integer> temp = entry.getValue();
            for (Map.Entry<Integer, Integer> tempEntry : temp.entrySet()) {
                tempMatrix.setValue(entry.getKey(), tempEntry.getKey(), constant * tempEntry.getValue());
            }
        }
        return tempMatrix;
    }

    public BigMatrix addMatrix(BigMatrix other) {
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrixRowCol.entrySet()) {
            if (other.mapMatrixRowCol.containsKey(entry.getKey())) {
                HashMap<Integer, Integer> temp = entry.getValue();  // our matrix
                HashMap<Integer, Integer> otherTemp = other.mapMatrixRowCol.get(entry.getKey());
                for (Map.Entry<Integer, Integer> tempEntry : temp.entrySet()) {
                    if (otherTemp.containsKey(tempEntry.getKey())) {
                        int valueOfMatrix1 = tempEntry.getValue();
                        int valueOfMatrix2 = otherTemp.get(tempEntry.getKey());
                        other.setValue(entry.getKey(), tempEntry.getKey(), valueOfMatrix1 + valueOfMatrix2);
                    } else {
                        other.setValue(entry.getKey(), tempEntry.getKey(), tempEntry.getValue());
                    }
                }
            } else {
                HashMap<Integer, Integer> t = mapMatrixRowCol.get(entry.getKey());
                other.mapMatrixRowCol.put(entry.getKey(), t);
            }
        }
        return other;
    }

    @Override
    public String toString() {
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : mapMatrixRowCol.entrySet()) {
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
