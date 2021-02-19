package com.cognizant.ormlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.ormlearn.model.Department;


@Component
public class DepartmentDao {

	private static ArrayList<Department> depList;
	
	public DepartmentDao() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Employee.xml");
		depList=(ArrayList<Department>)context.getBean("departmentList");
	}
	
	public ArrayList<Department> getAllDepartments(){
		return depList;
	}
}
