package notice.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeEditController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		System.out.println("NoticeEditController pass");
		
		String seq=request.getParameter("c");
		NoticeDao dao=new NoticeDao();
		Notice n=dao.getNotice(seq);
		
		//request에 Notice n을 담아주기
		request.setAttribute("n", n);
		
		request.getRequestDispatcher("noticeEdit.jsp").forward(request, response);
		
		
	}
	

}
