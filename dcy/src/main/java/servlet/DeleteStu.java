package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DeleteStuService;

@WebServlet("/deleteStu")
public class DeleteStu extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		System.out.println(id);
		DeleteStuService deleteStuService=new DeleteStuService();
		Long flag=deleteStuService.deleteStuById(id);
		resp.sendRedirect("page");
		
	}
	
	
	
	
	
	
}
