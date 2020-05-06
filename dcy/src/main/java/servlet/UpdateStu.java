package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.AddService;
import service.UpdateStuService;

@WebServlet("/updateStu")
public class UpdateStu extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		System.out.println(id);
		Date birthday=null;
		String message="";
		AddService addService=new AddService();
			try {
				birthday = date.parse(req.getParameter("birthday"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String description=req.getParameter("description");
			String avgScore=req.getParameter("avgScore");
		Student student=new Student(id,name,birthday,description,Integer.parseInt(avgScore));
		UpdateStuService updateStuService=new UpdateStuService();
		long hset=updateStuService.updateStuById(student);
		if (hset>0) {
			req.getRequestDispatcher("page").forward(req, resp);
		}else{
			message="修改失敗";
		req.setAttribute("message", message);
		req.getRequestDispatcher("updateStu").forward(req, resp);
		}
	}
	
}
