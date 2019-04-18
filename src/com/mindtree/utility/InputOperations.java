package com.mindtree.utility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.entity.Movie;
import com.mindtree.entity.Theatre;
import com.mindtree.exception.InvalidMovieId;
import com.mindtree.service.MovieMain;

public class InputOperations 
{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InvalidMovieId 
	{
		Scanner input=new Scanner(System.in);
		MovieMain mv=new MovieMain();
		ArrayList<Theatre> al=mv.getTheatreData();
//		for(Theatre t:al)
//			System.out.println(t);
//		al.forEach(list->System.out.println(list));
		boolean status=true;
		while(status)
		{		System.out.println("=======================Movie Menu==============================");
				System.out.println("1. Insert a movie data with proper Theatre ID");
				System.out.println("2. To return a theatre value based on some character ");
				System.out.println("3. Display Movie details in a  proper format");
				System.out.println("4. Display a particular movie details");
				System.out.println("5. Delete a movie data");
				System.out.println("6. Exit");
				System.out.println("Enter an option to perform the above respective operations: ");
				int option=input.nextInt();
				
		switch(option)
			{
				case 1:
					
					System.out.println("Enter a movie ID:");
					int mid=input.nextInt();
					System.out.println("Enter a movie Name:");
					String mname=input.next();
					System.out.println("Enter a movie Budget:");
					int budget=input.nextInt();
					System.out.println("Enter a Theatre ID:");
					int tid=input.nextInt();
					mv.validTheatre(tid,al);
					Movie movie=new Movie(mid, mname, mid, tid);
					mv.insertMovieData(movie);
					break;
					
				case 2:
					System.out.println("Enter the theatre name of which you want its detail in: ");
					String tname=input.next();
					System.out.println(mv.getallTheatre(tname,al));
					break;
					
				case 3:
					ArrayList<Movie> allMovie=mv.getallMovies();
					allMovie.forEach(list->System.out.println(list));
					break;
					
				case 4:
					System.out.println("Enter a movie ID to find its details...");
					ArrayList<Movie> allMovie1=mv.getallMovies();
					ArrayList<Movie> allMoviebyId=mv.getMovieById(allMovie1, input.nextInt());
					allMoviebyId.forEach(list->System.out.println(list));
					break;
					
				case 5:
					System.out.println("Enter a movie ID to be deleted: ");
					int movid=input.nextInt();
					System.out.println(mv.deleteMovie(movid));
					break;
					
				case 6:
					status=false;
					System.out.println("***************Program exited************");
					
			}
		
		
		}
	}

}
