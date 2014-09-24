package edu.nju.onlinefinance.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.nju.onlinefinance.dao.ProjectDao;
import edu.nju.onlinefinance.model.Project;

@Stateless
public class ProjectDaoBean implements ProjectDao {
	@PersistenceContext(unitName = "FinanceManagement")
	protected EntityManager entityManager;

	@Override
	public Project getProjectById(Long projectid) {
		Project project = entityManager.find(Project.class, projectid);
		return project;
	}

	@Override
	public Long addProject(Project project) {
		try{
			entityManager.persist(project);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return project.getProjectid();
	}

	@Override
	public boolean updateProject(Long projectid, Long rowId, String newValue) {
		try{
			Project project = entityManager.find(Project.class, projectid);
			if(rowId == 1){
				project.setProjectname(newValue);
			}else if(rowId == 2){
				Long newHostId = Long.parseLong(newValue);
				project.setHostid(newHostId);
			}else if(rowId == 3){
				double newMoney = Double.parseDouble(newValue);
				project.setProjectmoney(newMoney);
			}else if(rowId == 4){
				Date deadline = Date.valueOf(newValue);
				project.setDeadline(deadline);
			}
			entityManager.merge(project);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@Override
	public boolean removeProject(Long projectid) {
		try{
			Project project = entityManager.find(Project.class, projectid);
			entityManager.remove(project);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = null;
		try{
			Query query = entityManager.createQuery("select p from Project p");
			projects = query.getResultList();
			entityManager.clear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return projects;
	}
	
}
