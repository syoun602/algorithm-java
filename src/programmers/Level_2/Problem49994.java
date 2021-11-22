package programmers.Level_2;

/*
Problem 49994 - 방문 길이 (Level 2)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/49994
*/

public class Problem49994 {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int curx = 5, cury = 5;

        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int d = 0;

            if(c == 'U')
                d = 0;
            else if(c == 'L')
                d = 1;
            else if(c == 'D')
                d = 2;
            else if(c == 'R')
                d = 3;

            int nx = curx + dir[d][0];
            int ny = cury + dir[d][1];

            if(nx < 0 || nx > 10 || ny < 0 || ny > 10)
                continue;

            if(!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                visited[curx][cury][(d + 2) % 4] = true;
                answer++;
            }
            curx = nx;
            cury = ny;
        }

        return answer;
    }
}
