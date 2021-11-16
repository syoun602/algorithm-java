package programmers.Level_3;

/*
Problem 43105 - 정수 삼각형 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/43105
*/

public class Problem43105 {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];

            for(int j = 1; j < triangle[i].length - 1; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        for(int i = 0; i < triangle[triangle.length-1].length; i++)
            answer = Math.max(triangle[triangle.length-1][i], answer);

        return answer;
    }
}
