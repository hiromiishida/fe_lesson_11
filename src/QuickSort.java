public class QuickSort {
	static void quick_sort(int[] data, int start, int end) {
		// 開始よりも終了が大きければ処理を終了する
		if (start>=end) {
			return;
		}


		// 範囲の真ん中の値を基準値とする
		int pivotValue = data[ ( start + end ) / 2];
		int right = start;
		int left = end;

		while( true ) {
			// 基準値よりも小さい値を、基準値よりも左から探す
			while(data[right] < pivotValue) { right++; }

			// 基準値よりも大きい値を、基準値よりも右から探す
			while(data[left] > pivotValue) { left--; }

			if (right<=left) {
				// 値を交換する
				replacement(data, right, left);
				right++;
				left--;
				break;
			}
		}

		// 基準値よりも左側を整列
		quick_sort(data, start, left);

		// 基準値よりも右側を整列
		quick_sort(data, right, end);
	}

	private static void replacement(int[] data, int s, int e) {
		int tmp = data[s];
		data[s] = data[e];
		data[e] = tmp;
	}

	public static void main(String[] args) {
		int[] data = {5, 10, 3, 7, 0, 1, 9, 2, 11};

		quick_sort(data, 0, data.length-1);

		for (int j : data) System.out.print(j + ", ");
		System.out.println();
	}
}