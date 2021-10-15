package baekjoon.problem2438;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++)
                sb.append("*");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
