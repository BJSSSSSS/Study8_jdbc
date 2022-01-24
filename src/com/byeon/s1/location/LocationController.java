

package com.byeon.s1.location;

import java.util.List;
import java.util.Scanner;

public class LocationController {


	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner scanner;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		scanner = new Scanner(System.in);
	}
	
	public void start() throws Exception{
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("1. 위치 전체 출력");
			System.out.println("2. 입력 위치 출력");
			System.out.println("3. 프로그램 종료");
			int select = scanner.nextInt();
			
				if(select == 1) {
					List<LocationDTO> ar = locationDAO.getList();
					locationView.view(ar);
				}else if(select == 2) {
					
					System.out.println("검색할 도시명을 입력하시오 : ");
					String city = scanner.next();
					LocationDTO locationDTO = locationDAO.getOne(city);
					if(locationDTO != null) {
						locationView.view(locationDTO);
					}else {
						System.out.println("검색 실패!");
					}
					
				}else if(select == 3) {
					System.out.println("프로그램 종료!");
					break;
				}else {
					System.out.println("1 ~ 3번 숫자로 선택 요망");
				}
				
				
			}
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
}


