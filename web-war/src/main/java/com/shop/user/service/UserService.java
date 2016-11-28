package com.shop.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rensframework.core.entity.user.User;
import com.rensframework.core.service.BaseService;
import com.shop.user.dao.UserDao;

@Service
@Transactional(readOnly=true)
public class UserService extends BaseService<User> {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	protected PagingAndSortingRepository<User, Long> getDao() {
		return userDao;
	}

}
