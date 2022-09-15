package programmers.level_2;

/*
Problem 68936 - 쿼드압축 후 개수 세기 (Level 2)
Link to Problem - https://programmers.co.kr/learn/courses/30/lessons/68936
*/

public class Problem68936 {

    class Solution {
        int[] answer = new int [2];

        public int[] solution(int[][] arr) {

            quad(0, 0, arr, arr.length);

            return answer;
        }

        public void quad(int x, int y, int[][] arr, int size) {

            if(size == 1) {
                answer[arr[x][y]]++;
                return;
            }

            if(check(x, y, arr, size))
                return;

            quad(x, y, arr, size/2);
            quad(x + size/2, y, arr, size/2);
            quad(x, y + size/2, arr, size/2);
            quad(x + size/2, y + size/2, arr, size/2);
        }

        public boolean check(int x, int y, int[][] arr, int size) {
            for(int i = x; i < x + size; i++) {
                for(int j = y; j < y + size; j++) {
                    if(arr[x][y] != arr[i][j])
                        return false;
                }
            }

            answer[arr[x][y]]++;
            return true;
        }
    }
}
