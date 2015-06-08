package br.com.espiaoamigo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.espiaoamigo.dao.impl.LocationDaoImpl;

@Controller
public class IndexController {
	
	@Autowired
	private LocationDaoImpl locationDaoImpl;
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/maps", method=RequestMethod.GET)
	public String showAdminPage(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("location", locationDaoImpl.find(1));
		
		return "index";
	}
}
