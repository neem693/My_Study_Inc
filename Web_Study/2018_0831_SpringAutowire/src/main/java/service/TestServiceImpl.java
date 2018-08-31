package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TestDao;

@Service("test_service")
public class TestServiceImpl implements TestService {
	
	@Autowired
	TestDao test_dao;
	
	public TestServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("--TestServiceImpl()--");
	}

	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		List list = test_dao.selectList();
		
		
		return list;
	}
	
	

}
