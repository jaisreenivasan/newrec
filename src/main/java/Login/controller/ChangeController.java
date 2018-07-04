package Login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import Login.model.Change;
import Login.model.User;
import Login.dao.UserDao;
@RestController
public class ChangeController {
  @Autowired
  UserDao userService;
  @RequestMapping(value = "/change", method = RequestMethod.GET)
  public ModelAndView showChange(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("change");
    mav.addObject("change", new Change());
    return mav;
  }
  @RequestMapping(value = "/changeProcess", method = RequestMethod.POST)
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
  @RequestMapping(value="/user/changePassword/",method = RequestMethod.PUT)
  public ResponseEntity<String> user(@RequestBody Change change, UriComponentsBuilder ucBuilder) {
     
      if (userService.validateUser(change) != null) {
    	  return new ResponseEntity<String>("password changed",HttpStatus.OK);
      }
      else
      {
          return new ResponseEntity<String>("invalid credentials",HttpStatus.NOT_FOUND);
      
      }
  }	
}