package notice.controller.joinus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.Controller;
import notice.dao.MemberDao;
import notice.vo.Member;

public class LoginProcController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LoginProcController pass");
		
		String uid=request.getParameter("id");
		String pwd=request.getParameter("password");
		
		MemberDao dao=new MemberDao();
		Member m=dao.getMember(uid);
		
		if(m==null) {
			request.setAttribute("error", "아이디없음");
			request.getRequestDispatcher("loginform.jsp").forward(request, response);
		}else if(!m.getPwd().equals(pwd)) {
			request.setAttribute("error", "비밀번호불일치");
			request.getRequestDispatcher("loginform.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("uid", uid);
			response.sendRedirect("../customer/notice.do");
		}
		
	}

}
