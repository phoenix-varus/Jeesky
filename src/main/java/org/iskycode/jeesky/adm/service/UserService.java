package org.iskycode.jeesky.adm.service;

import org.iskycode.jeesky.adm.dao.PermissionDao;
import org.iskycode.jeesky.adm.dao.RoleDao;
import org.iskycode.jeesky.adm.dao.UserDao;
import org.iskycode.jeesky.adm.entity.Permission;
import org.iskycode.jeesky.adm.entity.Role;
import org.iskycode.jeesky.adm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author phoenix
 *
 *         用户业务处理层
 */
@Transactional(readOnly = false)
@Service
public class UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	PermissionDao permissionDao;

	public User findUserByName(String name) {
		User user = new User();
		user.setName(name);
		List<User> userList = userDao.findByExample(user);
		if (!CollectionUtils.isEmpty(userList)) {
			return (User) userDao.findByExample(user).get(0);
		}
		return null;
	}

	public List<Role> findRolesByName(String name) {
		Role role = new Role();
		role.setName(name);
		return roleDao.findByExample(role);
	}

	public List<Permission> findPermissionsByName(String name) {
		Permission permission = new Permission();
		permission.setName(name);
		return permissionDao.findByExample(permission);
	}

	public List<User> findAllUser() {
		return userDao.loadAll();
	}

	public void saveOrUpdate(User user) {
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		userDao.saveOrUpdate(user);
	}

	public void save(User user) {
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		userDao.save(user);
	}
}
