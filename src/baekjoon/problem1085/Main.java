package baekjoon.problem1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min;
        int a = Math.min(Math.abs(x-0), Math.abs(x-w));
        int b = Math.min(Math.abs(y-0), Math.abs(y-h));
        min = Math.min(a, b);

        System.out.println(min);

    }
}
