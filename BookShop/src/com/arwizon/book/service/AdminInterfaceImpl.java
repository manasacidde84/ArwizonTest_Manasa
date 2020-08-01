package com.arwizon.book.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.arwizon.book.model.Book;
import com.arwizon.book.utility.ConnectionDB;


public class AdminInterfaceImpl implements AdminInterface {

	Connection con =ConnectionDB.connectDB();
	@Override
	public void addBook(String bookName, String bookType, String author, int noOfCopies, double cost) {
		int i =0;
		String sql="insert into Book values(?,?,?,?,?,?)";
		String sql1="select max(bookId)  from Book";
		PreparedStatement stmt1=null;
		ResultSet rs=null;
		PreparedStatement stmt = null;

		try {
			stmt1 = con.prepareStatement(sql1);
			rs = stmt1.executeQuery();
			while(rs.next()) {
				i = rs.getInt(1);
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,i+2);
			stmt.setString(2,bookName);
			stmt.setString(3,bookType);
			stmt.setString(4,author);
			stmt.setInt(5,noOfCopies);
			stmt.setDouble(6,cost);

			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(stmt1!=null)
					stmt1.close();
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}
	@Override
	public Set<Book> DisplayAllBooks() {
		Set<Book> s = new HashSet<Book>();
		String sql="select * from Book ";
		PreparedStatement stmt =null;
		ResultSet rs  =null;
		try {
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookType(rs.getString(3));
				b.setAuthor(rs.getString(4));
				b.setNoOfCopies(rs.getInt(5));
				b.setCost(rs.getDouble(6));

				s.add(b);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}


		return s;

	}
	@Override
	public Set<Book> searchBook(String bookName) {
		Set<Book> s = new HashSet<Book>();
		String sql="select * from Book where bookName=?";
		PreparedStatement stmt =null;
		ResultSet rs  =null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,bookName);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setBookType(rs.getString(3));
				b.setAuthor(rs.getString(4));
				b.setNoOfCopies(rs.getInt(5));
				b.setCost(rs.getDouble(6));

				s.add(b);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}


		return s;


	}
	@Override
	public void updateBook(int bookId, int noOfCopies) {
		String sql = "update Book  set noOfCopies=? where bookId=?";
		PreparedStatement stmt=null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(2, bookId);
			stmt.setInt(1,noOfCopies);
			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)
					stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}


