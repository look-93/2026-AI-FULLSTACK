package com.the703;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
	@GetMapping("/tmptAdmin")
	public String tmpt() {return "tmptAdmin"; } //prefix(/templates) + tmpt + suffix(.html)
}
