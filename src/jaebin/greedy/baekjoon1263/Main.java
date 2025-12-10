package jaebin.greedy.baekjoon1263;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(stk.nextToken());
			int s = Integer.parseInt(stk.nextToken());
			arr[i][0] = t;
			arr[i][1] = s;
		}

		// 2 5
		// 6 14
		// 15 20
		// 15 16
		Arrays.sort(arr, (a, b) -> b[1] - a[1]);

		int cur = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			int t = arr[i][0];
			int s = arr[i][1];

			cur = Math.min(cur, s) - t;
		}

		if (cur < 0) {
			System.out.println(-1);
		} else {
			System.out.println(cur);
		}

	}
}
