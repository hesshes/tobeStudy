package com.hesshes.studytobe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hesshes.studytobe.dao.CountingConnectionMaker;
import com.hesshes.studytobe.dao.CountingDaoFactory;
import com.hesshes.studytobe.dao.UserDao;

// list 1-40
public class UserDaoConnectionCountingTest {
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

		UserDao dao = context.getBean("userDao", UserDao.class);

		//
		// DAO ��� �ڵ�
		//
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter : " + ccm.getCounter());

	}

}
