package Login.controller;
	import java.util.List;

import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import Login.model.User;
@EnableWebMvc
	@RestController
	public class ViewController {
	  @Autowired
	  public UserDao userService;
	  @RequestMapping(value = "/view", method = RequestMethod.GET )
	   public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("view");
	    mav.addObject("view", new Login());
	    return mav;
	  }
	  @RequestMapping(value = "/viewProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("view") Login login) {
	 if(userService.validateUser(login)!=null)
	  {ModelAndView map = new ModelAndView("viewProcess");
	  return map.addObject("lists", userService.viewemployees(login));
	  }
	  else
		return new ModelAndView("view").addObject("message", "Username or Password is wrong!!");
	}
	  @RequestMapping(value = "/viewMe", method = RequestMethod.GET )
	  public ModelAndView showme(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("viewMe");
	    mav.addObject("viewMe", new Login());
	    return mav;
	  }
	  @RequestMapping(value = "/viewMeProcess", method = RequestMethod.POST)
	  public ModelAndView showmydetails(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("viewMe") Login login) {
	  User user=userService.validateUser(login);
      if(user!=null)
	  {ModelAndView map = new ModelAndView("viewMe");
	  return map.addObject("message", user.printme());
	  }
	  else
		return new ModelAndView("viewMe").addObject("message", "Username or Password is wrong!!");
	}
	  @RequestMapping(value="/myUser/",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<User> MyUser(@RequestBody Login login, UriComponentsBuilder ucBuilder) {
		  HttpHeaders headers = new HttpHeaders();
	       headers.setLocation( ucBuilder.path("/ShowUsers/").buildAndExpand().toUri());
	       User user=userService.validateUser(login);
	       if(user!=null)
	       { return new ResponseEntity<User>(user, HttpStatus.OK);}
	       else
	       { return new ResponseEntity<User>(HttpStatus.NOT_FOUND);}
	    	  
	    	   
		  }
	  @RequestMapping(value="/ShowUsers/",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<User>> ShowUsers(@RequestBody Login login, UriComponentsBuilder ucBuilder) {
		  HttpHeaders headers = new HttpHeaders();
	       headers.setLocation( ucBuilder.path("/ShowUsers/").buildAndExpand().toUri());
	       if(userService.validateUser(login)!=null)
	       { List<User> user=userService.viewemployees(login);
	       return new ResponseEntity<List<User>>(user, HttpStatus.OK);}
	       else
	       { return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);}
	    	  
	    	   
		  }
}