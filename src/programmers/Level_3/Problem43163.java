package programmers.Level_3;

/*
Problem 43163 - 단어 변환 (Level 3)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/43163
*/

public class Problem43163 {
    int answer = 100;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);

        if(answer == 100)
            return 0;

        return answer;
    }

    public void dfs(String cur, String target, String[] words, int cnt) {
        if(cur.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(comp(cur, words[i]) == 1 && visited[i] == false) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
    }

    public int comp(String cur, String target) {
        int cnt = 0;

        for(int i = 0; i < cur.length(); i++) {
            if(cur.charAt(i) != target.charAt(i))
                cnt++;
        }

        return cnt;
    }
}
