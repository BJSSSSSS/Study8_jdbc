

package com.byeon.s1.region;

public class RegionTest {

	public static void main(String[] args) {
		// Region Package내에 있는 것만 Test
		
		RegionDAO regionDAO = new RegionDAO();
		RegionDTO regionDTO = new RegionDTO();
		
		regionDTO.setRegion_id(5L);
		regionDTO.setRegion_name("South Pole");
		
		
		try {
			//insert test
			//int result = regionDAO.setInsert(regionDTO);
			
			//delete test
			//int result = regionDAO.setDelete(regionDTO);
			
			//update test
			int result = regionDAO.setUpdate(regionDTO);
			
			if(result>0) {
				System.out.println(result);
				System.out.println("성공");
			}else {
				System.out.println(result);
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}


