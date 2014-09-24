package edu.nju.onlinefinance.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.nju.onlinefinance.dao.UserDao;
import edu.nju.onlinefinance.model.User;

@Stateless
public class UserDaoBean implements UserDao {
	@PersistenceContext(unitName = "FinanceManagement")
	protected EntityManager entityManager;

	@Override
	public User getUserById(Long userid) {
		User user = entityManager.find(User.class, userid);
		return user;
	}

	@Override
	public boolean addUser(User user) {
		try{
			entityManager.persist(user);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@Override
	public boolean updateUser(Long userid, Long rowId, String newValue) {
		try{
			User user = entityManager.find(User.class, userid);
			if(rowId == 1){
				user.setUserName(newValue);
			}else if(rowId == 2){
				user.setIdentity(newValue);
			}else if(rowId == 3){
				double newMoney = Double.parseDouble(newValue);
				user.setUsermoney(newMoney);
			}
			entityManager.merge(user);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@Override
	public boolean removeUser(Long userid) {
		try{
			User user = entityManager.find(User.class, userid);
			entityManager.remove(user);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		try{
			Query query = entityManager.createQuery("select u from User u");
			users = query.getResultList();
			entityManager.clear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}
	
}
