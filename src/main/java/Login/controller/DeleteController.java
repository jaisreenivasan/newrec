package Login.controller;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;

import Login.dao.UserDao;
import Login.model.Login;
@EnableWebMvc
	@RestController
	public class DeleteController {
	  @Autowired
	  public UserDao userService;
	  @RequestMapping(value = "/delete", method = RequestMethod.GET )
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("delete");
	    mav.addObject("delete", new Login());
	    return mav;
	  }
	  @RequestMapping(value = "/deleteprocess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("delete") Login login) {
	 if(userService.validateUser(login)!=null)
	  {ModelAndView map = new ModelAndView("delete");
	  userService.deleteUser(login);
	  return map.addObject("message","User details deleted");
	  }
	  else
		return new ModelAndView("delete").addObject("message", "Username or Password is wrong!!");
	}
	  @RequestMapping(value="/userDelete/",method = RequestMethod.DELETE)
	  public ResponseEntity<Void> createuser(@RequestBody Login login, UriComponentsBuilder ucBuilder) {
		  HttpHeaders headers = new HttpHeaders();
	       headers.setLocation( ucBuilder.path("/userDelete/").buildAndExpand().toUri());
       if(userService.validateUser(login)!=null)
       {userService.deleteUser(login);
       return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	  }
       else
    	   return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
	  }
}