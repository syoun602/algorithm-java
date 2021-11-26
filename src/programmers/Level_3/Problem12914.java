package programmers.Level_3;

/*
Problem 12914 - 멀리 뛰기 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/12914
*/

public class Problem12914 {
    public long solution(int n) {
        int[] dp = new int[2001];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < 2001; i++)
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;

        return dp[n];
    }
}