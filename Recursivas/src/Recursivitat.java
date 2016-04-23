package Recursivitat;

public class Recursivitat {

	public static void main(String[] args) {
		int[] elements = { 3, 3, 3 };
		System.out.println(sumaEnteros(elements, elements.length - 1));
		System.out.println(fibonacci(2));
		square(2);
	}

	private static int sumaEnteros(int[] elements, int posicio) {
		if (posicio < 0)
			return 0;
		return elements[posicio] + sumaEnteros(elements, posicio - 1);
	}

	private static int fibonacci(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fibonacci(n - 1) + fibonacci(n - 2);

	}

	private static void square(int line) {
		squareRec(line, 0);
	}

	private static void squareRec(int line, int steps) {
		if (steps == line)
			return;
		else {

			// Iterative printing
			// for (int i = 0; i < line; i++) {
			// System.out.print("#");
			// }

			// Recursive printing
			printRec(line);

			System.out.println();
			squareRec(line, steps + 1);
		}
	}

	private static void printRec(int number) {
		if (number == 0)
			return;
		System.out.print("#");
		printRec(number - 1);
	}

}