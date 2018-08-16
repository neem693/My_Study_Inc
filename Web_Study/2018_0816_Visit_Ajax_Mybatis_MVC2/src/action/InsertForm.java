package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.interface_.Action;

public class InsertForm implements Action {


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String forward_page = "visit_insert_form.jsp";
		
		return forward_page;
	}


}
