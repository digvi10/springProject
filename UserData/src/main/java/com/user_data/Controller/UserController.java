package com.user_data.Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.user_data.Service.UserService;
import com.user_data.entity.Userdata;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping("home")
	public String home() {
		
		return "/";
	}

	@RequestMapping("login")
	public String login() {
		Date date =new Date();
		
		System.out.println(java.time.LocalDate.now());
		return "login";
	}

	@RequestMapping("loginVerify")
	public String loginVerify(@RequestParam String email, @RequestParam String password, ModelMap modelmap) {
		HttpSession session = request.getSession();
		boolean verify = service.verify(email, password);
		if (verify == true) {
			session.setAttribute("email", email);
			Userdata shows = service.show(email);
			modelmap.addAttribute("user", shows);
			return "show";
		}
		return "login";
	}

	@RequestMapping("reg")
	public String Regester() {
		
		return "regester";
	}

	@RequestMapping("save")
	public RedirectView saveUser(@RequestParam("image") MultipartFile multipartFile, String name, String email,
			String phone, String password) throws IOException {
		

		service.save(multipartFile, name, email, phone, password);
		return new RedirectView("/login", true);
	}

}
