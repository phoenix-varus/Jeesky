package org.iskycode.jeesky.adm.web;

import org.iskycode.jeesky.sys.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/a")
@Controller
public class AdminController {

	@RequestMapping("/index")
	public String index() {
		return Const.ADMIN_JSP + "index";
	}
}
