package programmers.Level_3;

/*
Problem 42898 - 등굣길 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/42898
*/

public class Problem42898 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++)
            arr[puddles[i][1]][puddles[i][0]] = -1;

        arr[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == -1)
                    continue;

                if (arr[i][j - 1] >= 0)
                    arr[i][j] = (arr[i][j] + arr[i][j - 1]) % 1000000007;

                if (arr[i - 1][j] >= 0)
                    arr[i][j] = (arr[i][j] + arr[i - 1][j]) % 1000000007;
            }
        }

        return arr[n][m];
    }
}
