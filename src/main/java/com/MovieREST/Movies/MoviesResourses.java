package com.MovieREST.Movies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.MovieREST.DatabaseConnection.MySQLCon;


@Path("/movies")
public class MoviesResourses {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Movie> getMovies() {
		
		
		List<Movie> movies= new ArrayList<Movie>();
//		System.out.println("configuring vedant property");
//		System.out.println(System.getProperty("project.root"));
		
		MySQLCon connection = new MySQLCon();
		Connection con =connection.getMYSQLConnection();
		
		try(Statement s =con.createStatement()){
			try (ResultSet rs = s.executeQuery("select * from movies limit 10")){
				while(rs.next()) {
					int id = rs.getInt(1);
					String mName = rs.getString(2);
					int year = rs.getInt(3);
					float rankScore = rs.getFloat(4);
					Movie movie = new Movie();
					movie.setId(id);
					movie.setMovie_name(mName);
					movie.setYear(year);
					movie.setRankScore(rankScore);
					
					System.out.println("only movie :- "+movie);
					movies.add(movie);
//					System.out.println("movies :- "+movies);
					
				}
				
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Exception in result set");
				e.printStackTrace();
			}
			
			
		}catch(SQLException e) {
			System.out.println("Exception in connestion");
			e.printStackTrace();
			
		}
		
		System.out.println("movies :- "+movies);
		
		return movies;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("movie/{id}")
	public Movie getMovie(@PathParam("id") int id) {
		
		MySQLCon connection = new MySQLCon();
		Connection con =connection.getMYSQLConnection();
		
		String s = "select * from movies where id=?";
		Movie m = new Movie();
		
		try(PreparedStatement p_statement = con.prepareStatement(s)){
			p_statement.setInt(1, id);
			
			try(ResultSet rs = p_statement.executeQuery()){
				
				while(rs.next()) {
					
					m.setId(rs.getInt(1));
					m.setMovie_name(rs.getString(2));
					m.setYear(rs.getInt(3));
					m.setRankScore(rs.getFloat(4));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	
		 
		return m;
	}
	
	
	@Path("/moviesAndGenres")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMoviesAndGeneres() {
		
		JSONArray moviesGenres = new JSONArray();
		
		MySQLCon mysql = new MySQLCon();
		Connection con=mysql.getMYSQLConnection();
		
		String sql = "select * from movies inner join movies_genres as g on id=g.movie_id limit 30";
		try(Statement statement = con.createStatement()){
			
			try(ResultSet rs = statement.executeQuery(sql)){
				
				while(rs.next()) {
					
					JSONObject json_obj = new JSONObject();
					json_obj.put("movie_name", rs.getString(2));
					json_obj.put("year", rs.getInt(3));
					json_obj.put("genre", rs.getString(6));
					
					moviesGenres.put(json_obj);
					
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return moviesGenres.toString();

	}
	

	
	
	@POST
	@Path("/movie")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie createMovie(Movie m) {
		System.out.println(m.toString());
		
		return m;
		
	}

}
