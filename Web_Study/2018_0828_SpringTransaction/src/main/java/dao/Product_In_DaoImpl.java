package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import vo.ProductVo;

public class Product_In_DaoImpl implements ProductDao {

	SqlSession session;

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<ProductVo> list() {
		// TODO Auto-generated method stub

		List<ProductVo> list = session.selectList("product_in.product_in_list");

		return list;
	}

	@Override
	public int insert(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.insert("product_in.product_in_insert", vo);

		return res;
	}

	@Override
	public int update(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductVo selectOne(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
int res =0;
		
		res = session.delete("product_in.product_in_delete",idx);
		
		return res;
	}

}
