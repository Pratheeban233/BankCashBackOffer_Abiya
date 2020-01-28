package com.wipro.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wipro.form.CommonForm;


@Service
public interface LoginDao {
		
	public  CommonForm validateExistCustomer(CommonForm commonform) ;
	public int fetchCustomerBalance(CommonForm commonform);

}
