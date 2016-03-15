package net.spring.service;

import java.util.List;

import net.spring.dao.HelloWorldDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

	@Autowired
	private HelloWorldDao helloWorldDao;
	
	public List<Object[]> findCfConsumeIns() {
		return helloWorldDao.findList();
	}
}
