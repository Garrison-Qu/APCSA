import java.io.*;
import java.util.*;

public class TicTacToe {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static Grid[][] grid = new Grid[3][3];
    static HashMap<Integer, Character> map = new HashMap<Integer, Character>();

    public static void main(String[] args) throws IOException {
        while (true) {
            init();

            int r = 1;
            int n = 1;

            while (!check() && r <= 9) {
                printing(r, n);
                int row;
                int col;
                int t = 0;
                while (true) {
                    st.nextToken();
                    row = (int) st.nval;
                    st.nextToken();
                    col = (int) st.nval;
                    try {
                        t = grid[row][col].state;
                        if (t != 0) {
                            System.out.println("Invalid Move");
                            continue;
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Move");
                    }
                }
                if (t == 0) {
                    grid[row][col].state = n;
                }
                r++;
                n *= -1;
            }
            if (!check()) {
                System.out.println("Tie");
            } else {
                System.out.println(map.get(n * -1) + " Won!");
                System.out.println("Round " + r + ":");
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print("[" + map.get(grid[j][i].state) + "]");
                }
                System.out.println();
            }
            System.out.println("Play again? (Y/N)");
            st.nextToken();
            char str = st.sval.trim().charAt(0);
            if (str == 'N') {
                return;
            }
        }
    }

    public static void init() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new Grid(i, j);
            }
        }

        map.put(0, ' ');
        map.put(1, 'X');
        map.put(-1, 'O');
    }

    public static class Grid {
        int x, y, state;

        Grid(int x, int y) {
            this.x = x;
            this.y = y;
            state = 0;
        }
    }

    public static boolean check() {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0].state == grid[i][1].state && grid[i][1].state == grid[i][2].state && grid[i][0].state == grid[i][2].state && grid[i][0].state != 0)
                return true;
            if (grid[0][i].state == grid[1][i].state && grid[1][i].state == grid[2][i].state && grid[0][i].state == grid[2][i].state && grid[i][0].state != 0)
                return true;
        }
        if (grid[0][0].state == grid[1][1].state && grid[1][1].state == grid[2][2].state && grid[0][0].state == grid[2][2].state && grid[0][0].state != 0)
            return true;
        if (grid[0][2].state == grid[1][1].state && grid[1][1].state == grid[2][0].state && grid[0][2].state == grid[2][0].state && grid[2][0].state != 0)
            return true;
        return false;
    }

    public static void printing(int r, int n) throws IOException {
        System.out.println("Round " + r + ":");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + map.get(grid[j][i].state) + "]");
            }
            System.out.println();
        }
        System.out.println(map.get(n) + ", make your move (row, col):");
    }
}