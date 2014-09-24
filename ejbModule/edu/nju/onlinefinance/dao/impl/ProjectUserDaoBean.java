package edu.nju.onlinefinance.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.nju.onlinefinance.dao.ProjectUserDao;
import edu.nju.onlinefinance.model.ProjectUser;

@Stateless
public class ProjectUserDaoBean implements ProjectUserDao {

	@PersistenceContext(unitName = "FinanceManagement")
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectUser> getUsersInProject(Long projectid) {
		List<ProjectUser> projectUsers = null;
		try{
			Query query = entityManager.createQuery("select p from ProjectUser p where p.projectid=?1");
			query.setParameter(1, projectid);
			projectUsers = query.getResultList();
			entityManager.clear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return projectUsers;
	}

	@Override
	public Long addProjectUser(ProjectUser projectUser) {
		entityManager.persist(projectUser);
		return projectUser.getProjectuserid();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateProject(Long projectid, Long attendid, double money) {
		List<ProjectUser> projectUsers = null;
		try{
			Query query = entityManager.createQuery("select p from ProjectUser p where p.projectid=?1 and p.attendid=?2");
			query.setParameter(1, projectid);
			query.setParameter(2, attendid);
			projectUsers = query.getResultList();
			entityManager.clear();
			ProjectUser projectUser = projectUsers.get(0);
			double oldRemainMoney = projectUser.getRemainmoney();
			double oldSpendMoney = projectUser.getSpendmoney();
			projectUser.setRemainmoney(oldRemainMoney - money);
			projectUser.setSpendmoney(oldSpendMoney + money);
			entityManager.merge(projectUser);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectUser> getProjectsByUser(Long userid) {
		List<ProjectUser> projectUsers = null;
		try{
			Query query = entityManager.createQuery("select p from ProjectUser p where p.attendid=?1");
			query.setParameter(1, userid);
			projectUsers = query.getResultList();
			entityManager.clear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return projectUsers;
	}
	
	

}
