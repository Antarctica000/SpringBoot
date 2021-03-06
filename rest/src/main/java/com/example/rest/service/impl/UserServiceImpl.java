package com.example.rest.service.impl;


import com.example.rest.dao.UserDao;
import com.example.rest.pojo.User;
import com.example.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao = null;
	
	@Override
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> findUsers(String userName, String note, int start, int limit) {
		return userDao.findUsers(userName, note, start, limit);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int updateUserName(Long id, String userName) {
		return userDao.updateUserName(id, userName);
	}

	@Override
	public int deleteUser(Long id) {
		return userDao.deleteUser(id);
	}

	@Override
	public User insertUser(User user) {
		return userDao.insertUser(user) >0 ? user  : null;
	}
	
}
