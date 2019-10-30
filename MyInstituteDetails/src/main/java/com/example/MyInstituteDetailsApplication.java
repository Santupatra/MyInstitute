package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Address;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyInstituteDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyInstituteDetailsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
		return arge -> {
			Address address1 = new Address("India", "WB1");
			Address address2 = new Address("India", "WB2");
			Address address3 = new Address("India", "WB3");
			Address address4 = new Address("India", "WB4");
			Address address5 = new Address("India", "WB5");
			Address address6 = new Address("India", "WB6");
			Address address7 = new Address("India", "WB7");
			Address address8 = new Address("India", "WB8");
			Address address9 = new Address("India", "WB9");
			Address address10 = new Address("India", "WB10");
			Address address11 = new Address("India", "WB11");
			Address address12 = new Address("India", "WB12");

			List<Address> addressOfEmployee1 = new ArrayList<Address>();
			addressOfEmployee1.add(address1);
			addressOfEmployee1.add(address2);

			List<Address> addressOfEmployee2 = new ArrayList<Address>();
			addressOfEmployee2.add(address3);
			addressOfEmployee2.add(address4);

			List<Address> addressOfEmployee3 = new ArrayList<Address>();
			addressOfEmployee3.add(address5);
			addressOfEmployee3.add(address6);

			List<Address> addressOfEmployee4 = new ArrayList<Address>();
			addressOfEmployee4.add(address7);
			addressOfEmployee4.add(address8);

			List<Address> addressOfEmployee5 = new ArrayList<Address>();
			addressOfEmployee5.add(address9);
			addressOfEmployee5.add(address10);

			List<Address> addressOfEmployee6 = new ArrayList<Address>();
			addressOfEmployee6.add(address11);
			addressOfEmployee6.add(address12);

			Employee employee1 = new Employee("Santu", "santu123", "santupatra@gmail.com", addressOfEmployee1);
			Employee employee2 = new Employee("Ujjal", "ujjal123", "ujjalnandi@gmail.com", addressOfEmployee2);
			Employee employee3 = new Employee("rohit", "rohit123", "rohit@gmail.com", addressOfEmployee3);
			Employee employee4 = new Employee("amrita", "amrita123", "amrita@gmail.com", addressOfEmployee4);
			Employee employee5 = new Employee("shubham", "shubham123", "shubham@gmail.com", addressOfEmployee5);
			Employee employee6 = new Employee("Dinesh", "dinesh123", "dinesh@gmail.com", addressOfEmployee6);

			employeeRepository.save(employee5);
			employeeRepository.save(employee6);

			List<Employee> employeeOfDepartment1 = new ArrayList<Employee>();
			employeeOfDepartment1.add(employee1);
			employeeOfDepartment1.add(employee2);
			employeeOfDepartment1.add(employee3);

			List<Employee> employeeOfDepartment2 = new ArrayList<Employee>();
			employeeOfDepartment2.add(employee4);

			Department department1 = new Department("ECE", employeeOfDepartment1);
			Department department2 = new Department("CSE", employeeOfDepartment2);
			Department department3 = new Department("IT");

			departmentRepository.save(department1);
			departmentRepository.save(department2);
			departmentRepository.save(department3);
		};

	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Institution Management", "Using This API you can manage your Institution Details", "1.0.0",
				null, new Contact("S@n2 Patra", null, "santupatra02@gmail.com"), null, null, Collections.emptyList());
	}
}