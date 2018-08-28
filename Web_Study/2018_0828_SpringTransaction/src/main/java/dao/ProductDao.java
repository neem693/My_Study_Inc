package dao;

import java.util.List;

import vo.ProductVo;

public interface ProductDao {

	List<ProductVo> list();
	int insert(ProductVo vo) throws Exception;
	int update(ProductVo vo) throws Exception;
	ProductVo selectOne(String name);
	int delete(int idx);
	

}
