import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Connection mycomm = DriverManager.getConnection("jdbc:mysql://localhost:3306/anuj","root","123456");
			Statement myStart = mycomm.createStatement();
			ResultSet myRs = myStart.executeQuery("");
			while(myRs.next()) {
				System.out.println(myRs.getString("name") + ", " + myRs.getString("occupation"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
