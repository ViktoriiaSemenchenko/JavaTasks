package ua.com.sourceit.threads;

import static java.lang.System.out;

/**
 * С помощью двух синхронизированных потоков выводить 
 * обычное число и его квадрат (например: 2 и 4).
 * 
 * 
 * @author Semenchenko V.
 *
 */

public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		Object o = new Object();
		
		class Sync {
			
			double num = 4d;
			boolean iswait = false;
			
		}
		Sync s = new Sync();
		
		
		Thread t0 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				synchronized(s) {
				while (!s.iswait) {
				
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			s.num = Math.pow(s.num, 2d);
			out.println(s.num);
			s.iswait = false;
			s.notify();
			}
			}
		});
		
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				synchronized(s) {
				while (s.iswait) {
					
						try {
							s.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				s.num = Math.sqrt(s.num);
				out.println(s.num);
				s.iswait = true;
				s.notify();
				}
			}
			});

		
		t0.start();
		//Thread.sleep(100);
		t1.start();
		
		

		//Thread.currentThread().join();
		
	}

}
