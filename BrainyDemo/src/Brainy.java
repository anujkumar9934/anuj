import java.sql.*;
import java.io.*;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class Brainy
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anuj","root","123456");
		Statement stmt = con.createStatement();
		
		JSONObject j = new JSONObject();
		JSONArray column_contraint = new JSONArray();
		
		
		Scanner sc = new Scanner(System.in);
		String tabilName;
		
		System.out.println("enter tabil name");
		tabilName=sc.next();

		j.put("table name", tabilName);
		
		String sql= "SELECT * FROM "+ tabilName;
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int c = rsmd.getColumnCount();
		for(int i=1;i<=c;i++){
			
			column_contraint.add(rsmd.getColumnTypeName(i));
			
			//System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));
		}
		
		j.put("column constraint", column_contraint);
		
		String filename = "Brainy_Constraint1.json";
		
		
		try(FileWriter file = new FileWriter(filename))
		{
			file.write(j.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
		System.out.println("done");
	}
}