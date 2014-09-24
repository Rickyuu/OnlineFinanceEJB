package edu.nju.onlinefinance.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.onlinefinance.model.ProjectUser;

@Remote
public interface ProjectUserDao {
	
	// ������Ŀ��Ż�����еĸ���Ŀ�����߿��ţ����ý�ʣ����
	public List<ProjectUser> getUsersInProject(Long projectid);
	
	// �����û����Ų鿴����û���ص���Ŀ
	public List<ProjectUser> getProjectsByUser(Long userid);
	
	// Ϊĳ����Ŀ���һ�����û�,��������Ŀ���
	public Long addProjectUser(ProjectUser projectUser);
	
	// Ϊ�û�������ĳ����Ŀ�е�ʣ������ý��
	public boolean updateProject(Long projectid, Long attendid, double money);
	
}
