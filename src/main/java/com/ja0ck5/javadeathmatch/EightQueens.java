package com.ja0ck5.javadeathmatch;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 21:23 2018/9/12
 * @Modified By:
 */
public class EightQueens {

	/**
	 * 方案个数
	 */
	public static int NUM = 0;

	public static final int MAXQUEEN = 8;

	/**
	 * 皇后的位置
	 */
	public static int[] COLS = new int[MAXQUEEN];

	public void getCount(int n) {
		// 记录每个放个是否可以放
		boolean[] rows = new boolean[MAXQUEEN];
		for (int i = 0; i < n; i++) {
			rows[COLS[i]] = true;
			// 斜对角
			int d = n - i;
			// 正斜
            if(COLS[i] - d >= 0){
                rows[COLS[i] - d] = true;
            }
			// 反斜
            if(COLS[i] + d <= (MAXQUEEN - 1)){
                rows[COLS[i] + d] = true;
            }
		}

        for (int i = 0; i < MAXQUEEN; i++) {
            if(rows[i]){
                continue;
            }

            COLS[n] = i;
            if(n < MAXQUEEN - 1){
                getCount(n+1);
            }else{
                NUM++;
                print();
            }

        }

	}

    private void print() {
        System.out.println("approach : " +NUM);
        for (int i = 0; i < MAXQUEEN; i++) {
            for (int j = 0; j < MAXQUEEN; j++) {
                if(i == COLS[j]){
                    System.out.print("[] ");
                }else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new EightQueens().getCount(0);
    }

}
