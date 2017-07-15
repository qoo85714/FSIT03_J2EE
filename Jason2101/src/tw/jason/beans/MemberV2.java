package tw.jason.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/*
 * JavaBean rules
 * 1. implements Serializable
 * 2.public class
 * 3. field member can not be a public
 * 4. getter & setter
 * 5. none argument Constructor (default Constructor)
 */
//public class Member implements Serializable{
public class MemberV2 {	
	private String id,account, passwd, realname;
	private Connection conn;
	private PreparedStatement pstmt;
	
	public MemberV2() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/brad", "root", "root");
	}
	public void setAccount(String account) {this.account=account;}
	public void setPasswd(String passwd) {this.passwd=passwd;}
	public void setRealname(String realname) {this.realname=realname;}
	public String getAccount() {return account;}
	public String getPasswd() {return passwd;}
	public String getRealname() {return realname;}

	public boolean newInsert() throws Exception {
		pstmt = conn.prepareStatement(
			"INSERT INTO member (account,passwd,realname) VALUES (?,?,?)");
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		pstmt.setString(3, realname);
		int n = pstmt.executeUpdate();
		return n > 0;
	}
	
	public boolean isValidMember() throws Exception{
		String sql = "SELECT * FROM member WHERE account=? AND passwd=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		ResultSet rs = pstmt.executeQuery();
		boolean ret = rs.next();
		if(ret) {
			id = rs.getString("id");
			realname = rs.getString("realname");
		}
		return ret;
	}
	
}
