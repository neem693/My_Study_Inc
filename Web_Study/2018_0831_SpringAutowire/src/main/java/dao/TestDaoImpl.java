package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*<bean id = "test_dao" class = "dao.TestDaoImpl"/>*/


@Repository("test_dao")
public class TestDaoImpl implements TestDao {

	@Autowired
	SqlSession session;
	
	public TestDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("--TestDaoImpl()--");
	}
	
	@Override
	public List selectList() {
		// TODO Auto-generated method stub
		
		List list = session.selectList("dept.dept_list");
		
		return list;
	}
	
	
	

}
