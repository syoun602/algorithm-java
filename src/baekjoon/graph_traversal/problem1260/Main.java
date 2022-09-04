package baekjoon.graph_traversal.problem1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> dfsAnswer = new ArrayList<>();
    static List<Integer> bfsAnswer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());
        final int startVertex = Integer.parseInt(stringTokenizer.nextToken());
        final int[][] path = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            final StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
            final int v1 = Integer.parseInt(st.nextToken());
            final int v2 = Integer.parseInt(st.nextToken());
            path[v1][v2] = 1;
            path[v2][v1] = 1;
        }

        final int[] dfsVisited = new int[N + 1];
        final int[] bfsVisited = new int[N + 1];

        dfs(path, startVertex, dfsVisited);
        bfs(path, startVertex, bfsVisited);

        for (int i = 0; i < dfsAnswer.size(); i++) {
            System.out.print(dfsAnswer.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < bfsAnswer.size(); i++) {
            System.out.print(bfsAnswer.get(i) + " ");
        }

    }

    private static void dfs(int[][] path, final int startVertex, final int[] dfsVisited) {
        dfsAnswer.add(startVertex);
        dfsVisited[startVertex] = 1;

        for (int i = 1; i < path.length; i++) {
            if (dfsVisited[i] == 1) {
                continue;
            }

            if (path[startVertex][i] == 1) {
                dfs(path, i, dfsVisited);
            }
        }
    }

    private static void bfs(int[][] path, final int startVertex, final int[] bfsVisited) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        bfsVisited[startVertex] = 1;

        while (!queue.isEmpty()) {
            final Integer num = queue.poll();
            bfsAnswer.add(num);

            for (int i = 1; i < path.length; i++) {
                if (bfsVisited[i] == 1) {
                    continue;
                }
                if (path[num][i] == 1) {
                    queue.add(i);
                    bfsVisited[i] = 1;
                }
            }
        }
    }
}
