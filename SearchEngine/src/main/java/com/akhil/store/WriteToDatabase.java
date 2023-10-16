package com.akhil.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class WriteToDatabase {
	
	public void writeToDatabase(String url,String textData) {
		SessionFactory factory = null;
		try{Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		 factory =  cfg.buildSessionFactory();//ensures that the factory variable
		 //is always initialized, even if an exception occurs
		 }
		catch(Exception e){
			e.printStackTrace();
		}
		
		CrawlData cr = new CrawlData();
		cr.setUrl(url);
		cr.setUrlData(textData);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(cr);
		
		tx.commit();
		s.close();
		factory.close();
		}
}
