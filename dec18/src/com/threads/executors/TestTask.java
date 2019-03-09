package com.threads.executors;


/**
 * @author onlinetechvision.com
 * @since 24 Sept 2011
 * @version 1.0.0
 *
 */
public class TestTask implements Runnable {
	//private static Logger log = Logger.getLogger(TestTask.class);
	private String taskName;

	public TestTask(String taskName) {
		this.taskName = taskName;
	}

	public void run() {
		try {
			//log.debug(this.taskName + " is sleeping...");
			System.out.println(this.taskName + " is sleeping...");
			Thread.sleep(30);
			// log.debug(this.taskName + " is running...");
			System.out.println(this.taskName + " is running...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}