import java.util.*;

public class CharMatrix {
    private int rows, cols;
    private char fill;
    private char[][] m;

    public CharMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        fill = ' ';
        m = new char[cols][rows];
        for (int i = 0; i < cols; i++) {
            Arrays.fill(m[i], fill);
        }
    }

    public CharMatrix(int rows, int cols, char fill) {
        this.rows = rows;
        this.cols = cols;
        this.fill = fill;
        m = new char[cols][rows];
        for (int i = 0; i < cols; i++) {
            Arrays.fill(m[i], fill);
        }
    }

    public void display() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(m[j][i]);
            } 
            System.out.println();
        }
    }

    public int numRows() {
        return rows;
    }

    public int numCols() {
        return cols;
    }

    public char charAt(int row, int col) {
        return m[col][row];
    }

    public void setCharAt(int row, int col, char ch) {
        m[col][row] = ch;
    }

    public boolean isEmpty(int row, int col) {
        return m[col][row] == ' ';
    }

    public void fillRect(int row0, int col0, int row1, int col1, char fill) {
        for (int i = col0; i <= col1; i++) {
            for (int j = row0; j <= row1; j++) {
                m[i][j] = fill;
            }
        }
    }

    public void clearRect(int row0, int col0, int row1, int col1) {
        for (int i = col0; i <= col1; i++) {
            for (int j = row0; j <= row1; j++) {
                m[i][j] = ' ';
            }
        }
    }

    public int countInRow(int row) {
        int count = 0;
        for (int i = 0; i < cols; i++) {
            if (m[i][row] == ' ') {
                count++;
            }
        }
        return count;
    }

    public int countInCol(int col) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            if (m[col][i] == ' ') {
                count++;
            }
        }
        return count;
    }
}
