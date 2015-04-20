package com.aorg.MyPractice.DS.Array;

public class ArrangeArrayElement {

	/**
	 * @param args
	 */
	static int[] a = { 1, 2, 3, -4, -1, 4 };

	public static void main(String[] args) {
		try {
			ArrangeArrayElement ar = new ArrangeArrayElement();

			ar.arrangeArray(0, a.length);
			for (int a1 : a) {
				System.out.println(a1 + ",");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void arrangeArray(int s, int d) {
		try {
			int o = -1;
			for (int i = 0; i < a.length; i++) {
				if (o >= 0) {
					if ((a[i] >= 0 && a[o] < 0) || (a[i]) < 0 && a[o] >= 0) {
						rotate(o, i);
					}
					if ((i - o) > 2) {
						o = o + 2;
					} else {
						o = -1;
					}
				}
				if (o == -1) {
					if ((a[i] > 0 && i % 2 == 0) || (a[i] < 0 && i % 2 != 0)) {
						o = i;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void rotate(int s, int d) {
		try {
			int temp = a[d];
			for (int i = d; i > s; i--) {
				a[i] = a[i - 1];
			}
			a[s] = temp;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
