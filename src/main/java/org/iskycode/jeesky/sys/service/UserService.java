package org.iskycode.jeesky.sys.service;

import org.iskycode.jeesky.sys.dao.PermissionDao;
import org.iskycode.jeesky.sys.dao.RoleDao;
import org.iskycode.jeesky.sys.dao.UserDao;
import org.iskycode.jeesky.sys.entity.Permission;
import org.iskycode.jeesky.sys.entity.Role;
import org.iskycode.jeesky.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
