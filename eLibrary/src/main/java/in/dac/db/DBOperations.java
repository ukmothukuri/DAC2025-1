package in.dac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.dac.dao.BookDetails;
import in.dac.dao.UserDetails;

public class DBOperations {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/elibrary";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";
	Connection conn;
	
	public static void main(String a[]) {
		DBOperations d = new DBOperations();
		d.intializeDBConnection();
		UserDetails u = new UserDetails();
		u.setUseremail("abc@cdac.in");
		
		d.registerUser(u);
	}
	
	public void intializeDBConnection(){	
		try{
			Class.forName(DB_DRIVER); 
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			if(conn != null){
			   System.out.println("Successfully connected.");
			}else{
			   System.out.println("Failed to connect.");
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public boolean registerUser(UserDetails user) 
	{
		int rowsinserted = 0;
		String query = "insert into userdetails values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getUseremail());
			ps.setString(3, user.getUsermobile());
			ps.setString(4, user.getUserpassword());

			rowsinserted = ps.executeUpdate();

		} catch (SQLException sq) {
			sq.printStackTrace();
		}
		return (rowsinserted == 1) ? true : false;	
	}
	
	
	public boolean checkUserLoginDetails(UserDetails user) {
		boolean status = false;
		String query = "select useremail, userpassword from userdetails "
				+ "where useremail=? and userpassword=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getUseremail());
			ps.setString(2, user.getUserpassword());
			ResultSet rs =  ps.executeQuery();
			if(rs.next()) {
				status = true;
			}
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		return status;		
	}
	
	public UserDetails getUserProfile(String email) {
		UserDetails user = null;
		String query = "select username, useremail,usermobile from userdetails "
				+ "where useremail=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs =  ps.executeQuery();
			if(rs.next()) {
				user = new UserDetails(); 
				user.setUsername(rs.getString("username"));
				user.setUseremail(rs.getString("useremail"));
				user.setUsermobile(rs.getString("usermobile"));
			}
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		return user;
	}
	
	public List<BookDetails> getAllBookDetails() {
				
		List<BookDetails> list_books = new ArrayList<BookDetails>();
		String query = "select * from bookdetails";
		try {
			PreparedStatement ps = conn.prepareStatement(query);			
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				BookDetails book = new BookDetails();
				book.setBookid(rs.getInt("bookid"));
				book.setBookname(rs.getString("bookname"));
				book.setPublishedYear(rs.getInt("publishedYear"));
				book.setPrice(rs.getInt("price"));
				book.setAuthor(rs.getString("author"));
				
				list_books.add(book);				
			}
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		return list_books;
	}
}

