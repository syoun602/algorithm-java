package programmers.level_2;

/*
Problem 68645 - 삼각 달팽이 (Level 2)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/68645
*/

public class Problem68645 {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
        int[][] dir = {{1, 0}, {0, 1}, {-1, -1}};

        int x = 0, y = 0, cur = 0, num = 1;
        int cnt = 0;
        while (true) {

            if (x >= n || y >= n || arr[x][y] != 0)
                break;

            arr[x][y] = num;
            num++;

            if (cur == 0 && (x + 1 >= n || arr[x + 1][y] != 0))
                cur = 1;
            else if (cur == 1 && (y + 1 >= n || arr[x][y + 1] != 0))
                cur = 2;
            else if (cur == 2 && ((x - 1 < 0) || (y - 1 < 0) || (arr[x - 1][y - 1] != 0)))
                cur = 0;

            x = x + dir[cur][0];
            y = y + dir[cur][1];
        }

        int tmp = 0;

        for(int i = 0; i < n; i++)
            for(int j = 0; j <= i; j++)
                answer[tmp++] = arr[i][j];

        return answer;
    }
}
