package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;


import vo.PhotoVo;

public class PhotoDao {
	
	SqlSessionTemplate session;

	public SqlSessionTemplate getSession() {
		return session;
	}

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

	public List<PhotoVo> selectList() {
		// TODO Auto-generated method stub
		
		List<PhotoVo> list = session.selectList("photo.photo_select");
		
		return list;
	}

	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		
		int res =session.insert("photo.insert_vo",vo);
		
		return res;
		
	}

	public PhotoVo selectOne(PhotoVo vo) {
		// TODO Auto-generated method stub
		
		PhotoVo voo = session.selectOne("photo.photo_select_one",vo);
		
		return voo;
	}

	public int delete(PhotoVo vo) {
		// TODO Auto-generated method stub
		
		int res = session.delete("photo.photo_delete",vo);
		
		return res;
	}

	public boolean check2(PhotoVo voo) {
		// TODO Auto-generated method stub
		boolean check = true;
		
		String filename = session.selectOne("photo.check_filename",voo);
		
		if (filename.equals(null)) {
			check = false;
		}
		
		return check;
		
		
		
	
	}

	public int update(PhotoVo voo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = session.update("photo.photo_update",voo);
		
		return res;
	}
	


	
	/*
	 * 
	 */
	
	
	

}
