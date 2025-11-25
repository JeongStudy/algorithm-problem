package jaebin.divide_and_conquer.baekjoon16438;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] teamFlag = new char[7][n];

		for (int d = 0; d < 7; d++) {
			for (int i = 0; i < n; i++) {
				teamFlag[d][i] = 'A';
			}
		}

		dfs(0, n - 1, 0, 'A', 'B', teamFlag);

		StringBuilder sb = new StringBuilder();
		for (int d = 0; d < 7; d++) {
			for (int i = 0; i < n; i++) {
				sb.append(teamFlag[d][i]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());

	}

	public static void dfs(int l, int r, int days, char t1, char t2, char[][] teamFlag) {
		if (days == 7 || l > r) {
			return;
		}

		int mid = (l + r) / 2;

		for (int i = l; i <= r; i++) {
			if (i <= mid) teamFlag[days][i] = t1;
			else teamFlag[days][i] = t2;
		}

		dfs(l, mid, days + 1, t2, t1, teamFlag);

		dfs(mid + 1, r, days + 1, t1, t2, teamFlag);

	}
}
