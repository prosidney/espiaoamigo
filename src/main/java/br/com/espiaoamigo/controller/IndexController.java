package br.com.espiaoamigo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.espiaoamigo.dao.impl.LocationDaoImpl;

@Controller
public class IndexController {
	
	@Autowired
	private LocationDaoImpl locationDaoImpl;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/maps/{user}", method=RequestMethod.GET)
	public String showAdminPage(@PathVariable Integer user, 
								HttpServletRequest request){
		
		request.setAttribute("location", locationDaoImpl.find(user));
		
		return "index";
	}
}
