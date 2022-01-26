package ua.com.toryzhel.habr2;

/**
 * Реализуйте алгоритм сортировки пузырьком для сортировки массива
 * 
 * @author Semenchenko V.
 */

public class Program {

	
	public static void main(String[] args) {
		int n = 10;
		
		int[] MyArray = new int [n];
	
		//заполнение массива
		for (int i = 0; i<n; i++) {
			MyArray[i] = (int) (Math.random() * n);
			System.out.println(MyArray[i]);
		}

		System.out.println("\n");

		//алгоритм сортировки
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n-i-1; j++) {
				if (MyArray[j] < MyArray[j+1]) {
					int temp = MyArray[j];
					MyArray[j] = MyArray[j+1];
					MyArray[j+1] = temp;
				}
			}
		}

		for (int i = 0; i<n; i++) {
			System.out.println(MyArray[i]);
		}
	}	
}	
		
		
		
		
		
		
		
		
		
		