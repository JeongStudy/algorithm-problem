package jaebin.back_tracking.baekjoon15655;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		int[] arr = new int[n];

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(arr);

		result = new StringBuilder();

		backtracking(0, 0, m, arr, new ArrayList<>());

		System.out.println(result.toString().trim());
	}

	public static StringBuilder result;

	public static void backtracking(int index, int count, int m, int[] arr, List<Integer> list) {
		if (count == m) {
			for (int i : list) result.append(i + " ");
			result.append("\n");
			return;
		}

		for (int i = index; i < arr.length; i++) {

			list.add(arr[i]);
			backtracking(i + 1, count + 1, m, arr, list);
			list.remove(list.size() - 1);
		}
	}

}
