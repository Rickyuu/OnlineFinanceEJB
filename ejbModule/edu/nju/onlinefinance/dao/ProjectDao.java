package edu.nju.onlinefinance.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.onlinefinance.model.Project;

@Remote
public interface ProjectDao {
	
	// �����û��������Ŀ��ţ������Ŀ
	public Project getProjectById(Long projectid);
	
	// ���һ������Ŀ
	public Long addProject(Project project);
	
	// ����Ҫ�ı���У����е���ֵ������һ����Ŀ����Ϣ
	public boolean updateProject(Long projectid, Long rowId, String newValue);
	
	// ɾ��һ����Ŀ
	public boolean removeProject(Long projectid);
	
	// ���������Ŀ��Ϣ
	public List<Project> getAllProjects();
	
}
