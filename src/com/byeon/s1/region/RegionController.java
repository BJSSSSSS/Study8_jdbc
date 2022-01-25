

package com.byeon.s1.region;

import java.util.List;
import java.util.Scanner;

public class RegionController {
	
	private RegionDAO regionDAO;
	private RegionInput regionInput;
	private RegionView regionView;
	private Scanner scanner;
	
	public RegionController() {
		
		regionDAO = new RegionDAO();
		regionInput = new RegionInput();
		regionView = new RegionView();
		scanner = new Scanner(System.in);
		
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. Region 출력");
			System.out.println("2. Region 추가");
			System.out.println("3. Region 수정");
			System.out.println("4. Region 삭제");
			System.out.println("5. 프로그램 종료");
			int select = scanner.nextInt();
			RegionDTO regionDTO = null;
			String message = null;
			
			switch(select) {
			case 1:
				System.out.println("1. Region 출력");
				List<RegionDTO> ar = regionDAO.getList();
				regionView.view(ar);
				break;
				
			case 2:
				System.out.println("2. Region 추가");
				regionDTO = regionInput.setInsert();
				int result = regionDAO.setInsert(regionDTO);
				message ="Insert Fail";
				if(result>0) {
					message = "Insert Success";
				}
				regionView.view(message);
				
				break;
				
			case 3:
				System.out.println("3. Region 수정");
				regionDTO = regionInput.setUpdate();
				result = regionDAO.setUpdate(regionDTO);
				message ="Update Fail";
				if(result>0) {
					message = "Update Success";
				}
				regionView.view(message);

				break;
				
			case 4:
				System.out.println("4. Region 삭제");
				regionDTO = regionInput.setDelete();
				result = regionDAO.setDelete(regionDTO);
				message ="Delelte Fail";
				if(result>0) {
					message = "Delelte Success";
				}
				regionView.view(message);

				break;
				
			case 5:
				System.out.println("프로그램 종료");
				flag = false;
				break;
				
			default:
				System.out.println("1 ~ 5번 메뉴 선택!");
				break;
			
			}
			
		}

	}
	
}










