package ua.com.sourseit.conditions;
import static java.lang.System.out;

/**
 * ��������� �� ������� ����� "������" ������������ �����.
 * 
 * @author Semenchenko V.
 *
 */

public class conditions {

	public static void main(String[] args) {
		int v = 420;
		if (v > 10 && v < 20) {
			out.println("�����");
		} else if (v % 10 == 1 && v != 11) {
			out.println("������");
		} else if(v % 10 == 2 || v % 10 == 3 || v % 10 == 4 ) {
			out.println("������");
		} else {
			out.println("�����");
		}
	}
}
