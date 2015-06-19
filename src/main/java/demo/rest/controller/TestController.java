package demo.rest.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by magiccrafter on 15/06/2015.
 */
@RestController
@Api(value = "test")
public class TestController {

    @RequestMapping(value = "/test", method= RequestMethod.GET)
    @ApiOperation(value = "Test value", notes = "Test note")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}