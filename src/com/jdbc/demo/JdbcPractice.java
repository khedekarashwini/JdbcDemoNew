package com.jdbc.demo;
import java.sql.*;


public class JdbcPractice {
	
	private static String Db_driver="com.mysql.jdbc.Driver";
	private static String DB_URL= "jdbc:mysql://localhost/stud";
	private static String User_name="root";
	private static String Pass="root";
	
	

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName(Db_driver);
			
			 con=DriverManager.getConnection(DB_URL, User_name, Pass);
			
		     stmt=con.createStatement();
			
			String query="select * from Student";
			
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String address=rs.getString(3);
				int marks=rs.getInt(4);
				
				System.out.println("Records are...."+id+" , "+name+" , "+address+" , "+marks);
				
			}
			
			String insert="Insert into Student(ID,Name,ADDRESS,MARKS)" + "values(15,'Rupali','Kolhapur',100)";
			stmt.execute(insert);
			System.out.println("Record inserted successfully");
			
			
			String update="update student set marks=150 where id=2";
			stmt.execute(update);
			System.out.println("Record updated successfully");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			  stmt.close();
			if(con!=null) 
				con.close();
		}
		 
	}

}
