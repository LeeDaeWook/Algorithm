
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] table;
    static boolean[][] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        table = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split("");
            for (int j = 0; j < m; j++)
                table[i][j] = Integer.parseInt(line[j]);
        }

        System.out.println(bfs(0,0));

    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new PriorityQueue<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        isVisited = new boolean[n][m];

        q.add(new Node(x, y, 0));
        isVisited[y][x] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int posX = node.x;
            int posY = node.y;
            int sumWall = node.sumWall;

            if (posX == m - 1 && posY == n - 1)
                return sumWall;

            for (int i = 0; i < 4; i++) {
                int newX = posX + dx[i];
                int newY = posY + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n)
                    continue;
                if (isVisited[newY][newX])
                    continue;
                isVisited[newY][newX] = true;
                if (table[newY][newX] == 0)
                    q.add(new Node(newX, newY, sumWall));
                else
                    q.add(new Node(newX, newY, sumWall + 1));
            }
        }

        return 0;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int sumWall;
    public Node(int x, int y, int sumWall) {
        this.x = x;
        this.y = y;
        this.sumWall = sumWall;
    }

    @Override
    public int compareTo(Node n) {
        return this.sumWall - n.sumWall;
    }
}