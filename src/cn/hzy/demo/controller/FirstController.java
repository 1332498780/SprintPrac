package cn.hzy.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hzy.demo.model.Person;

@Controller
@RequestMapping("/hello")
public class FirstController{

	@RequestMapping("/me")
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1,Model model) throws Exception {
		model.addAttribute("msg", "hello");
		return "first";
	}

	@RequestMapping("/int")
	public String intTest(int a) throws Exception {
		System.out.println(a);
		return "first";
	}
	
	@RequestMapping("/date")
	public String dateTest(Date date) throws Exception {
		System.out.println(date.toString());
		return "first";
	}
	
	@RequestMapping(value="/person",method= {RequestMethod.POST})
	public String personTest(Person person) throws Exception {
		System.out.println(person);
		return "first";
	}
	
	
}
