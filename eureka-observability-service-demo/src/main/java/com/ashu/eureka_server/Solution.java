package com.ashu.eureka_server;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public void spiralOrder(int[][] matrix, int i, int j, int dirindex, List<Integer> res) {

		res.add(matrix[i][j]);
		matrix[i][j] = -101;
		for (int k = 0; k < 4; k++) {
			int dir = (dirindex + k) % 4;
			if ((i + dirs[dir][0] >= 0 && i + dirs[dir][0] < matrix.length)
					&& (j + dirs[dir][1] >= 0 && j + dirs[dir][1] < matrix.length)
					&& matrix[i + dirs[dir][0]][j + dirs[dir][1]] != -101) {
				spiralOrder(matrix, i + dirs[dir][0], j + dirs[dir][1], dir, res);
			}
		}

	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		spiralOrder(matrix, 0, 0, 0, res);
		return res;
	}

	public static void main(String[] args) {
//		new Solution().calculate("1 + 1");
//		new Solution().calculate(" 2-1 + 2 ");
//		new Solution().calculate("(1+(4+5+2)-3)+(6+8)");
//		new Solution().calculate("2147483647");
		new Solution().spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } });

	}
}