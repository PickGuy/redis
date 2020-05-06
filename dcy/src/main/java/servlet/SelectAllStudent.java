package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Page;
import entity.Student;
import redis.clients.jedis.Jedis;
import service.SelectService;
import util.JedisUtils;

@WebServlet("/selectAll")
public class SelectAllStudent extends HttpServlet {
	
	private Jedis jedis=JedisUtils.getJedis();
	@Override
	protected void service(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		String pageNum=req.getParameter("currentPage");
		if (pageNum==null||Integer.parseInt(pageNum)<=0||pageNum=="") {
			pageNum="1";
		}
		
		SelectService selectService=new SelectService();
		Page page=selectService.getPage(pageNum);
		req.setAttribute("stuMap", page);
//		resp.sendRedirect("main.jsp");
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
	
	
}
