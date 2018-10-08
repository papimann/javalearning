package com.kapil.java8.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class SequenceThreads {

	public static void main(String[] args) {

		List<SequenceThreadWorker> workersList = new ArrayList<>();
		// Create the workers
		int maxLength = 100;

		for (int i = 0; i < 10; i++) {
			SequenceThreadWorker w = new SequenceThreadWorker();
			if (i > 0) {
				SequenceThreadWorker w1 = workersList.get(i - 1);
				w1.setNext(w, maxLength);
			}
			workersList.add(i, w);
		}

		int size = workersList.size();

		if (!workersList.isEmpty()) {
			workersList.get(size - 1).setNext(workersList.get(0), maxLength);
		}

		for (SequenceThreadWorker worker : workersList) {
			Thread t = new Thread(worker, "Thread-" + (workersList.indexOf(worker) + 1) + " - ");
			t.start();
		}

		workersList.get(0).accept(1);
	}
}

class SequenceThreadWorker implements Runnable {

	BlockingQueue<Integer> bq = new LinkedBlockingDeque<>();
	SequenceThreadWorker next = null; // next worker in the chain
	private int maxLength;

	public void setNext(SequenceThreadWorker next, int maxLength) {
		this.next = next;
		this.maxLength = maxLength;
	}

	public void accept(int i) {
		bq.add(i);
	}

	@Override
	public void run() {
		boolean canContinue = true;
		while (canContinue) {
			try {
				int i = bq.take(); // blocks till it receives a number
				System.out.println(Thread.currentThread().getName() + i);
				if (i == maxLength) {
					canContinue = false;
				} else if (next != null) {
					next.accept(i + 1); // pass the next number to the next worker
				}
			} catch (InterruptedException e) {
				System.err.println(Thread.currentThread().getName() + " interrrupted.");
			}
		}
	}

}
