package com.mindtree.MovieDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtree.entity.Movie;
import com.mindtree.entity.Theatre;
import com.mindtree.utility.DbUtil;

public class MovieDaoImplementation implements MovieDaoInterface
{
	DbUtil dbutil= new DbUtil();

	public void insertMovieData(Movie movie) throws ClassNotFoundException, SQLException 
	{
		Connection con= new DbUtil().getConnection();
		Statement st=null;
		System.out.println("Connection Established...");
		st=con.createStatement();
		st.executeUpdate("insert into movie values("+movie.getMid()+",'"+movie.getMname()+"',"+movie.getBudget()+","+movie.getTid()+");");
		con.close();
	}

	public ArrayList<Theatre> getTheatreData() throws ClassNotFoundException, SQLException 
	{	ArrayList<Theatre> al=new ArrayList<>();
		Connection con= new DbUtil().getConnection();
		ResultSet rs=null;
		String query="Select * from theatre;";
		rs=con.createStatement().executeQuery(query);
		while(rs.next())
		{
			Theatre tr=new Theatre(rs.getInt(1),rs.getString(2),rs.getString(3));
			al.add(tr);
		}
		con.close();
		return al;
		
	}

	public ArrayList<Theatre> getallTheatre(String tname, ArrayList<Theatre> al) throws ClassNotFoundException, SQLException 
	{
		ArrayList<Theatre> alltheatre=new ArrayList<>();
		Connection con= new DbUtil().getConnection();
		ResultSet rs=null;
		String query="select tid,tname,taddress from theatre where tname like '"+tname+"%';";
		rs=con.createStatement().executeQuery(query);
		while(rs.next()) 
		{
			Theatre tr=new Theatre(rs.getInt(1),rs.getString(2),rs.getString(3));
			alltheatre.add(tr);
		}
		con.close();
		return alltheatre;
	}

	public ArrayList<Movie> getallMovies() throws ClassNotFoundException, SQLException 
	{
		ArrayList<Movie> allMovie=new ArrayList<>();
		Connection con= new DbUtil().getConnection();
		ResultSet rs=null;
		String query="select movie.mid,movie.mname,theatre.tname from movie join theatre on movie.tid=theatre.tid;";
		rs=con.createStatement().executeQuery(query);
		while(rs.next())
		{
			Movie mv =new Movie(rs.getInt(1),rs.getString(2),rs.getString(3));
			allMovie.add(mv);
		}
		con.close();
		return allMovie;
	}

	public  ArrayList<Movie> getMovieById(int movieId) throws ClassNotFoundException, SQLException {
		ArrayList<Movie> allMovie=new ArrayList<>();
		Connection con= new DbUtil().getConnection();
		ResultSet rs=null;
		String query="select movie.mid,movie.mname,theatre.tname from movie join theatre on movie.tid=theatre.tid where mid="+movieId+";";
		rs=con.createStatement().executeQuery(query);
		while(rs.next())
		{
			Movie mv=new Movie(rs.getInt(1),rs.getString(2),rs.getString(3));
			allMovie.add(mv);
		}
		con.close();
		return allMovie;
	}

	public 	String deleteMovid(int movid) throws ClassNotFoundException, SQLException {
		Connection con= new DbUtil().getConnection();
		String query="delete from movie where mid="+movid;
		con.createStatement().executeUpdate(query);
		String result="The specified movie id is deleted";
		con.close();
		return result;
		
	}

	
	
}
