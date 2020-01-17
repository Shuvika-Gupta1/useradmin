package com.mvc.controller;
import com.mvc.bean.RegisterBean;
//import com.mvc.util.DBConnection;
import java.util.ArrayList;
public class GetResult {
	public ArrayList<RegisterBean> getResult(RegisterBean bean)
	{
		ArrayList<RegisterBean> set=new ArrayList<RegisterBean>();
		RegisterBean reg= new RegisterBean();
		reg.setadmin(bean.getadmin().toString());
		reg.setEmail(bean.getEmail().toString());
		reg.setFullName(bean.getFullName().toString());
		reg.setPassword(bean.getPassword().toString());
		reg.setUserName(bean.getUserName().toString());
		
		set.add(reg);
		return set;
	}
}
