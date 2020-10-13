package org.zerock.graphql.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.zerock.graphql.entity.Kind;
import org.zerock.graphql.repository.KindRepository;

@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	private final KindRepository kindRepository;
	
	public Query(KindRepository kindRepository) {
		this.kindRepository = kindRepository;
	}
	
	public List<Kind> kinds() {
		List<Kind> result = new ArrayList<>();
		
		result = kindRepository.findAll();
		
		return result;
	}
	
	public Kind kind(String code) {
		return kindRepository.findKind(code);
	}
	
	public Kind kindbyname(String name) {
		return kindRepository.findbyName(name);
	}
	
}
