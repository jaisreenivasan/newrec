package Login.controller;
	import javax.servlet.http.HttpServletRequest;
import org.springframework.web.util.UriComponentsBuilder;
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
import Login.model.User;
	import Login.dao.UserDao;
	@RestController
	public class RegController {
	  @Autowired
	  public UserDao userService;
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new User());
	    return mav;
	  }
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) {
	  if(userService.register(user))
	  return new ModelAndView("welcome", "firstname", user.getFirstname());
	  else
		  return new ModelAndView("register","message","User with UserId "+user.getUserid()+" aldready exists");
	  }
	  @RequestMapping(value="/user/",method = RequestMethod.POST)
	  public ResponseEntity<String> createuser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
       
       HttpHeaders headers = new HttpHeaders();
       headers.setLocation( ucBuilder.path("/user/").buildAndExpand().toUri());
       if(userService.register(user))
       return new ResponseEntity<String>("User created",headers, HttpStatus.CREATED);
       else
    	return new ResponseEntity<String>("User aldready exists",headers, HttpStatus.FORBIDDEN);
	  }
	}
