package com.nrapoport.spring.mvc;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ValidateRESTController {

    @RequestMapping("/validate")
    public String index() {
        return "{\"message\": \"Application Started!\"}";
    }

}
