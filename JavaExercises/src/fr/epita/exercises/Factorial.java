package fr.epita.exercises;

public class Factorial {

	public static void main(String[] args) {

	}

	private static int factorialRecursive(int depth) {
		if (depth == 1) {
			return 1;
		} else {
			return factorialRecursive(depth - 1) * depth;
		}
	}

	private static int ternaryFactorialRecursive(int depth) {
		return depth == 1 ? 1 : ternaryFactorialRecursive(depth - 1) * depth;
	}

	private static int factorialIterative(int repetitions) {
		int result = repetitions;
		for (int i = repetitions - 1; i > 1; i--) {
			result *= i;
		}
		return result;
	}
}
