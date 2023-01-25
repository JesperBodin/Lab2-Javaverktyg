package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmployeeTest
{

	Employee employee = new Employee("Jesper", 250000);

	@Test
	void getEmployeeId() {
		assertEquals("Jesper", employee.getId());
	}

	@Test
	void setEmployeeId() {
		employee.setId("Stefan");
		assertEquals("Stefan", employee.getId());
	}

	@Test
	void getEmployeeSalary() {
		assertEquals(250000, employee.getSalary());
	}

	@Test
	void setEmployeeSalary() {
		employee.setSalary(500000);
		assertEquals(500000,employee.getSalary());
	}

	@Test
	void testIfEmployeeIsPaidWithSetterAndGetter() {

		employee.setPaid(true);
		assertTrue(employee.isPaid());
	}


	@Test
	void testToString() {
		String expected = "Employee [id=" + "Jesper" + ", salary=" + 250000.0 + "]";
		assertEquals(expected, employee.toString());
	}
}