

package com.byeon.s1.region;

import java.util.List;

public class RegionView {
	
	public void view(List<RegionDTO> ar) {
		
		for(int i=0; i<ar.size(); i++) {
			System.out.print(ar.get(i).getRegion_id() +"\t");
			System.out.println(ar.get(i).getRegion_name());
			System.out.println("================================");
		}
	}
	
	public void view(String message) {
		
		System.out.println("======================");
		System.out.println("Result : " + message);
		System.out.println("======================");
		
	}

}


