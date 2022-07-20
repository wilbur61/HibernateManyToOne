package com.test.project.HibernateManyToOne;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.perscholas.model.Department2;
import com.perscholas.model.Teacher2;
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction t = session.beginTransaction();   
    						
		Teacher2 t1 = new Teacher2();
		t1.setTeachername("Haseeb");
		t1.setSalary("100");

		Teacher2 t2 = new Teacher2();
		t2.setTeachername("Jenny Finch");
		t2.setSalary("10000");
	
		Teacher2 t3 = new Teacher2();
		t3.setTeachername("James");
		t3.setSalary("25000");
	
		Teacher2 t4 = new Teacher2();
		t4.setTeachername("SID ROSE");
		t4.setSalary("3000");
		
		Teacher2 t5 = new Teacher2();
		t5.setSalary("200");
		t5.setTeachername("Ali");
		   
	  //Add teacher entity object to the list
	   List<Teacher2> teachlist = new ArrayList();
	   teachlist.add(t1);
	   teachlist.add(t2);
	   teachlist.add(t3);
	   teachlist.add(t4);
	   teachlist.add(t5);
	   session.save(t1);
	   session.save(t2);
	   session.save(t3);
	   session.save(t4);
	   
	   //Create Department 
 	   Department2 department = new Department2();
	   department.setDname("Development");
	   department.setTeacherList(teachlist);
		   
	   //Store Department
	    session.save(department);
		t.commit();
    }
}