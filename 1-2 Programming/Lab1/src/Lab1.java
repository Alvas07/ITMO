import java.util.Random;

public class Lab1 {
	public static double getMatrixElement(int i, int j, long[] z, float[] x) {
		double result;
		/*
		if (z[i] == 5) {
			result = Math.pow(3.0 / 4.0 * (Math.log(Math.pow(Math.tan(x[j]), 2)) - 1), Math.sin(Math.sin(x[j])));
		} else if (z[i] == 3 || z[i] == 7 || z[i] == 15 || z[i] == 17 || z[i] == 21) {
			result = Math.pow(Math.tan(x[j]) / 2, (1 - Math.log(Math.pow(Math.cos(x[j]), 2))) / 3);
		} else {
			result = Math.tan(Math.pow(Math.cbrt(Math.asin((x[j] - 4) / 2 * Math.E + 1)) / (1 - Math.cos(Math.log(Math.abs(x[j])))), 2));
		} */

		switch((int) z[i]) {
		case 5:
			result = Math.pow(3.0 / 4.0 * (Math.log(Math.pow(Math.tan(x[j]), 2)) - 1), Math.sin(Math.sin(x[j])));
			break;
		case 3:
		case 7:
		case 15:
		case 17:
		case 21:
			result = Math.pow(Math.tan(x[j]) / 2, (1 - Math.log(Math.pow(Math.cos(x[j]), 2))) / 3);
			break;
		default:
			result = Math.tan(Math.pow(Math.cbrt(Math.asin((x[j] - 4) / 2 * Math.E + 1)) / (1 - Math.cos(Math.log(Math.abs(x[j])))), 2));
			break;
		}

		return result; 
	}

	public static void printMatrix(double[][] matrix) {
		System.out.println("-".repeat(12*16));
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print("|");
				System.out.printf("%10.5f ", matrix[i][j]);
			}
			System.out.println("|");
			System.out.println("-".repeat(12*16));
		}
	}

	public static void main(String[] args) {
		// первый массив
		// long[] z = {21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1};
		long[] z = new long[11];
		long temp = 21;
		for (int i = 0; i < z.length; i++) {
			z[i] = temp;
			temp -= 2;
		}

		// второй массив со случайными числами
		float[] x = new float[16];
		Random rn = new Random();
		float minEl = -14.0F;
		float maxEl = 6.0F;
		for (int i = 0; i < x.length; i++) {
			x[i] = rn.nextFloat(maxEl - minEl) + minEl;
		}

		// третий массив
		double[][] z1 = new double[11][16];
		for (int i = 0; i < z1.length; i++) {
			for (int j = 0; j < z1[i].length; j++) {
				z1[i][j] = getMatrixElement(i, j, z, x);
			}
		}

		printMatrix(z1);
	}
}