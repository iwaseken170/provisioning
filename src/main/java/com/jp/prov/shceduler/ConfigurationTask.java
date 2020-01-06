package com.jp.prov.shceduler;

import java.util.concurrent.ScheduledFuture;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.ConfigDaoInterface;
import model.NewConfig;

import static java.util.concurrent.TimeUnit.*;

import java.io.IOException;
import java.io.Reader;


public class ConfigurationTask extends BaseTask {
    private ProvisionTask provisionTask = new ProvisionTask();

    @Override
    void taskToRun() throws InterruptedException, IOException  {
    	
    	// Check Current Configuration From Database
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlSessionFactory.openSession();
        ConfigDaoInterface mapper = session.getMapper(ConfigDaoInterface.class);
        System.out.println(mapper.getConfig().getStartDate());
        System.out.println("Checking Database settings");
        
       
		/*
		 * Validate if configuration changed
		 */        
     	NewConfig newconfig = new NewConfig();
        if(mapper.getConfig().getProvFlag() != 0) {
            // if savedConfig != currentConfig
        	// savedConfig == currentConfig
        	
        	System.out.println(newconfig.getProvFlag());
        	newconfig.setProvFlag(mapper.getConfig().getProvFlag());
        	System.out.println(newconfig.getProvFlag());
        	
        }
    	newconfig.setProvFlag(mapper.getConfig().getProvFlag());
      	System.out.println(newconfig.getProvFlag());
        
        java.sql.Date systemDate = new java.sql.Date(System.currentTimeMillis());
        if(mapper.getConfig().getStartDate().equals(systemDate)) {
        	
        }
   
        // savedConfig.Frequency
        // if savedDate <= currrentDate
        //validation for below thread
        provisionTask.executeThread(1); //savedConfig.Frequency
    }

    @Override
    void executeThread(int frequency) {
        final ScheduledFuture<?> configHandle =
                scheduler.scheduleAtFixedRate(() -> {
					try {
						taskToRun();
					} catch (InterruptedException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}, 0, frequency, SECONDS);
    }
}
