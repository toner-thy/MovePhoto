/**
 * Project Name:terminalPortrait
 * File Name:ConcurrentLinkedQueueTest.java
 * Package Name:terminalPortrait
 * Date:2017年1月20日下午5:00:11
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.toner.util;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:ConcurrentLinkedQueueTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年1月20日 下午5:00:11 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ConcurrentLinkedQueueTest {

	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	
	private static int count = 2;
	
	private static CountDownLatch latch = new CountDownLatch(count);
	
	//生产
	public static void offer(){
		for(int i=0;i<100000;i++){
			queue.offer(i);
		}
	}
	//消费
	static class Poll implements Runnable{
		@Override
		public void run() {
			while(!queue.isEmpty()){
				queue.poll();
			}
			latch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		long timeStart = System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(4);
		ConcurrentLinkedQueueTest.offer();
		for (int i = 0; i < count; i++) {
			es.submit(new Poll());
			es.execute(new Poll());
		}
		latch.await();
		System.out.println("cost time " + (System.currentTimeMillis() - timeStart) + "ms");
		es.shutdown();
		
	}
	
}

