package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.dao.LoginDao;
import com.wipro.daoImpl.LoginDaoImpl;
import com.wipro.form.CommonForm;

public class LoginService {

    LoginDao loginDao=new LoginDaoImpl();
	
	public  CommonForm customervalidation(CommonForm commonform)
	{
		System.out.println("Inside customervalidation>>>>");
		return loginDao.validateExistCustomer(commonform);
	}
	
	public int fetchBalance(CommonForm commonform)
	{
		System.out.println("Inside fetchBalance>>>>>");
		return loginDao.fetchCustomerBalance(commonform);
	}
	
	

}
