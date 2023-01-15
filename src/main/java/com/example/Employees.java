package com.example;

import java.util.List;

public class Employees {

	private final EmployeeRepository employeeRepository;
	private final BankService bankService;

	public Employees(EmployeeRepository employeeRepository, BankService bankService) {
		this.employeeRepository = employeeRepository;
		this.bankService = bankService;
	}

	public int payEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		int payments = 0;
		for (Employee employee : employees) {
			try {
				bankService.pay(employee.getId(), employee.getSalary());
				employee.setPaid(true);
				payments++;
			} catch (RuntimeException e) {
				employee.setPaid(false);
			}
		}
		return payments;
	}
}
