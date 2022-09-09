package baekjoon.backtracking.problem15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());
        final int[] answer = new int[M];
        final boolean[] visited = new boolean[M + 1];
        combination(answer, visited, N, M, 0);
    }

    private static void combination(int[] result, boolean[] visited, int n, int m, int depth) {
        if (depth == m) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            result[depth] = i;
            visited[i] = true;
            combination(result, visited, n, m, depth + 1);
            visited[i] = false;
        }
    }
}
