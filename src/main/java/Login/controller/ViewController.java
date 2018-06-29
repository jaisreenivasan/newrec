package Login.controller;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

import Login.model.Login;
import Login.model.User;
	import Login.dao.UserDao;
	@Controller
	public class ViewController {
	  @Autowired
	  public UserDao userService;
	  @RequestMapping(value = "/view", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("view");
	    mav.addObject("view", new Login());
	    return mav;
	  }
	  @RequestMapping(value = "/viewProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("view") Login login) {
	 if(userService.validateUser(login)!=null)
	  {ModelAndView map = new ModelAndView("view");
	  return map.addObject("lists", userService.viewemployees(login));
	  }
	  else
		return new ModelAndView("view").addObject("message", "Username or Password is wrong!!");
	}
}