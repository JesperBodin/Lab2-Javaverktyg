package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository
{
	List <Employee> employeeList = new ArrayList<>();
	@Override
	public List<Employee> findAll() {
		return employeeList;
	}

	@Override
	public Employee save(Employee e)
	{
		employeeList.add(e);
		return e;
	}
}
