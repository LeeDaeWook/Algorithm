
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] table = new int[n];
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            table[i] = Integer.parseInt(bf.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while (l < n) {
            if (r - l < k) {
                map.put(table[r % n], map.getOrDefault(table[r % n], 0) + 1);
                r++;
            }
            else {
                a[l] = map.size();
                if (!map.containsKey(c))
                        (a[l])++;
                if (map.get(table[l]) == 1)
                    map.remove(table[l]);
                else
                    map.put(table[l], map.get(table[l]) - 1);
                l++;
            }
        }
        
        System.out.println(Arrays.stream(a).max().getAsInt());
    }
}
