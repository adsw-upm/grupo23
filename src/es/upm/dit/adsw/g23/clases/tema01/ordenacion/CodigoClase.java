package es.upm.dit.adsw.g23.clases.tema01.ordenacion;

public class CodigoClase {

	public static int[] ordenar1(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				if (nums[j - 1] > nums[j]) {
					int t = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = t;
				}
			}
		}
		return nums;
	}

	public static int[] ordenar2(int[] nums) {
		int[] ordenados = new int[nums.length];
		int ultimo = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int minimo = Integer.MAX_VALUE;
			for (int j = 0; j < nums.length; j++) {
				int val = nums[j];
				if (val > ultimo && val < minimo) {
					minimo = val;
				}
			}
			ordenados[i] = minimo;
			ultimo = minimo;
		}
		return ordenados;
	}

	public static int[] ordenar3(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int e = nums[i];
			int j = i;
			while (j > 0) {
				if (nums[j - 1] < e) {
					break;
				}
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = e;
		}
		return nums;
	}

	public static int[] ordenar4(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int e = nums[i];
			int j = i;
			while (j > 0) {
				if (nums[j - 1] < e) {
					break;
				}
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = e;
		}
		return nums;
	}
}
