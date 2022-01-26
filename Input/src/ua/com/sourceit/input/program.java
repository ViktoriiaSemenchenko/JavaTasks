package ua.com.sourceit.input;
import static java.lang.System.out;
import java.util.Scanner;

/**
 * Ввод температуры в градусах Цельсия и вывод по Фаренгейту
 * 
 * @author Semenchenko V.
 *
 */
public class program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    out.print("Введите температуру в градусах по Цельсию: ");
	    int tc = 0;
	    tc = sc.nextInt();
	    double tf = tc * 9/5 + 32d;
	    
	    out.println(String.format("Температура по Фаренгейту: %f", tf));
	    
	    sc.close();
		

	}

}
