package com.jp.prov.shceduler;

public class ProvisioningToolMainThread {

	public static void main(String[] args){		
	    BaseTask task = new ConfigurationTask();
        task.executeThread(10);
	}
}