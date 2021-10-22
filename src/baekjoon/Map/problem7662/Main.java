package baekjoon.Map.problem7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            int cnt = 0;

            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    if (tMap.putIfAbsent(num, 1) != null)
                        tMap.put(num, tMap.get(num) + 1);
                }
                else if(command.equals("D") && !tMap.isEmpty()) {
                    if(num == 1) {
                        if (tMap.get(tMap.lastKey()) == 1)
                            tMap.remove(tMap.lastKey());
                        else
                            tMap.put(tMap.lastKey(), tMap.get(tMap.lastKey()) - 1);
                    }
                    else {
                        if (tMap.get(tMap.firstKey()) == 1)
                            tMap.remove(tMap.firstKey());
                        else
                            tMap.put(tMap.firstKey(), tMap.get(tMap.firstKey()) - 1);
                    }
                }
            }

            if(tMap.isEmpty())
                sb.append("EMPTY\n");
            else
                sb.append(tMap.lastKey() + " " + tMap.firstKey()  + "\n");
        }

        System.out.println(sb.toString());
    }
}
