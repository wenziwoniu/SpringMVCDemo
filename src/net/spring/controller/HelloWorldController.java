package net.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.spring.base.BaseController;
import net.spring.service.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/class")
public class HelloWorldController extends BaseController {

	@Autowired
	private HelloWorldService helloWorldService;
	
	@RequestMapping("/method")
	public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Object[]> result = helloWorldService.findCfConsumeIns();
		//request.setAttribute("name", "namevalue");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp?password=passwordvalue");//转发方式
		//dispatcher.forward(request, response);
		//response.sendRedirect("/SpringMVCDemo/hellofirst.jsp?password=1234");//重定向
		//转发
		//return "hello";
		//转发
		//return new ModelAndView("hello");
		//重定向
		ModelMap map = new ModelMap();
		map.put("password", "123456");
		return new ModelAndView("redirect:/hellofirst.jsp?username=wangziwen", map);
//		ModelAndView maView = new ModelAndView("hello");
//		maView.addObject("password", "123");
//		return maView;
	}

}