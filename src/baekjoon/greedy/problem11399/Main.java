package baekjoon.greedy.problem11399;
// 11399 ATM

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                answer += numbers[i];
                continue;
            }

            numbers[i] += numbers[i-1];
            answer += numbers[i];
        }

        System.out.print(answer);
    }
}