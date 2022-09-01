package baekjoon.simulation.problem1244;
// 1244 스위치 켜고 끄기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[switchNum + 1];

        for (int i = 1; i <= switchNum; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentNum; i++) {
            String[] info = br.readLine().split(" ");
            int sex = Integer.parseInt(info[0]);
            int number = Integer.parseInt(info[1]);

            if (sex == 1) {
                for (int j = 1; j <= switchNum; j++) {
                    if (j % number == 0) {
                        arr[j] = arr[j] == 0 ? 1 : 0;
                    }
                }
            }
            else if (sex == 2) {
                int left = number - 1;
                int right = number + 1;
                while (left > 0 && right <= switchNum && arr[left] == arr[right]) {
                    left--;
                    right++;
                }

                for (int j = left + 1; j < right; j++) {
                    arr[j] = arr[j] == 0 ? 1 : 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= switchNum; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
