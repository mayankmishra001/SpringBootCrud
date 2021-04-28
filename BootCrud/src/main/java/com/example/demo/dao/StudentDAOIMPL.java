package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.StudentDTO;

@Repository
public class StudentDAOIMPL implements StudentInt{
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void add(StudentDTO dto) {
		System.out.println("Student DAO run");
		entityManager.persist(dto);
	}

	@Override
	public void update(StudentDTO dto) {
		// TODO Auto-generated method stub
		
		entityManager.merge(dto);
	}

	@Override
	public void delete(StudentDTO dto) {
		System.out.println(dto+"______________");
		try {
		entityManager.remove(dto);}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	@Override
	public StudentDTO findByPK(long id) {

		StudentDTO dto=entityManager.find(StudentDTO.class, id);
		return dto;
	}

	@Override
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		
		CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		
		//to create query
		CriteriaQuery<StudentDTO> query=builder.createQuery(StudentDTO.class);
		
		//from tablename
		Root<StudentDTO> root=query.from(StudentDTO.class);
		query.select(root);
		
		//where clause
				List<Predicate> list=new ArrayList<Predicate>();
				
		/*
		 * if(dto.getFirstName()!=null&&dto.getFirstName().length()>0) {
		 * 
		 * list.add(builder.like(root.get("firstName"),dto.getFirstName()+"%")); }
		 */

				query.where(list.toArray(new Predicate[list.size()]));
				TypedQuery<StudentDTO> tquery=entityManager.createQuery(query);
				
				if (pageSize > 0) {
					tquery.setFirstResult((pageNo-1)*(pageSize));
					tquery.setMaxResults(pageSize);
				}
				List list1=tquery.getResultList();
				
				return list1;
	}

}
