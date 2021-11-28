package programmers.Level_3;

import java.util.ArrayList;

/*
Problem 12936 - 줄 서는 방법 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/12936
*/

public class Problem12936 {
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long factorial = 1;
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }
        k--;

        while(true) {
            factorial /= (n - idx);
            long val = k / factorial;
            answer[idx] = list.get((int) val);
            list.remove((int) val);
            idx++;

            if(idx == n - 1)
                break;

            k %= factorial;
        }

        answer[idx] = list.get(0);

        return answer;
    }
}