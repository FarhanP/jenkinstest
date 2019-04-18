package com.mindtree.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.MovieDao.MovieDaoImplementation;
import com.mindtree.entity.Movie;
import com.mindtree.entity.Theatre;
import com.mindtree.exception.InvalidMovieId;
import com.mindtree.exception.InvalidTheatre;
import com.mindtree.exception.InvalidTheatreIdException;

public class MovieMain 
{
	MovieDaoImplementation daoimpl=new MovieDaoImplementation();
	
	public void insertMovieData(Movie movie) throws ClassNotFoundException, SQLException 
	{
		daoimpl.insertMovieData(movie);
	}

	public ArrayList<Theatre> getTheatreData() throws ClassNotFoundException, SQLException 
	{
		
		ArrayList<Theatre> tl =daoimpl.getTheatreData();
		return tl;
	}

	public void validTheatre(int tid, ArrayList<Theatre> al) 
	{
		int flag=0;
		for(int i=0;i<al.size();i++)
		{
			if(al.get(i).getTid()==tid)
			{
				flag=1;
			}
		}
		if(flag==0)
		{
			throw new InvalidTheatreIdException("Please enter valid Theatre ID");
		}
		
	}

	public ArrayList<Theatre> getallTheatre(String tname, ArrayList<Theatre> al) throws ClassNotFoundException, SQLException 
	{
		int flag = 0;
		for(Theatre the: al)
		{
			if(the.getTname().equalsIgnoreCase(tname))
			{	
				flag = 0;
				return daoimpl.getallTheatre(tname,al);
			}else {
				flag = 1;
			}
		}
		if(flag == 1) {
			throw new InvalidTheatre("Theatre Not Found");
		}
		return null;
		
		
	
	
	}

	public ArrayList<Movie> getallMovies() throws ClassNotFoundException, SQLException {
		
		return daoimpl.getallMovies();
		
	}

	public ArrayList<Movie> getMovieById(ArrayList<Movie> allMovie1,int movieId) throws ClassNotFoundException, SQLException, InvalidMovieId
	{
		int flag = 0;
		for(Movie mve:allMovie1)
		{
			if(mve.getMid()==movieId)
			{
				flag = 0;
				return daoimpl.getMovieById(movieId);
			}
			else {
				flag=1;
			}
		}
		if(flag == 1)
		{
			throw new InvalidMovieId("Movie ID Not Found");
	
		}
		return null;

	}

	public String deleteMovie(int movid) throws ClassNotFoundException, SQLException {
		return daoimpl.deleteMovid(movid);
		
	}
	
	
	
}