

package com.byeon.s1.department;

import java.util.Scanner;


public class DepartmentInput {

	private Scanner scanner;
	
	public DepartmentInput() {
		scanner = new Scanner(System.in);
	}
	
	//Insert
	public DepartmentDTO setInsert() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		
		System.out.println("새로운 DEPARMENT ID를 입력하시오 : ");
		departmentDTO.setDepartment_id(scanner.nextInt());
		System.out.println("새로운 DEPARMENT NAME을 입력하시오 : ");
		departmentDTO.setDepartment_name(scanner.next());
		System.out.println("새로운 MANAGE ID를 입력하시오 : ");
		departmentDTO.setManager_id(scanner.nextInt());
		System.out.println("새로운 LOCATION ID를 입력하시오 : ");
		departmentDTO.setLocation_id(scanner.nextInt());
		
		return departmentDTO;
	}
	
	
	//Delete
	public DepartmentDTO setDelete() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		
		System.out.println("삭제할 DEPARMENT ID를 입력하시오 : ");
		departmentDTO.setDepartment_id(scanner.nextInt());
		
		return departmentDTO;
	}
	
	
	
	
	
}


