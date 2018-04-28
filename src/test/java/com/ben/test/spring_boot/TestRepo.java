package com.ben.test.spring_boot;

import java.util.List;
import java.util.stream.Stream;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.ben.springdata_h2_poc.Configurations;
import com.ben.springdata_h2_poc.models.Customer;
import com.ben.springdata_h2_poc.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { Configurations.class })
public class TestRepo  {

//	private EmbeddedDatabase db;
//	
	
//	
	
	@Autowired
	CustomerRepository costumerDao;
	
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
       template = new JdbcTemplate(dataSource);
    }
	
	private static boolean isInitialized = false;
	
	private JdbcTemplate template;
	
	@Autowired
	private ApplicationContext ctx;
	
	 @SuppressWarnings("deprecation")
	@Before
	    public void runOnce() {
	        if (isInitialized) return;
	        System.out.println("Initializing database");
	        
	   
	        String script1 ="file:C:\\Ben\\springBootTests\\spring_boot\\src\\test\\java\\data_resources\\create-db.sql"; 
	        String script2 = "file:C:\\Ben\\springBootTests\\spring_boot\\src\\test\\java\\data_resources\\insert-data.sql";
	        Resource resource =  ctx.getResource(script1);
	        JdbcTestUtils.executeSqlScript(template, resource, true);          
	        Resource resource2 =  ctx.getResource(script2);
	        JdbcTestUtils.executeSqlScript(template, resource2, true);   
	        isInitialized = true;
	    } 
	 
	 @Transactional
	@Test
	public void testRepoMain()
	{
		try {

	    	Customer cust = new Customer("bb","dd");
			costumerDao.save(cust);
	    	List<Customer> custList = (List<Customer>) costumerDao.findAll();    	
	    	System.out.println(custList);
	    	
	    	Stream<Customer> s= costumerDao.findByIdReturnStream(Long.valueOf("1"));
	    	s.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

    	
	}
}
