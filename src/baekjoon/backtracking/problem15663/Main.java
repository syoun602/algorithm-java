package baekjoon.backtracking.problem15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 15663 - N과 M (9)
public class Main {

    static boolean[] visited = new boolean[9];
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] splitted = bufferedReader.readLine().split(" ");
        final int N = Integer.parseInt(splitted[0]);
        final int M = Integer.parseInt(splitted[1]);

        final String[] inputs = bufferedReader.readLine().split(" ");
        final int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(numbers);

        dfs(numbers, 0, new int[M]);

        set.forEach(System.out::println);

    }

    private static void dfs(int[] numbers, int depth, int[] result) {
        if (depth == result.length) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                str.append(result[i]).append(" ");
            }
            set.add(str.toString());
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }
            result[depth] = numbers[i];
            visited[i] = true;
            dfs(numbers, depth + 1, result);
            visited[i] = false;
        }
    }
}
