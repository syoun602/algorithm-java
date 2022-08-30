package baekjoon.dynamic_programming.problem1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int[] value = new int[1000001];
        value[1] = 0;
        value[2] = 1;
        value[3] = 1;

        for (int i = 4; i <= N; i++) {
            int divisibleByTwo = value[i - 1] + 1;
            int divisibleByThree = value[i - 1] + 1;

            if (i % 2 == 0) {
                divisibleByTwo = value[i / 2] + 1;
            }

            if (i % 3 == 0) {
                divisibleByThree = value[i / 3] + 1;
            }

            value[i] = Math.min(Math.min(divisibleByTwo, divisibleByThree), value[i - 1] + 1);
        }

        System.out.print(value[N]);
    }
}
