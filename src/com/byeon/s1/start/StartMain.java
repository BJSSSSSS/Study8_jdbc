package com.byeon.s1.start;

import java.util.List;
import java.util.Scanner;

import com.byeon.s1.department.DepartmentController;
import com.byeon.s1.department.DepartmentDAO;
import com.byeon.s1.department.DepartmentDTO;
import com.byeon.s1.department.DepartmentView;
import com.byeon.s1.location.LocationDAO;
import com.byeon.s1.location.LocationDTO;
import com.byeon.s1.location.LocationView;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		DepartmentController departmentController = new DepartmentController();
		try {
			departmentController.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//---------------- DEPARTMENT TEST --------------
//		DepartmentDTO departmentDTO = new DepartmentDTO();
//		
//		DepartmentDAO departmentDAO = new DepartmentDAO();
//		//객체 생성 = new 생성자호출();
//		//DepartmentDAO departmentDAO = null;
//		//위에껀 데이터 타입 변수명 선언  
//		
//		
//		DepartmentView view = new DepartmentView();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("부서 번호 입력 : ");
//		departmentDTO.setDepartment_id(sc.nextInt());
//		try {
//			departmentDTO = departmentDAO.getOne(departmentDTO);
//			view.viewOne(departmentDTO);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
		

		//---------------- LOCATION TEST --------------
//		LocationDAO locationDAO = new LocationDAO();
//		LocationView locationView = new LocationView();
//		
//		try {
//			List<LocationDTO> ar = locationDAO.getList();
//			locationView.view(ar);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	

	
		System.out.println("DB 연동 테스트 끝");
	}
}
