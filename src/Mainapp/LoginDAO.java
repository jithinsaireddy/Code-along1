package Mainapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public boolean validate(LoginPojo pojo1) throws ClassNotFoundException, SQLException
	{
		String name = pojo1.getUsername();
		String pass = pojo1.getPassword();
		
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * from USERDETAILS");
		con.getConnection().close();
		while(rs.next())
		{
			String tempname = rs.getString("USERNAME");
			String tempPass = rs.getString("PASSWORD");
			if(tempname.equals(name) && tempPass.equals(pass))
				return true;
		}
		return false;
	}
}