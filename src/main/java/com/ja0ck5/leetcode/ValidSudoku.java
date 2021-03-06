package com.ja0ck5.leetcode;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the 9 3x3 sub-boxes of the
 * grid must contain the digits 1-9 without repetition.
 * 
 * A partially filled sudoku which is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * Example 1:
 * 
 * Input: [ ['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'], ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'], ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'], ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'], ['.','.','.','.','8','.','.','7','9']
 * ] Output: true Example 2:
 * 
 * Input: [ ['8','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'], ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'], ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'], ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'], ['.','.','.','.','8','.','.','7','9']
 * ] Output: false Explanation: Same as Example 1, except with the 5 in the top
 * left corner being modified to 8. Since there are two 8's in the top left 3x3
 * sub-box, it is invalid. Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable. Only the filled cells need to be validated according to the
 * mentioned rules. The given board contain only digits 1-9 and the character
 * '.'. The given board size is always 9x9.
 *
 *
 * Created by Jack on 2018/8/6.
 */
public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		for (int j = 0; j < 9; j++) {
			boolean[] flags = new boolean[9];
			for (int i = 0; i < 9; i++) {
				char c = board[i][j];
				if (c != '.') {
					if (flags[(c - '1')]) {
						return false;
					} else {
						flags[(c - '1')] = true;
					}
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			boolean[] flags = new boolean[9];
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c != '.') {
					if (flags[(c - '1')]) {
						return false;
					} else {
						flags[(c - '1')] = true;
					}
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			boolean[] flags = new boolean[9];
			for (int j = i / 3 * 3; j < i / 3 * 3 + 3; j++) {
				for (int p = i % 3 * 3; p < i % 3 * 3 + 3; p++) {
					char c = board[j][p];
					if (c != '.') {
						if (flags[(c - '1')]) {
							return false;
						} else {
							flags[(c - '1')] = true;
						}
					}
				}
			}

		}

		return true;
	}

	public static boolean isValidSudoku2(char[][] board) {
		int[][] signs = new int[3][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				int n = 1 << (board[i][j] - '1');
				int cubeIndex = i / 3 * 3 + j / 3;
				if ((signs[0][i] & n) != 0 || (signs[1][j] & n) != 0 || (signs[2][cubeIndex] & n) != 0)
					return false;
				signs[0][i] |= n;
				signs[1][j] |= n;
				signs[2][cubeIndex] |= n;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		isValidSudoku2(board);
	}

}
