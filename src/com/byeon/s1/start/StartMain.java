package com.byeon.s1.start;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		FrontController frontController = new FrontController();
		
		try {
			frontController.mainStart();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		
		
//		try {
//		//frontController.mainStart();
//		RegionDAO regionDAO = new RegionDAO();
//		RegionDTO regionDTO = new RegionDTO();
////		regionDTO.setRegion_id(6L);
////		regionDTO.setRegion_name("South Pole");
//		//int result = regionDAO.setInsert(regionDTO);
//		
//		regionDTO.setRegion_id(6L);
//		int result = regionDAO.setDelete(regionDTO);
//		
//		if(result > 0) {
//			System.out.println("작동 성공!");
//		}else {
//			System.out.println("작동 실패!");
//		}
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//		
		

//		DepartmentController departmentController = new DepartmentController();
//		try {
//			departmentController.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		LocationController locationController = new LocationController();
//		try {
//			locationController.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
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
