package service;

import dao.Test2Dao;
import dao.TestDao;

public class TestServiceImpl implements TestService {

	TestDao dao1;
	Test2Dao dao2;

	public TestDao getDao1() {
		return dao1;
	}

	public void setDao1(TestDao dao1) {
		this.dao1 = dao1;
	}

	public Test2Dao getDao2() {
		return dao2;
	}

	public void setDao2(Test2Dao dao2) {
		this.dao2 = dao2;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
//		long start = System.currentTimeMillis();
		System.out.println("--메소드 내부: Test Service test()호출--");
//
		try {
			Thread.sleep(1234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		long end = System.currentTimeMillis();
//
//		System.out.println("수행시간 " + (end - start) + "밀리세컨드");

	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
	//	long start = System.currentTimeMillis();
		System.out.println("--메소드 내부 : TestService Test2()호출--");

		try {
			Thread.sleep(1234);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//
//		long end = System.currentTimeMillis();
//
//		System.out.println("수행시간 " + (end - start) + "밀리세컨드");

	}

}
