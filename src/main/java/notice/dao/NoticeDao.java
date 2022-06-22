package notice.dao;

import java.sql.*;
import java.util.*;



import notice.db.DBCon;
import notice.vo.Notice;

public class NoticeDao {
	
	public List<Notice> getNotices(String field, String query) throws Exception{
		Connection conn=DBCon.getConnection();
		
		//String sql="select * from notices order by to_number(seq) desc";
		
		//String sql="select * from notices where title like '%e%' order by to_number(seq) desc";
		
		String sql="select * from notices";
				sql+=" where "+field+" like ?";
				sql+=" order by to_number(seq) desc";

		//실행
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "%"+query+"%");
		//결과값 가져오기
		ResultSet rs=pstmt.executeQuery();
		
		//select결과물 모두를 List에 저장
		List<Notice> list=new ArrayList<Notice>();
		while(rs.next()) {
			Notice n=new Notice();
			n.setSeq(rs.getString("seq"));
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			n.setContent(rs.getString("content"));
			n.setRegdate(rs.getDate("regdate"));
			n.setHit(rs.getInt("hit"));
			////
			
			list.add(n);
		}
		return list;
	}
	
	public int insert(Notice n) throws Exception {
		Connection conn=DBCon.getConnection();
		//접속성공
		String sql="insert into notices(seq,title,writer,content,regdate,hit)"
					+" values((select max(to_number(seq))+1 from notices),?,'kim',?,sysdate,0)";

		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, n.getTitle());
		pstmt.setString(2, n.getContent());

		//실행
		int cnt=pstmt.executeUpdate();//insert 실행
		
		pstmt.close();
		conn.close();
		return cnt;
		
	}
	
	
	public int delete(String seq) throws Exception {
		Connection conn=DBCon.getConnection();
		//접속성공
		//String sql="select * from notices where seq="+seq;
		String sql="delete from notices where seq=?";

		//Statement st=conn.createStatement();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		//ResultSet rs=st.executeQuery(sql);//stmtm형식 실행 select 실행

		int af=pstmt.executeUpdate();//delete실행
		pstmt.close();
		conn.close();
		
		return af;
	}
	public int update(Notice notice) throws Exception {
		
		Connection conn=DBCon.getConnection();
		//접속성공
		//String sql="select * from notices where seq="+seq;
		String sql="update notices set title=?,content=? where seq=?";

		//Statement st=conn.createStatement();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(3, notice.getSeq());
		pstmt.setString(2, notice.getContent());
		pstmt.setString(1, notice.getTitle());
		//ResultSet rs=st.executeQuery(sql);//stmtm형식 실행 select 실행
		int cnt=pstmt.executeUpdate();//psmtm형식 실행
		
		
		pstmt.close();
		conn.close();
		
		return cnt;
	}
	
	
	public Notice getNotice(String seq) throws Exception {
		
		Connection conn=DBCon.getConnection();
		
		//접속성공
		//String sql="select * from notices where seq="+seq;
		String sql="select * from notices where seq=?";
		
		//Statement st=conn.createStatement();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		//ResultSet rs=st.executeQuery(sql);//stmtm형식 실행 select 실행
		ResultSet rs=pstmt.executeQuery();//psmtm형식 실행
		rs.next();
		
//		db에 셀렉트 결과를 Notice파일에 저장
		Notice n=new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		
		rs.close();
		//st.close();
		pstmt.close();
		
		conn.close();
		
		return n;
		
	}
	
	public Notice getNotice(String seq, String hit) throws Exception {
		
		Connection conn=DBCon.getConnection();
		
		//hit1 증가값 처리
		int hnum=Integer.parseInt(hit);
		//메소드로 처리
		
		hitupdate(seq,hnum); 
		
		
		//접속성공
		//String sql="select * from notices where seq="+seq;
		String sql="select * from notices where seq=?";

		//Statement st=conn.createStatement();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, seq);
		//ResultSet rs=st.executeQuery(sql);//stmtm형식 실행 select 실행
		ResultSet rs=pstmt.executeQuery();//psmtm형식 실행
		rs.next();
		
//		db에 셀렉트 결과를 Notice파일에 저장
		Notice n=new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		
		rs.close();
		//st.close();
		pstmt.close();

		conn.close();
		
		return n;
		
	}

	private void hitupdate(String seq, int hnum) throws Exception {
		Connection conn=DBCon.getConnection();
		String sql="update notices set hit=? where seq=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hnum+1);
		pstmt.setString(2, seq);
		
		pstmt.executeUpdate();//실행
	}
	

}
