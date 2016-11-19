package ljy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ljy.mvc.entity.User;
import ljy.mvc.views.ExcelView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExcelViewController {
	
	 @RequestMapping(value = "/viewexcel")
	 public ModelAndView viewExcel() {
	        Map<String, Object> model = new HashMap<>();
	        model.put("userList", getStudents());
	        return new ModelAndView(new ExcelView(), model);
	    }
	    private List<User> getStudents() {
	        List<User> userList = new ArrayList<>();
	        User user = new User(1, "Tome", "Tom@qq.com","123");
	        userList.add(user);
	        return userList;
	    }
}
