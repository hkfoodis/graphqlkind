package org.zerock.graphql.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.graphql.entity.Kind;
import org.zerock.graphql.repository.KindRepository;

@RestController
@Transactional
public class restController {

	@Autowired
	protected KindRepository kindRepository;
	
	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
	   Object target = dataBinder.getTarget();
	   if (target == null) {
	      return;
	   }
	   System.out.println("Target=" + target); 
	}
	
	@RequestMapping(value="/kinds/{kind_code}", method = RequestMethod.GET)
	public @ResponseBody
	 Kind getKind(@PathVariable String kind_code) {
		
		Kind restaurantlist = kindRepository.findKind(kind_code);
		
		return restaurantlist;
	}
}
