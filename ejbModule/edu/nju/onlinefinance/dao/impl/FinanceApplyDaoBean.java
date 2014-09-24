package edu.nju.onlinefinance.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.nju.onlinefinance.dao.FinanceApplyDao;
import edu.nju.onlinefinance.model.FinanceApply;

@Stateless
public class FinanceApplyDaoBean implements FinanceApplyDao {
	@PersistenceContext(unitName = "FinanceManagement")
	protected EntityManager entityManager;
	
	@Override
	public Long addApply(FinanceApply financeApply) {
		entityManager.persist(financeApply);
		return financeApply.getApplyid();
	}

	@Override
	public boolean updateApplyState(Long applyid, String applystate) {
		try{
			FinanceApply financeApply = entityManager.find(FinanceApply.class, applyid);
			financeApply.setApplystate(applystate);
			entityManager.merge(financeApply);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FinanceApply> getAllApplies() {
		List<FinanceApply> applies = null;
		try{
			Query query = entityManager.createQuery("select f from FinanceApply f");
			applies = query.getResultList();
			entityManager.clear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return applies;
	}

	@Override
	public FinanceApply getFinanceApplyById(Long applyid) {
		return entityManager.find(FinanceApply.class, applyid);
	}

}
