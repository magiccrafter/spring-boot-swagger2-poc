package demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * This class is a replacement for the Spring Boot default Whitelabel Error Page.
 * If templates are used could be replaced by simple error.html page in the /templates folder.
 * Custom Error handler/controller is preferred so that we can exclude the /error endpoint from the
 * Swagger documentation. Otherwise we cannot.
 *
 * Created by magiccrafter on 15/06/2015.
 */
@RestController
public class DefaultErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;


    @Override
    public String getErrorPath() {
        return PATH;
    }

    @ApiIgnore
    @RequestMapping(value = PATH)
    public ErrorResponseJson error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring.
        // Here we just define response body.
        return new ErrorResponseJson(response.getStatus(), getErrorAttributes(request, true));
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

    /**
     * Defines the error response body in Json.
     */
    public class ErrorResponseJson {

        public Integer status;
        public String error;
        public String message;
        public String timeStamp;
        public String trace;

        public ErrorResponseJson(int status, Map<String, Object> errorAttributes) {
            this.status = status;
            this.error = (String) errorAttributes.get("error");
            this.message = (String) errorAttributes.get("message");
            this.timeStamp = errorAttributes.get("timestamp").toString();
            this.trace = (String) errorAttributes.get("trace");
        }
    }
}
