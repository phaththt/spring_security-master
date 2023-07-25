package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public String pageForUser (Model model, Principal principal) {
		model.addAttribute("user",userService.loadUserByUsername(principal.getName()));
		return "user";
	}

	@GetMapping(value = "/login")
	public String loginPage() {
		return "login";
	}
}