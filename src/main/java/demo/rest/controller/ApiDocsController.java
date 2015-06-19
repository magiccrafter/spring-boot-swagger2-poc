package demo.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by magiccrafter on 15/06/2015.
 */
@Controller
public class ApiDocsController {

    @ApiIgnore
    @RequestMapping(value = "/api")
    public String apiReferencePage() {
        return "apiDocs";
    }
}
