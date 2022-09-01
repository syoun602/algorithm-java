package baekjoon.simulation.problem15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int x;
        int y;
        int val;

        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    static int N, M;
    static int min = 64;
    static ArrayList<Pair> list = new ArrayList<>();
    static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int cctv[][] = {{}, {0}, {0, 2}, {0, 3}, {0, 2, 3}, {0, 1, 2, 3}};

    static void dfs(int idx, int[][] arr) {

        if(idx == list.size()) {
            min = Math.min(cntUnseen(arr), min);
            return;
        }

        int x = list.get(idx).x;
        int y = list.get(idx).y;

        for(int j = 0; j < 4; j++) {

            int cur[] = new int[cctv[list.get(idx).val].length];

            for(int k = 0; k < cur.length; k++) {
                cur[k] = cctv[list.get(idx).val][k];
            }

            int[][] copyArr = new int[N][M];
            copyArray(copyArr, arr);

            for(int k = 0; k < cur.length; k++) {
                cur[k] = (cur[k] + j) % 4;
            }

            dfs(idx+1, checkOffice(cur, copyArr, x, y));
        }
    }

    static int cntUnseen(int[][] arr) {
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }

    static int[][] checkOffice(int[] cur, int[][] copyArr, int x, int y) {
        for(int i = 0; i < cur.length; i++) {
            int next = 1;

            while(true) {
                int nx = x + dir[cur[i]][0] * next;
                int ny = y + dir[cur[i]][1] * next;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || copyArr[nx][ny] == 6)
                    break;

                if (copyArr[nx][ny] == 0)
                    copyArr[nx][ny] = 1;

                next++;
            }
        }

        return copyArr;
    }

    static void copyArray(int[][] copyArr, int[][] arr) {
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                copyArr[i][j] = arr[i][j];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] office = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());

                if (office[i][j] > 0 && office[i][j] < 6)
                    list.add(new Pair(i, j, office[i][j]));
            }
        }

        dfs(0, office);

        System.out.println(min);
    }
}
