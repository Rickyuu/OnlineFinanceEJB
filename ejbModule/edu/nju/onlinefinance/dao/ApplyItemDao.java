package edu.nju.onlinefinance.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.onlinefinance.model.ApplyItem;
import edu.nju.onlinefinance.model.ProjectUser;

@Remote
public interface ApplyItemDao {

	// ���һ��������Ŀ
	public boolean addApplyItem(ApplyItem applyItem);
	
	// ����������ţ���ȡ��ǰ���������������Ŀ
	public List<ApplyItem> getItemsInApply(Long applyid);
	
}
