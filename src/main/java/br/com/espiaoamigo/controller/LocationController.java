package br.com.espiaoamigo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.espiaoamigo.dao.impl.LocationDaoImpl;
import br.com.espiaoamigo.model.Location;

@Controller
public class LocationController {
	
	@Autowired
	private LocationDaoImpl locationDaoImpl;
	
	@Transactional
	@RequestMapping(value="insertFirstOne.do", method=RequestMethod.GET)
	public @ResponseBody Location showIndex(HttpServletRequest request,HttpServletResponse response){	
		Location fistOne = locationDaoImpl.find(Integer.parseInt("1"));
		
		if(fistOne == null){
			fistOne = new Location();
		}
		
		fistOne.setLastSeen(new Date());
		fistOne.setLat("-15.7585514");
		fistOne.setLon("-30.5993181");
		fistOne.setObservation("Nothing important");
		
		locationDaoImpl.save(fistOne);
		
		return fistOne;
	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="lastSeen/{id}", method=RequestMethod.GET)
	public @ResponseBody Location showLastSeen(@PathVariable String id){	
		return locationDaoImpl.find(Integer.parseInt(id));
	}
	
	@Transactional
	@RequestMapping(value="lastSeen/update/{user}", method=RequestMethod.POST)
	public @ResponseBody Location updateLastSeen(@PathVariable String user, 
												 @RequestParam String lat,
												 @RequestParam String lng){
		Location find = locationDaoImpl.find(Integer.parseInt(user));
		
		find.setLastSeen(new Date());
		find.setLat(lat);
		find.setLon(lng);
		
		locationDaoImpl.save(find);
		
		return find;
	}
}
