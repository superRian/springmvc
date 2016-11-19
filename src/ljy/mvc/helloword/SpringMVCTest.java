package ljy.mvc.helloword;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import ljy.mvc.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
//@SessionAttributes("user")
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
	private static final String SUCCESS = "success";

	@RequestMapping("/testView")
	public String testView(){
		System.out.println("test view");
		return "helloView";
	}
	
	@RequestMapping("/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		System.out.println("testViewAndViewResolver");
		return SUCCESS;
	}
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map){
		if(id!=null){
			User user = new User(1, "123", "123", "234");
			System.out.println("数据库"+user);
			map.put("user", user);
		}
	}
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user){
		System.out.println(user);
		return SUCCESS;
	}
	@RequestMapping(value="/testSessionAttributes")
	public String testSessionAttributes(Map<String,Object> map){
		User user = new User("123", "123", "234");
		map.put("user", user);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testMap")
	public String testMap(Map<String,Object> map){
		map.put("names",Arrays.asList("tom","jeery"));
		return SUCCESS;
	}
	
	@RequestMapping(value="/testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam("username")String username){
		System.out.println(username);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id ){
		System.out.println("testRest Get"+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String testRest(){
		System.out.println("testRest POST");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id){
		System.out.println("testRest DELETE"+id);
		return SUCCESS;
	}
	
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id){
		System.out.println("testRest PUT"+id);
		return SUCCESS;
	}
	@RequestMapping("/testPojo")
	public String testPojo(User user){
		System.out.println(user);
		return SUCCESS;
	}
}
