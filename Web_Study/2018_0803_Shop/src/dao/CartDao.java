package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVo;

public class CartDao {
	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static CartDao single = null;
	SqlSessionFactory factory;

	public static CartDao getInstance() {
		if (single == null)
			single = new CartDao();
		return single;
	}

	public CartDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<CartVo> selectList(int m_idx) {
		List<CartVo> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("cart.cart_list", m_idx);
		session.close();

		return list;

	}

	public int selectAllAmount(int m_idx) {
		// TODO Auto-generated method stub
		int all_amount = 0;

		SqlSession session = factory.openSession();
		all_amount = session.selectOne("cart_amount_sum", m_idx);
		session.close();

		return all_amount;
	}

	public int update(CartVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.update("cart_update", vo);
		session.close();

		return res;
	}

	public int delete(int c_idx) {
		// TODO Auto-generated method stub
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.delete("cart_delete", c_idx);
		session.close();

		return res;
	}



	public CartVo selectOne(CartVo c_vo) {
		// TODO Auto-generated method stub
		CartVo vo = null;

		SqlSession session = factory.openSession(true);
		vo = session.selectOne("cart_select_one", c_vo);
		session.close();

		return vo;
	}

	public int insert(CartVo c_vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession session = factory.openSession(true);
		res = session.insert("cart_insert",c_vo);
		session.close();
		
		
		
		return res;
	}

}
