package programmers.Level_3;

/*
Problem 12900 - 2 x n 타일링 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/12907
*/

public class Problem12900 {
    public int solution(int n) {
        int answer = 0;

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }

        return arr[n-1];
    }
}
