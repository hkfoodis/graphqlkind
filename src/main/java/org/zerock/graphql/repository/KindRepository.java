package org.zerock.graphql.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.graphql.entity.Kind;

@Transactional
@Repository
public class KindRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	public Kind findKind(String code) {
		try {
			String sql = "Select e from " + Kind.class.getName() + " e where e.kind_code =: kind_code";
			
			Session session = this.sessionFactory.getCurrentSession();
			Query<Kind> query = session.createQuery(sql, Kind.class);
			query.setParameter("kind_code", code);
			return (Kind) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Kind findbyName(String name) {
		try {
			String sql = "Select e from " + Kind.class.getName() + " e where e.kind_name =: kind_name";
			
			Session session = this.sessionFactory.getCurrentSession();
			Query<Kind> query = session.createQuery(sql, Kind.class);
			query.setParameter("kind_name", name);
			return (Kind) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Kind> findAll() {
		try {
			String sql = "Select e from " + Kind.class.getName() + " e ";
			
			Session session = this.sessionFactory.getCurrentSession();
			Query<Kind> query = session.createQuery(sql, Kind.class);
			
			List<Kind> results = query.list();
	        return results;
		} catch (NoResultException e) {
			return null;
		}
	}
}
