package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.GetStuById;

@WebServlet("/toUpdateStu")
public class toUpdateStu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	
		String id=req.getParameter("id");
			GetStuById getStuById=new GetStuById();
			Student stu=getStuById.getStuById(id);
			req.setAttribute("s", stu);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	
	}

	
	
}
