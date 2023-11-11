package com.in28minutes.springboot.myfirstapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	//say-hello => Hello
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayhello()
	{
		return "Hello! what are you learning today ?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayhelloHtml()
	{
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My Frst html Page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("  My first html page with body");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}

	// JSP
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/todo.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp()
	{
		return "sayHello";
	}

	
}


