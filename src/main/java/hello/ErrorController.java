package hello;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {
 
    @GetMapping(value = "errors")
    public String renderErrorPage(HttpServletRequest httpRequest,
								  Model model) {
		/*String errorMsg = "nothing";	
		
		int httpErrorCode = getErrorCode(httpRequest);
		
		switch (httpErrorCode) {
            case 400: {
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
            }
            case 404: {
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
            }
            case 500: {
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
            }
        }
		
        model.addAttribute("errorMsg", "test");*/
        return "error";
    }
}