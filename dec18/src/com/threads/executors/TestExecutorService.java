package com.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * @author onlinetechvision.com
 * @since 24 Sept 2011
 * @version 1.0.0
 *
 */
public class TestExecutorService {

 public static void main(String[] args) {
  ExecutorService execService = Executors.newCachedThreadPool();
  execService.execute(new TestTask("FirstTestTask"));
  execService.execute(new TestTask("SecondTestTask"));
  execService.execute(new TestTask("ThirdTestTask"));
  execService.execute(new TestTask("FourthTestTask"));
  execService.execute(new TestTask("FifthTestTask"));
  execService.execute(new TestTask("SixthTestTask"));
  execService.shutdown();
 }
}