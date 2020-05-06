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
import javax.xml.bind.DataBindingException;

import entity.Student;
import service.AddService;
import util.SnowFlakeIdWorker;

@WebServlet("/addStu")
public class addStu extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		String name=req.getParameter("name");
		Date birthday=null;
		AddService addService=new AddService();
		String message="";
		try {
			birthday = date.parse(req.getParameter("birthday"));
			String description=req.getParameter("description");
			String avgScore=req.getParameter("avgScore");
			Student student=new Student(String.valueOf(new SnowFlakeIdWorker(0, 0).nextId()),name,birthday,description,Integer.parseInt(avgScore));
			long flag=addService.addStu(student);
			if (flag<0) {
				message="添加失败";
			}
			resp.sendRedirect("page");
		} catch (Exception e) {
			message="格式不正确，请重新输入";
			req.setAttribute("message", message);
			resp.sendRedirect("page");
		}
		
		
	}
}
	
	

