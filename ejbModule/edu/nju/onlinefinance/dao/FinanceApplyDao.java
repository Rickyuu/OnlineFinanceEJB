package edu.nju.onlinefinance.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.onlinefinance.model.FinanceApply;

@Remote
public interface FinanceApplyDao {
	// ���һ��������
	public Long addApply(FinanceApply financeApply);
	
	// �ı�ĳ�������״̬
	public boolean updateApplyState(Long applyid, String applystate);
	
	// ��������������Ϣ
	public List<FinanceApply> getAllApplies();
	
	// ����������Ż�������
	public FinanceApply getFinanceApplyById(Long applyid);
}
