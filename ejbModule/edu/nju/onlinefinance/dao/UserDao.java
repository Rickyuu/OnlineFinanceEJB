package edu.nju.onlinefinance.dao;

import java.util.List;

import javax.ejb.Remote;

import edu.nju.onlinefinance.model.User;

@Remote
public interface UserDao {
	
	// �����û�����Ŀ��ţ�����û�
	public User getUserById(Long userid);
	
	// ���һ�����û�
	public boolean addUser(User user);
	
	// ����Ҫ�ı���У����е���ֵ������һ���û�����Ϣ
	public boolean updateUser(Long userid, Long rowId, String newValue);
	
	// ɾ��һ���û�
	public boolean removeUser(Long userid);
	
	// ��������û���Ϣ
	public List<User> getAllUsers();
	
}
