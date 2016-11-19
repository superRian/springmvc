package ljy.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author jing:
 * @version 创建时间：2016-10-4 下午02:52:46
 * 类说明
 */

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileUpload")
	@Token(saveToken=true)
	public String testFileUpload(HttpSession session,MultipartFile uploadName){
		System.out.println("one");
//		System.out.println(session.getAttribute("token"));
//		String fileName = uploadName.getOriginalFilename();
//		try {
//			InputStream is = uploadName.getInputStream();
//			String path = session.getServletContext().getRealPath("/upload");
//			System.out.println("path:"+path);
//			File file = new File(path+fileName);
//			uploadName.transferTo(file);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return form(session, uploadName);
	}
	
	@RequestMapping(value = "form")  
    @Token(removeToken = true)  
    public String form(HttpSession session, MultipartFile uploadName)  {  
		System.out.println(session.getAttribute("token"));
		String fileName = uploadName.getOriginalFilename();
		try {
			InputStream is = uploadName.getInputStream();
			String path = session.getServletContext().getRealPath("/upload");
			System.out.println("path:"+path);
			File file = new File(path+fileName);
			uploadName.transferTo(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        return "success";
    }  
}
