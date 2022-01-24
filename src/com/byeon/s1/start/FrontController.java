package com.byeon.s1.start;

import java.util.Scanner;

import com.byeon.s1.department.DepartmentController;
import com.byeon.s1.employee.EmployeeController;
import com.byeon.s1.location.LocationController;

public class FrontController {
	
	private Scanner sc;
	private DepartmentController departmentController;
	// LocationController
	private LocationController locationController;
	// EmployeeController
	private EmployeeController employeeController;
	
	public FrontController() {
		sc= new Scanner(System.in);
		departmentController = new DepartmentController();
		// LocationController
		locationController = new LocationController();
		// EmployeeController
		employeeController = new EmployeeController();
	}
	
	
	public void mainStart() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 직 원  관 리");
			System.out.println("2. 부 서  관 리");
			System.out.println("3. 지 역  관 리");
			System.out.println("4. 프로그램 종료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				// employeeController의 start 메서드 호출
				employeeController.start();
				break;
			case 2:
				departmentController.start();
				break;
			case 3:
				// locationController의 start 메서드 호출
				locationController.start();
				break;
			default:
				flag = false;
				break;
			}
			
		}
		
	}
	

}