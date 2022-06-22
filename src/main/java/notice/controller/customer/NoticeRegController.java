package notice.controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeRegController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("NoticeRegController pass");

		//화면전환
		request.getRequestDispatcher("noticeReg.jsp").forward(request, response);
		
	}
	

}
