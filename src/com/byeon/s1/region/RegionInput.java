package com.byeon.s1.region;

import java.util.Scanner;

public class RegionInput {

	private Scanner sc;
	
	public RegionInput() {
		sc = new Scanner(System.in);
	}
	
	//update
	public RegionDTO setUpdate() {
		RegionDTO regionDTO = new RegionDTO();
		System.out.println("변경할 Region ID를 입력하세요 : ");
		regionDTO.setRegion_id(sc.nextLong());
		System.out.println("변경할 Region Name을 입력하세요 : ");
		regionDTO.setRegion_name(sc.next());
		
		return regionDTO;
	}
	

	//delete
	public RegionDTO setDelete() {
		RegionDTO regionDTO = new RegionDTO();
		System.out.println("삭제할 Region ID를 입력하세요 : ");
		regionDTO.setRegion_id(sc.nextLong());
		
		return regionDTO;
	}

	
	//insert
	public RegionDTO setInsert() {
		RegionDTO regionDTO = new RegionDTO();
		System.out.println("Region ID를 입력하세요 : ");
		regionDTO.setRegion_id(sc.nextLong());
		System.out.println("Region NAME을 입력하세요 : ");
		regionDTO.setRegion_name(sc.next());
		
		return regionDTO;
		
	}
	
}
