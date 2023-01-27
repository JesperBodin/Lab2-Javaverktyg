package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EmployeesTest
{

	EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
	BankService bankServiceMock = Mockito.mock(BankService.class);
	Employees employees = new Employees(employeeRepository, bankServiceMock);

	Employee employee1 = new Employee("Jesper",1000000);
	Employee employee2 = new Employee("Julia", 999999);
	Employee employee3 = new Employee("Lennart", 200000);

	@BeforeEach
	void initialize(){
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
	}

	@Test
	void payEmployees() {
		assertThat(employees.payEmployees()).isEqualTo(3);
	}
	@Test
	void catchRunTimeExceptionDuringPayment(){
		Mockito.doThrow(RuntimeException.class).when(bankServiceMock).pay(employee1.getId(), employee1.getSalary());
		employees.payEmployees();

		assertFalse(employee1.isPaid());
	}
	@Test
	void payEmployeesReturnPaidEmployee(){
		employees.payEmployees();
		assertTrue(employee1.isPaid());
	}

	@Test
	void dontPayEmployeesReturnNotPaidEmployee(){
		assertFalse(employee1.isPaid());
	}
}