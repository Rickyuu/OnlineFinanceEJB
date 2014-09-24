package edu.nju.onlinefinance.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.nju.onlinefinance.dao.ApplyItemDao;
import edu.nju.onlinefinance.model.ApplyItem;

@Stateless
public class ApplyItemDaoBean implements ApplyItemDao {

	@PersistenceContext(unitName = "FinanceManagement")
	protected EntityManager entityManager;
	
	@Override
	public boolean addApplyItem(ApplyItem applyItem) {
		try{
			entityManager.persist(applyItem);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<ApplyItem> getItemsInApply(Long applyid) {
		List<ApplyItem> items = null;
		try{
			Query query = entityManager.createQuery("select a from ApplyItem a where a.applyid=?1");
			query.setParameter(1, applyid);
			items = query.getResultList();
			entityManager.clear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return items;
	}

}
