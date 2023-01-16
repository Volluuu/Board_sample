package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import data.mapper.ReboardMapper;

@RestController
@CrossOrigin
@RequestMapping("/reboard")
public class ReboardController {
	@Autowired
	ReboardMapper reboardMapper;
	

}
