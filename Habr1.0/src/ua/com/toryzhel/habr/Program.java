package ua.com.toryzhel.habr;

/**
 * «аполните массив случайным числами и выведите максимальное, 
 * минимальное и среднее значение.
 * ƒл€ генерации случайного числа используйте метод Math.random(), 
 * который возвращает значение в промежутке [0, 1].
 * 
 * @author Semenchenko V.
 * 
 */  

public class Program {

	
	public static void main(String[] args) {

		int n = 10;
		int max, min;
		double a = 0;
		
		int[] MyArray = new int [n];
	
		
		//«аполн€ем массив числами
		for (int i = 0; i<n; i++) {
			MyArray[i] = (int) (Math.random() * n);
			System.out.println(MyArray[i]);
			a += MyArray[i]; //записываем сумму всех чисел
		}
		
		max = min = MyArray[0];
		
		//ѕоиск максимального и минимального числа
		for (int i = 0; i<n; i++) {
		if (max < MyArray[i]) {
			max = MyArray[i];
		}
		if (min > MyArray[i]) {
			min = MyArray[i];
		}
		}
		System.out.printf("Max, min: %d, %d\n", max, min);
		System.out.printf("Medium: %f", a/n);
	}

}
