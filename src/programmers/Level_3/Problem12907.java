package programmers.Level_3;

import java.util.Arrays;

/*
Problem 12907 - 거스름돈 (Level 2)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/12907
*/

public class Problem12907 {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for(int i = 0; i < money.length; i++) {
            for(int j = money[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j-money[i]]) % 1000000007;
            }
        }

        return dp[n];
    }
}
