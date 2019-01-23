package com.multi;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.multi.dao.CustomerDao;
import com.multi.entity.Customer;

public class Main1 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 初始化基础数据
		long a = System.currentTimeMillis();
		
		CustomerDao dao = (CustomerDao)ctx.getBean("customerDao");
		List<Customer> result1 = dao.find1();
		System.out.println("size1  : "+result1.size());
		System.out.println("result1: "+JSON.toJSONStringWithDateFormat(result1, "yyyy-MM-dd hh:mm:ss"));
		
		List<Customer> result2 = dao.find2();
		System.out.println("size2  : "+result2.size());
		System.out.println("result2: "+JSON.toJSONStringWithDateFormat(result2, "yyyy-MM-dd hh:mm:ss"));
		
		Customer entity1 = new Customer("师傅A",150);
		entity1.setId(159);
		dao.save1(entity1);
		
		Customer entity2 = new Customer("师傅B",151);
		entity2.setId(160);
		dao.save2(entity2);
		
		long z = System.currentTimeMillis();
		z = (z-a);
		System.out.println("测试结束。。。。用时："+z+"毫秒");
	}
	
}



