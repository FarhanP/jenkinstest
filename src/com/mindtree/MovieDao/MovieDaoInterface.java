package com.mindtree.MovieDao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mindtree.entity.Movie;
import com.mindtree.entity.Theatre;

interface MovieDaoInterface 
{
	public void insertMovieData(Movie movie) throws ClassNotFoundException, SQLException;
	public ArrayList<Theatre> getTheatreData() throws ClassNotFoundException, SQLException;
	public ArrayList<Theatre> getallTheatre(String tname, ArrayList<Theatre> al) throws ClassNotFoundException, SQLException;
	public ArrayList<Movie> getallMovies() throws ClassNotFoundException, SQLException;
}
