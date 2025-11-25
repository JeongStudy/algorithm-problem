package jaebin.implementation.baekjoon1041;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer stk = new StringTokenizer(br.readLine());

		long[] dice = new long[6];
		for (int i = 0; i < 6; i++) dice[i] = Long.parseLong(stk.nextToken());

		long AF = dice[0] + dice[5];
		long BE = dice[1] + dice[4];
		long CD = dice[2] + dice[3];

		if (n == 1) {
			long sum = 0;
			long maxVal = 0;
			for (long v : dice) {
				sum += v;
				maxVal = Math.max(maxVal, v);
			}
			System.out.println(sum - maxVal);
			return;
		}

		long m1 = Math.min(
				Math.min(Math.min(dice[0], dice[1]), Math.min(dice[2], dice[3])),
				Math.min(dice[4], dice[5])
		);

		long m2 = Long.MAX_VALUE;

		long[] d = dice;

		long[][] two = {
				{0, 1}, {0, 2}, {0, 3}, {0, 4},
				{1, 2}, {1, 3}, {1, 5},
				{2, 4}, {2, 5},
				{3, 4}, {3, 5},
				{4, 5}
		};

		for (long[] arr : two) {
			m2 = Math.min(m2, d[(int) arr[0]] + d[(int) arr[1]]);
		}

		long m3 = Long.MAX_VALUE;

		long[][] three = {
				{0, 1, 2}, {0, 1, 3}, {0, 2, 4}, {0, 3, 4},
				{5, 1, 2}, {5, 1, 3}, {5, 2, 4}, {5, 3, 4}
		};

		for (long[] arr : three) {
			m3 = Math.min(m3, d[(int) arr[0]] + d[(int) arr[1]] + d[(int) arr[2]]);
		}

		long count3 = 4;
		long count2 = (n - 2) * 8 + 4;
		long count1 = (long) (n - 2) * (n - 2) * 5 + (n - 2) * 4;

		System.out.println(m3 * count3 + m2 * count2 + m1 * count1);
	}
}