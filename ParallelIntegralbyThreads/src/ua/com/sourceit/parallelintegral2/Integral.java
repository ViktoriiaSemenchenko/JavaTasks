package ua.com.sourceit.parallelintegral2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.function.DoubleFunction;

public class Integral {

	public static final int STEPS = 10_000_000;
	public static final int TASKS = 10;
	
	public static double singleThreadIntegral (DoubleFunction<Double> f, double a, double b) {
		
		return singleThreadIntegral(f, a, b, STEPS);
		
	}
	
	public static double singleThreadIntegral (DoubleFunction<Double> f, double a, double b, int steps) {
			
		double sum = 0d;
		
		double h = (b-a)/steps;
		
		for (int i=0; i<steps; i++) {
			double x = a + h*i +h/2;
			double y = f.apply(x);
			sum += y * h;
		}
		
		return sum;

	}
	
	public static double multiThreadIntegral (DoubleFunction<Double> f, double a, double b) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(4);
		Future<Double>[] tasks = new Future[10];
		for (int i=0; i<TASKS; i++) {
			double hx = (b-a)/TASKS;
			double ax = a + hx*i;
			double bx = ax + hx;
			tasks[i] = pool.submit(()->Integral.singleThreadIntegral(f, ax, bx, STEPS/TASKS));
		}
		
		double sum = 0d;
		for(Future<Double> task: tasks) {
			sum += task.get();
		}
		
		pool.shutdown();
		return sum;
	}
	
	public static double multiThreadIntegral2(DoubleFunction<Double> f, double a, double b) throws ExecutionException, InterruptedException {

        double hx = (b - a)/TASKS;
        DoubleAdder sum = new DoubleAdder();

        Thread[] threads = new Thread[TASKS];
        for(int i = 0; i < TASKS; i++){
            double ax = a + hx*i;
            double bx = ax + hx;
            threads[i] = new Thread(() -> {
                double integral = Integral.singleThreadIntegral(f, ax, bx, STEPS/TASKS);
                sum.add(integral);
                });  
            threads[i].start();
        }
        for(Thread t : threads){
            t.join();
        }

        return sum.sum();
    }
	
	public static double multiThreadIntegral3 (DoubleFunction<Double> f, double a, double b) {
		class Pair{
			double a;
			double b;
			
			public Pair(double a, double b) {
				this.a = a;
				this.b = b;
			}
		}
		double hx = (b-a)/TASKS;
		List<Pair> pairs = new ArrayList<>();
		
		for (int i = 0; i < TASKS; i++) {
			pairs.add (new Pair(a+i*hx, a+(i+1)*hx));
		}
		return pairs
		.parallelStream()
		.mapToDouble(p->Integral.singleThreadIntegral(f, p.a, p.b, STEPS/TASKS))
		.sum();
		
	}
}