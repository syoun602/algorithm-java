package baekjoon.greedy.problem1931;
// 1931 회의실 배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());
        final List<Pair<Integer, Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            final String[] splitted = bufferedReader.readLine().split(" ");
            final Pair<Integer, Integer> pair = new Pair<>(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]));
            pairs.add(pair);
        }

        Collections.sort(pairs);

        int count = 0;
        int currentHour = 0;

        for (int i = 0; i < pairs.size(); i++) {
            final Pair<Integer, Integer> pair = pairs.get(i);
            if (currentHour > pair.start) {
                continue;
            }
            currentHour = pair.end;
            count++;
        }

        System.out.println(count);
    }

    static class Pair<K, V> implements Comparable<Pair<K, V>> {

        private final K start;
        private final V end;

        public Pair(final K start, final V end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(final Pair o) {
            if (this.end.equals(o.end)) {
                return (Integer) this.start - (Integer) o.start;
            }
            return (Integer) this.end - (Integer) o.end;
        }
    }
}

/*
1 4
5 5
4 5
5 6
 */
