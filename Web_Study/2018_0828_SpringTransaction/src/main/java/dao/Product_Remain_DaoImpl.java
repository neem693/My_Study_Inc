package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import vo.ProductVo;

public class Product_Remain_DaoImpl implements ProductDao {

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
		
		List<ProductVo> list = null;
		
		list = session.selectList("product_remain.product_remain_list");
		
		return list;
	}

	@Override
	public int insert(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		
		int res =session.insert("product_remain.product_remain_insert",vo);
		
		return res;
	}

	@Override
	public int update(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		int res =0;
		res = session.update("product_remain.product_remain_update",vo);
		return res;
	}

	@Override
	public ProductVo selectOne(String name) {
		// TODO Auto-generated method stub
		ProductVo vo = null;
		
		vo = session.selectOne("product_remain.product_remain_one",name);
		
		
		return vo;
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		
		int res =0;
		
		res = session.delete("product_remain.product_remain_delete",idx);
		
		return res;
	}

}
