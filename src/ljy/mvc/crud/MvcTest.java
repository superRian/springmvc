package ljy.mvc.crud;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ljy.mvc.crud.dao.EmployeeDao;
import ljy.mvc.crud.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MvcTest {
	@Autowired
	private EmployeeDao employeeDao;
	
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handlerArithmeticException(Exception ex){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
	
	@RequestMapping("/testException")
	public String testException(@RequestParam(value="id",required=false) int id){
		System.out.println("result："+(10/id));
		return "success";
	}
	
	/*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("/springUpload")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
         long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        	//检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="D:/"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
                 
            }
           
        }
        
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "success"; 
    }
	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam(value="desc",required = false) String desc,
			@RequestParam("file") MultipartFile file,HttpServletRequest request){
		System.out.println("desc"+desc);
		String fileName = file.getOriginalFilename();//原始名字
		try {
			//文件输出流
			OutputStream ops = new FileOutputStream("D:/"+fileName);
			//输入流
			InputStream is = file.getInputStream();
			int len = 0;
			while((len=is.read())!=-1){
				ops.write(len);
			}
			ops.flush();
			ops.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	//模仿文件下载
	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte []> testResponseEntity(HttpSession session) throws IOException{
		
		byte[] body=null;
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream("/files/ResponseEntity.txt");
		body = new byte[in.available()];
		in.read(body);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=ResponseEntity.txt");
		
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	//模仿文件上传
	@ResponseBody
	@RequestMapping("/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body){
		System.out.println(body);
		return "hello"+new Date();
	}
	
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		System.out.println("testJson");
		 Collection<Employee> list = employeeDao.getAll();
		return list ;
	}
	
	@RequestMapping("/testConversionServiceConverer")
	public String testConverter(@RequestParam("employee") Employee employee){
		System.out.println("save: " + employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
}
