

package com.byeon.s1.department;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {

	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private DepartmentInput departmentInput;
	private Scanner scanner;
	
	public DepartmentController() {
		
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		departmentInput = new DepartmentInput();
		scanner = new Scanner(System.in);
		
	}
	
	
	public void start() throws Exception{
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 부서 번호 추가");
			System.out.println("4. 부서 번호 삭제");
			System.out.println("5. 프로그램 종료");
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
					departmentView.view(departmentDTO);
				}else {
					System.out.println("검색 실패!");
				}
				
				break;
			case 3:
				System.out.println("3. 부서 번호 추가");
				departmentDTO = departmentInput.setInsert();
				int result = departmentDAO.setInsert(departmentDTO);
				String message ="Insert Fail";
				if(result>0) {
					message = "Insert Success";
				}
				departmentView.view(message);
				break;
				

			case 4:
				System.out.println("4. 부서 번호 삭제");
				departmentDTO = departmentInput.setDelete();
				result = departmentDAO.setDelete(departmentDTO);
				message ="Delete Fail";
				if(result>0) {
					message = "Delete Success";
				}
				departmentView.view(message);
				break;
				
			case 5:
				System.out.println("5. 프로그램 종료");
				flag = false;
				break;
			default:
				System.out.println("1 ~ 5번 사이 숫자 선택!");
				break;

			}
			
		}

	}
}









