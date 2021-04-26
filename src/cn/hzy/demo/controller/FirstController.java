package cn.hzy.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class FirstController{

	@GetMapping("/me")
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
//		model.addAttribute("msg", "hello");
		return "first";
	}


}
