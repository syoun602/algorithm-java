package baekjoon.two_pointer.problem11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int[] A = new int[N];
        final int[] B = new int[M];
        final int[] answer = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int aIdx = 0;
        int bIdx = 0;
        int idx = 0;

        while (!(aIdx == N && bIdx == M)) {
            if (aIdx == N) {
                answer[idx] = B[bIdx];
                bIdx++;
                idx++;
                continue;
            }

            if (bIdx == M) {
                answer[idx] = A[aIdx];
                aIdx++;
                idx++;
                continue;
            }

            if (A[aIdx] > B[bIdx]) {
                answer[idx] = B[bIdx];
                bIdx++;
            } else {
                answer[idx] = A[aIdx];
                aIdx++;
            }
            idx++;
        }

        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i] + " ");
        }

        System.out.println(sb);
    }
}
