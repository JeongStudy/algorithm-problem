package yunhwan.random;

import java.io.*;
import java.util.*;

public class N1504 {
    static class Edge{
        int to;
        int w;
        Edge(int to, int w){this.to = to; this.w = w;}
    }
    static class Node{
        int v;
        int dist;
        Node(int v, int dist){this.v = v; this.dist = dist;}
    }

    static final int INF = 1_000_000_000;
    static List<Edge>[] edge;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edge = new ArrayList[N + 1];
        for(int i=1; i<=N; i++){edge[i] = new ArrayList<>();}

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 양방향
            edge[u].add(new Edge(v, w));
            edge[v].add(new Edge(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        /*
            이 문제의 포인트
            1 -> c1 -> c2 -> N
            1 -> c2 -> c1 -> N
            이 2가지 경로 중에 최소를 찾아야 함
            결국에 한 번의 다익스트라는 안되고 여러번 수행해야 함
            
            (1-N), (c1-N), (c2-N)의 dist 배열을 각각 구하고
            1 -> c1 -> c2 -> N
            1 -> c2 -> c1 -> N
            d1[c1] + dC1[c2] + dC2[N]
            d1[c2] + dC2[c1] + dC1[N]
            
            여기서 최소 경로를 구해야 함
         */

        int[] d1 = dijkstra(1, N); // 1-N까지 최단 경로
        int[] dC1 = dijkstra(c1, N); // c1-N까지 최단 경로
        int[] dC2 = dijkstra(c2, N); // c2-N까지 최단 경로

        long first = (long)d1[c1] + dC1[c2] + dC2[N];
        long second = (long)d1[c2] + dC2[c1] + dC1[N];
        long s = Math.min(first, second);

        if(s >= INF) System.out.println(-1);
        else System.out.println(s);

    }

    public static int[] dijkstra(int start, int N){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int v = cur.v;

            if(visited[v]) continue;
            visited[v] = true;

            for(Edge e : edge[v]){
                if(visited[e.to]) continue;
                int nd = dist[v] + e.w;
                if(nd < dist[e.to]){
                    dist[e.to] = nd;
                    pq.offer(new Node(e.to, nd));
                }
            }
        }

        return dist;
    }
}
