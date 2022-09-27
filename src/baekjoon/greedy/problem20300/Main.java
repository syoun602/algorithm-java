package baekjoon.greedy.problem20300;
// 20300 서강근육맨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());
        final String[] t = bufferedReader.readLine().split(" ");
        final long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(t[i]);
        }
        Arrays.sort(arr);

        long answer = 0;

        if (N % 2 == 0) {
            answer = calculateMax(arr, 0, N - 1, 0);
        } else {
            answer = Math.max(arr[N - 1], calculateMax(arr, 0, N - 2, 0));
        }

        System.out.println(answer);
    }

    private static long calculateMax(final long[] arr, int start, int end, long answer) {
        while (start < end) {
            answer = Math.max(arr[start] + arr[end], answer);
            start++;
            end--;
        }

        return answer;
    }
}
