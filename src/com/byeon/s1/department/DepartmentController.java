

package com.byeon.s1.department;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {

	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private Scanner scanner;
	
	public DepartmentController() {
		
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		scanner = new Scanner(System.in);
		
	}
	
	
	public void start() throws Exception{
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 프로그램 종료");
			int select = scanner.nextInt();
			
			switch(select) {
			case 1:
				System.out.println("1. 부서 리스트 출력");
				List<DepartmentDTO> ar = departmentDAO.getList();
				departmentView.view(ar);
				break;
			case 2:
				System.out.println("2. 부서 번호 검색");
				System.out.println("부서 번호를 입력하시오 : ");
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartment_id(scanner.nextInt());
				departmentDTO = departmentDAO.getOne(departmentDTO);
				
				if(departmentDTO != null) {
					departmentView.viewOne(departmentDTO);
				}else {
					System.out.println("검색 실패!");
				}
				
				break;
			case 3:
				System.out.println("3. 프로그램 종료");
				flag = false;
				break;
			default:
				System.out.println("1~3번 선택!");
				break;

			
			}
			
		}

	}
}









