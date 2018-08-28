package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Product_In_DaoImpl;
import dao.Product_Out_DaoImpl;
import dao.Product_Remain_DaoImpl;
import vo.ProductVo;

public class ProductServiceImpl implements ProductService {

	Product_In_DaoImpl InDao;
	Product_Out_DaoImpl outDao;
	Product_Remain_DaoImpl remainDao;

	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ProductServiceImpl(Product_In_DaoImpl inDao, Product_Out_DaoImpl outDao, Product_Remain_DaoImpl remainDao) {
		super();
		InDao = inDao;
		this.outDao = outDao;
		this.remainDao = remainDao;
	}

	@Override
	public Map selectList() {
		// TODO Auto-generated method stub

		List in_list = InDao.list();
		List out_list = outDao.list();
		List remain_list = remainDao.list();
		Map map = new HashMap();

		map.put("in_list", in_list);
		map.put("out_list", out_list);
		map.put("remain_list", remain_list);

		return map;
	}

	@Override
	public void insert_in(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		
		int res = InDao.insert(vo);
		
		ProductVo remain_vo = remainDao.selectOne(vo.getName());
		
		if(remain_vo == null) {
			//재고테이블에 상품이 등록되지 않았다면 
			//입고테이블 등록 상품을 재고테이블에도 등록
			res = remainDao.insert(vo);
			
		}else {
			int cnt = remain_vo.getCnt();
			cnt += vo.getCnt();
			System.out.println(cnt);
			remain_vo.setCnt(cnt);
			res = remainDao.update(remain_vo);
		}

	}

	@Override
	public void insert_out(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		
		int res = outDao.insert(vo);
		
		ProductVo remain_vo = remainDao.selectOne(vo.getName());
		
		if(remain_vo == null) {
			//재고테이블에 상품이 등록되지 않았다면 
			//예외 강제로 발생시킨다
			throw new Exception("remain_not");
			
		}else if(remain_vo.getCnt()<vo.getCnt()) {
			
			
			throw new Exception("remain_lack");
		}else {
			int cnt = remain_vo.getCnt();
			cnt -= vo.getCnt();
			System.out.println(cnt);
			remain_vo.setCnt(cnt);
			res = remainDao.update(remain_vo);
			if(res!=0) {
				remain_vo =  remainDao.selectOne(remain_vo.getName());
				if(remain_vo.getCnt()==0) {
					res = remainDao.delete(remain_vo.getIdx());
				}
			}
			
		}
	}

}
