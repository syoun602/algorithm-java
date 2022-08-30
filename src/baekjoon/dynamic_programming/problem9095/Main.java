package baekjoon.dynamic_programming.problem9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        final int[] answer = new int[11 + 1];

        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 4;

        for (int i = 4; i <= 11; i++) {
            answer[i] = answer[i - 1] + answer[i - 2] + answer[i - 3];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[Integer.parseInt(br.readLine())]);
        }
    }
}
