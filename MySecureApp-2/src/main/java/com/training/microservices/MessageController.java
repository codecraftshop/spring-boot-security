package com.training.microservices;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/api/message")
	public String mess() {
		return "Hello Protected!";
	}
}
