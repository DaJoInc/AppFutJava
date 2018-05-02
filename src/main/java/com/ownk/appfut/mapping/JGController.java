package com.ownk.appfut.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/admjugador")
public class JGController {
	@RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
	
		return "admjugador";
    }

}
