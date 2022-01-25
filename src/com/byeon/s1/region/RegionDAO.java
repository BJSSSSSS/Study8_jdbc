

package com.byeon.s1.region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.byeon.s1.util.DBConnector;

public class RegionDAO {

	private DBConnector dbConnector;
	
	public RegionDAO() {
		dbConnector = new DBConnector();
	}
	
	//대륙정보 출력
	public List<RegionDTO> getList() throws Exception{
		
		ArrayList<RegionDTO> ar = new ArrayList<>();
		Connection con = dbConnector.getConnect();
		String sql = "SELECT * FROM REGIONS";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getLong("region_id"));
			regionDTO.setRegion_name(rs.getString("region_name"));
			ar.add(regionDTO);
			
		}
		
		rs.close();
		st.close();
		con.close();

		return ar;
		
	}
	
	
	
	
	//대륙정보 수정 setUpdate , name 수정
	public int setUpdate(RegionDTO regionDTO) throws Exception{
		
		int result = 0;
		Connection con = dbConnector.getConnect();
		String sql ="UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, regionDTO.getRegion_name());
		st.setLong(2, regionDTO.getRegion_id())
		;
		result = st.executeUpdate();
		st.close();
		con.close();

		return result;
	}
	
	
	
	
	//대륙정보 삭제
	public int setDelete(RegionDTO regionDTO) throws Exception{
		
		int result = 0;
		Connection con = dbConnector.getConnect();
		String sql = "DELETE REGIONS WHERE REGION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, regionDTO.getRegion_id());
		result = st.executeUpdate();
		st.close();
		con.close();
		
		return result;
	}
	
	//대륙정보 추가
	public int setInsert(RegionDTO regionDTO) throws Exception {
		//1. DB 연결
		Connection con = dbConnector.getConnect();
		
		//2. SQL Query문 생성
		String sql = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES (?, ?)";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 세팅
		st.setLong(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		
		//5. 최종 저송 후 결과 처리
		int result = st.executeUpdate();
		
		//6. 자원 해제
		st.close();
		con.close();

		return result;
		
	}
	
	
	
	//검색조회
	//전체조회
	
	
	
	
	
	
	
}


