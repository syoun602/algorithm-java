package baekjoon.Simulation.problem15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, x, y, d, g, ans;
    static int[][] board = new int [101][101];
    static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static ArrayList<Integer> direction = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            direction.add(d);

            for (int j = 0; j < g; j++) {
                for (int k = direction.size() - 1; k >= 0; k--) {
                    direction.add((direction.get(k) + 1) % 4);
                }
            }

            board[y][x] = 1;

            for (int j = 0; j < direction.size(); j++) {
                x += dir[direction.get(j)][0];
                y += dir[direction.get(j)][1];

                if (x < 0 || x >= 101 || y < 0 || y >= 101)
                    continue;

                board[y][x] = 1;
            }
            direction.clear();
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] == 1 && board[i][j + 1] == 1 && board[i + 1][j] == 1 && board[i + 1][j + 1] == 1)
                    ans++;
            }
        }

        System.out.println(ans);
    }
}
