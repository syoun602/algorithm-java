package baekjoon.practice.problem1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int n = Integer.parseInt(in.readLine());
        double[] arr = new double [n];
        int max = 0;
        double ans = 0;

        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
            max = Math.max(max, (int) arr[i]);
        }

        for(int i = 0; i < arr.length; i++)
            ans += arr[i] / max * 100 / arr.length;

        System.out.println(ans);
    }
}
