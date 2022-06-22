package notice.controller.customer;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("NoticeController pass");

		String field=request.getParameter("f");
		System.out.println("field : "+field);
		if(field==null || field.equals("")) {
			field="title";
		}
		String query=request.getParameter("q");
		if(query==null)
			query="";
		
		//db접속해서 select 결과물을 가져오기
		 NoticeDao dao=new NoticeDao();
		 List<Notice> list=dao.getNotices(field,query);
		 
		//request에 Notice n을 담아주기
		request.setAttribute("list", list);
		request.setAttribute("query", query);
		
			
		request.getRequestDispatcher("notice.jsp").forward(request, response);
		
	}
	

}
