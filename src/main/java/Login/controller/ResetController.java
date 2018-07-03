package Login.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Login.dao.UserDao;
import Login.model.Change;
import Login.model.User;

public class ResetController {
	

	    public static String generateString() {
	        String uuid = UUID.randomUUID().toString();
	        return uuid;
	    }
	
	@Autowired
	  UserDao userService;
	  @RequestMapping(value = "/changeintermediate", method = RequestMethod.GET)
	  public ModelAndView showChange(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("changeintermediate");
	    mav.addObject("email", new User().getEmail());
	    return mav;
	  }
	  @RequestMapping(value = "/mychangeProcess", method = RequestMethod.POST)
	  public ModelAndView changeProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("change") Change change) {
	    ModelAndView mav = null;
	    User user = userService.validateUser(change);
	    if (null != user) {
	    mav = new ModelAndView("changed");
	    mav.addObject("firstname", user.getFirstname());
	    
	    } else {
	    mav = new ModelAndView("change");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }						
	    return mav;
	  }

	  @RequestMapping(value="/user/{$generateString()}",method = RequestMethod.PUT)
	  public ResponseEntity<String> user(@PathVariable String userid,@PathVariable String password,@PathVariable String newpassword) {

	      Change myuser = new Change();
	      myuser.setUserid(userid);
	      myuser.setPassword(password);
	      myuser.setNewPassword(newpassword);
	      User user=userService.validateUser(myuser);
	      if (user==null) {
	          System.out.println("User "+userid+" not found");
	          return new ResponseEntity<String>("invalid credentials",HttpStatus.NOT_FOUND);
	      }
	      return new ResponseEntity<String>("password changed",HttpStatus.NOT_FOUND);
	  }	
	}