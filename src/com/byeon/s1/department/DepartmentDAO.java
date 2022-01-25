

package com.byeon.s1.department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.byeon.s1.util.DBConnector;

public class DepartmentDAO {
	//DAO : Data Access Object
	private DBConnector dbConnector;
	
	public DepartmentDAO() {
		dbConnector = new DBConnector();
	}
	
	//INSERT
	public int setInsert(DepartmentDTO departmentDTO) throws Exception{
		
		int result = 0;
		Connection con = dbConnector.getConnect();
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());// DEPARTMENTS_SEQ.NEXTVAL
		st.setString(2, departmentDTO.getDepartment_name());
		st.setInt(3, departmentDTO.getManager_id());
		st.setInt(4, departmentDTO.getLocation_id());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	//DELETE
	public int setDelete(DepartmentDTO departmentDTO) throws Exception{
		
		int result = 0;
		Connection con = dbConnector.getConnect();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, departmentDTO.getDepartment_id());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	
	
	
	
	//부서정보, 부서에 근무하는 사원들의 정보
	public void getDEP_EMPList() throws Exception {
		
		Connection con = dbConnector.getConnect();
		
		String sql ="SELECT D.*, E.* "
				+ "FROM EMPLOYEES E "
				+ "    INNER JOIN "
				+ "    DEPARTMENTS D "
				+ "    ON(E.DEPARTMENT_ID = D.DEPARTMENT_ID) ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
		}
		
		
		rs.close();
		st.close();
		con.close();
		

	}
	
	
	
	//부서번호로 조회
	public DepartmentDTO getOne(DepartmentDTO dep) throws Exception{
		//여기서 밑에 null로 잡는것은 if문을 나왔을때도 값을 잡는게 있어야 하기 때문이다! 잊지말자
		//어제 리스트로 잡아줄때는 리스트가 나와있는 확장자였기때문에 문제가 없었는데 오늘은 없기에 이렇게 진행
		DepartmentDTO departmentDTO = null;
		
		//1. DB에 로그인
		Connection con = dbConnector.getConnect();
		
		//2. SQL Query 문 작성
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";// or DEPARTMENT_ID = ?";
													  // 첫번째 ?가 1번, 두번째 ?가 2번
		
		//3. 작성한 Query 문 미리 전송 DB가 준비
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값을 세팅, 없으면 pass - 위에 2번 확인! 입력숫자가 올 경우 ? 값을 세팅하게된다
		//st.set 데이터타입(int index, 값); 
		//index 는 ?의 순서번호
		//그러나 oracle은 1번부터 시작!!
		st.setInt(1, dep.getDepartment_id());
		// 1번에 매개변수로 받은 값을 넣어준다
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		//1개의 row가 있거나 없거나
		if(rs.next()) {
			//데이터가 있을때 - 데이터가 있으면 생성해준다
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setManager_id(rs.getInt("Manager_id"));
			departmentDTO.setLocation_id(rs.getInt("Location_id"));
//			departmentDTO.setDepartment_id(rs.getInt(1));
//			departmentDTO.setDepartment_name(rs.getString(2));
//			departmentDTO.setManager_id(rs.getInt(3));
//			departmentDTO.setLocation_id(rs.getInt(4));
			//이래도 가능!
		}
		
		//6. 외부 연결 해제
		
		rs.close();
		st.close();
		con.close();
		
		return departmentDTO;
		
	}
	
	
	
	//전체 조회
	public List<DepartmentDTO> getList() throws Exception {
		
		ArrayList<DepartmentDTO> ar = new ArrayList<>();
		
		//SELECT * FROM DEPARTMENTS;
		//1. DB로그인
		Connection con = dbConnector.getConnect();
		
		//2. SQL Query 문 작성
		 // Java에서는 ; 제외
		 String sql = "SELECT * FROM DEPARTMENTS";
		
		//3. 작성한 SQL Query 미리 전송
		 PreparedStatement st = con.prepareStatement(sql);
		 
		//4. ? 값을 세팅, 없으면 통과
		 
		//5. 최종 전송 후 결과 처리
		 ResultSet rs = st.executeQuery();
		 
		 //cursor가 한줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false
		 while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO(); 
			 
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			
			//arrayList
			ar.add(departmentDTO);
			
		 }	
		 
		//6. 외부 연결 해제
		//	연결된 순서의 역순
		 
		rs.close();
		st.close();
		con.close();

		
		return ar;
	}
}



