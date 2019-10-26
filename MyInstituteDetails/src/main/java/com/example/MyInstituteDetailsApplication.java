package com.example;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Address;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.repository.DepartmentRepository;

@SpringBootApplication
public class MyInstituteDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyInstituteDetailsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DepartmentRepository departmentRepository) {
		return arge -> {
			Address address1 = new Address("India", "WB1");
			Address address2 = new Address("India", "WB2");
			Address address3 = new Address("India", "WB3");
			Address address4 = new Address("India", "WB4");
			Address address5 = new Address("India", "WB5");
			Address address6 = new Address("India", "WB6");

			List<Address> addressOfEmployee1 = new ArrayList<Address>();
			addressOfEmployee1.add(address1);
			addressOfEmployee1.add(address2);

			List<Address> addressOfEmployee2 = new ArrayList<Address>();
			addressOfEmployee2.add(address3);
			addressOfEmployee2.add(address4);

			List<Address> addressOfEmployee3 = new ArrayList<Address>();
			addressOfEmployee3.add(address5);
			addressOfEmployee3.add(address6);
			/*
			 * address1.setCountry("India"); address1.setSatate("WB");
			 * address2.setCountry("India"); address2.setSatate("WB");
			 * address3.setCountry("India"); address3.setSatate("WB");
			 * address4.setCountry("India"); address4.setSatate("WB");
			 * address5.setCountry("India"); address5.setSatate("WB");
			 * address6.setCountry("India"); address6.setSatate("WB");
			 */

			Employee employee1 = new Employee("Santu", "santu123", "santupatra@gmail.com", addressOfEmployee1);
			Employee employee2 = new Employee("Ujjal", "ujjal123", "ujjalnandi@gmail.com", addressOfEmployee2);
			Employee employee3 = new Employee("rohit123", "rohit123", "rohit@gmail.com", addressOfEmployee3);

			/*
			 * employee1.setName("Santu"); employee1.setPassword("santu123");
			 * employee1.setEmail("santupatra@gmail.com"); employee2.setName("Ujjal");
			 * employee2.setPassword("ujjal123");
			 * employee2.setEmail("ujjalnandi@gmail.com"); employee3.setName("Rohit");
			 * employee3.setPassword("rohit123"); employee3.setEmail("rohit@gmail.com");
			 * employee1.setAddress(addressOfEmployee1);
			 * employee2.setAddress(addressOfEmployee2);
			 * employee3.setAddress(addressOfEmployee3);
			 */

			List<Employee> employeeOfDepartment1 = new ArrayList<Employee>();
			employeeOfDepartment1.add(employee1);
			employeeOfDepartment1.add(employee2);
			employeeOfDepartment1.add(employee3);

			Department department1 = new Department("ECE", employeeOfDepartment1);

			/*
			 * department1.setName("ECE");
			 * department1.setEmployees(employeeOfDepartment1);
			 */
			departmentRepository.save(department1);

		};

	}
}