package com.jp.prov.shceduler;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class BaseTask implements Runnable  {
	
	 protected final ScheduledExecutorService scheduler =
	            Executors.newScheduledThreadPool(2);

	    abstract void taskToRun() throws InterruptedException, IOException;

	    abstract void executeThread(int frequency);

	    @Override
	    public void run() {
	        try {
				taskToRun() ;
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
	    }
	}
