package baekjoon.problem2439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = n-i-1; j > 0; j--)
                sb.append(" ");
            for(int j = 0; j <= i; j++)
                sb.append("*");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
