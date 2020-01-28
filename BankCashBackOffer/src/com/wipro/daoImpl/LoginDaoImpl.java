package com.wipro.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.dao.LoginDao;
import com.wipro.form.CommonForm;

public class LoginDaoImpl implements LoginDao {

	public CommonForm validateExistCustomer(CommonForm commonform)  {
		
		boolean flag=false;
		Connection con=null;
		PreparedStatement ps=null;
		System.out.println("validateExistCustomer>>>>>>");
		
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//String user = "SYSTEM";
		//String pass = "Prathi#123";
		String url = "jdbc:oracle:thin:@//10.44.52.140:1527/orpsgdb";
		String user = "cmsnsbfiid_sit";
		String pass = "cmsnsbfiid_sit";
		
			try {
				System.out.println("DB connecting...");
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, user, pass);
				System.out.println("DB connected..");
				
				String qry = "select balance from customer where customer_id=? and password=? ";
				ps=con.prepareStatement(qry);
				ps.setString(1, commonform.getCustomerid());
				ps.setString(2, commonform.getPassword());
				ResultSet rs = ps.executeQuery();
				System.out.println("customer validation executed.0..");

				if (rs.next()) {
					commonform.setFlag(true);
					commonform.setBalance(rs.getInt(1));
				}
				else
				{
					commonform.setFlag(false);;
				}
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			finally
			{
				try {
					con.close();
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return commonform;
	
	}

	@Override
	public int fetchCustomerBalance(CommonForm commonform) {
		
		int balance=0;
		Connection con=null;
		PreparedStatement ps1=null;
		
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//String user = "SYSTEM";
		//String pass = "Prathi#123";
		String url = "jdbc:oracle:thin:@//10.44.52.140:1527/orpsgdb";
		String user = "cmsnsbfiid_sit";
		String pass = "cmsnsbfiid_sit";

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection(url, user, pass);
			
			String query= "select balance from customer where customer_id=?";
			ps1=con.prepareStatement(query);
			ps1.setString(1, commonform.getCustomerid());
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				commonform.setBalance(rs.getInt(1));
				balance =rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				ps1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return balance;
	}

	
}



