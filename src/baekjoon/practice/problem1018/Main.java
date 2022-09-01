package baekjoon.practice.problem1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for(int i = 0; i < N; i++) {
            String s = in.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int ans = 64;

        for(int i = 0; i < N; i++) {
            if(i + 8 > N)
                break;
            for(int j = 0; j < M; j++) {
                if(j + 8 > M)
                    break;

                char start = board[i][j];
                int cnt = 0;

                for(int k = i; k < i + 8; k++) {
                    for(int l = j; l < j + 8; l++) {
                        if(start != board[k][l])
                            cnt++;
                        start = (start == 'W') ? 'B' : 'W';
                    }
                    start = (start == 'W') ? 'B' : 'W';
                }
                ans = Math.min(ans, cnt);
                ans = Math.min(ans, 64-cnt);
            }
        }

        System.out.println(ans);
    }
}
