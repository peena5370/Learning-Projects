package com.learning.demo.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.Profiler;
import org.slf4j.profiler.TimeInstrument;

public class LoggingMainApplication {

	private final static Logger log = LoggerFactory.getLogger(LoggingMainApplication.class);

	public static void main(String[] args) {
		Profiler profiler = new Profiler("Sample");
		profiler.setLogger(log);
		//Starting a child stop watch and stopping the previous one.
		profiler.start("Task 1");
		testMethod1();

		//Starting another child stop watch and stopping the previous one.
		profiler.start("Task 2");
		testMethod2();

		//Stopping the current child watch and the global watch.
		TimeInstrument tm = profiler.stop();

		//Logging the contents of the time instrument
	    tm.log();
	}

	public static void testMethod1(){
		double sum = 0;
		for(int i=0; i< 1000; i++){
			sum = sum+(Math.pow(i, 2));
		}
		log.info("Sum of squares of the numbers from 1 to 10000: "+sum);
	}

	public static void testMethod2(){
		int sum = 0;
		for(int i=0; i< 10000; i++){
			sum = sum+i;
		}
		log.info("Sum of the numbers from 1 to 10000: "+sum);
	}
}
