package jaebin.greedy.baekjoon23843;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());

		Integer[] arr = new Integer[n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
			max = Math.max(max, arr[i]);
		}

		Arrays.sort(arr, (a, b) -> {
			return b - a;
		});

		for (int i = 0; i < m; i++) {
			pq.add(0);
		}

//		System.out.println(pq);
		for (int i = 0; i < n; i++) {
			int cur = arr[i];

			int minTime = pq.poll();
			pq.add(cur + minTime);

//			System.out.println(pq);
		}

		int answer = 0;

		while (!pq.isEmpty()) {
			answer = Math.max(answer, pq.poll());
		}
		System.out.println(answer);
	}
}
