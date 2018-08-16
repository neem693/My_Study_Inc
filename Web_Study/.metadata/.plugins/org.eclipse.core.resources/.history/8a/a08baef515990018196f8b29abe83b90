package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;

public class ProductDao {
	
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static ProductDao single = null;
	SqlSessionFactory factory;

	public static ProductDao getInstance() {
		if (single == null)
			single = new ProductDao();
		return single;
	}

	public ProductDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//카테고리별 상품목록
	
	public List<ProductVo> selectList(String category){
		List<ProductVo> list = null;
		System.out.println();
		SqlSession session = factory.openSession();
		list = session.selectList("product.product_list",category);
		session.close();
		
		
		return list;
	}

	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		int res =0;
		
		SqlSession session = factory.openSession(true);
		res = session.insert("product.product_insert",vo);
		session.close();
		
		return res;
	}
	
	
	

}
