package notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import notice.db.DBCon;
import notice.vo.Member;

public class MemberDao {

	public Member getMember(String uid) throws Exception {
		Connection conn = DBCon.getConnection();

		String sql = "select * from nmember where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, uid);
		ResultSet rs = pstmt.executeQuery();// psmtm형식 실행
//		rs.next();
		Member m=null;

//		db에 셀렉트 결과를 Member파일에 저장
		if(rs.next()) {
			m=new Member();
			
			m.setId(rs.getString("id"));
			m.setPwd(rs.getString("pwd"));
			System.out.println("m.id : "+m.getId());
		}
		

		rs.close();
		// st.close();
		pstmt.close();

		conn.close();

		return m;

	}

}
