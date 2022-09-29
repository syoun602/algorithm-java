package baekjoon.greedy.problem11047;
// 11047 동전 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String[] splitted = bufferedReader.readLine().split(" ");
        final int coinNum = Integer.parseInt(splitted[0]);
        int amount = Integer.parseInt(splitted[1]);
        final int[] coins = new int[coinNum];
        int answer = 0;

        for (int i = 0; i < coinNum; i++) {
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }


        for (int i = coinNum - 1; i >= 0; i--) {
            if (amount == 0) {
                break;
            }
            if (coins[i] <= amount) {
                int count = amount / coins[i];
                amount -= coins[i] * count;
                answer += count;
            }
        }

        System.out.println(answer);
    }
}
