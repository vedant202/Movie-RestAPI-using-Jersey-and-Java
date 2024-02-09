package com.MovieREST.Movies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.MovieREST.DatabaseConnection.MySQLCon;

@Path("/actors")
public class MovieActors {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actor> getAllActors() {
		List<Actor> actors = new ArrayList<Actor>();
		
		MySQLCon mysql = new MySQLCon();
		Connection con=mysql.getMYSQLConnection();
		
		String sql = "select * from actors limit 20";
		try(Statement statement = con.createStatement()){
			try(ResultSet rs = statement.executeQuery(sql)){
				
				while(rs.next()) {
					Actor actor = new Actor();
					actor.setActor_id(rs.getInt(1));
					actor.setFirstname(rs.getString(2));
					actor.setLastName(rs.getString(3));
					actor.setGender(rs.getString(4));
					
					actors.add(actor);
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
		
		return actors;
		
	}
	
	public void getActorAndMovies() {
		
	}
	
	
	
	@POST
	@Path("/actor/{actor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Actor getActorByID(@PathParam("actor_id") int id) {
		
		Actor actor = new Actor();
		
		MySQLCon mysql = new MySQLCon();
		Connection con=mysql.getMYSQLConnection();
		
		String sql = "select * from actors where id=?";
		try(PreparedStatement statement = con.prepareStatement(sql)){
			statement.setInt(1, id);
			try(ResultSet rs = statement.executeQuery()){
				
				while(rs.next()) {
					
					actor.setActor_id(rs.getInt(1));
					actor.setFirstname(rs.getString(2));
					actor.setLastName(rs.getString(3));
					actor.setGender(rs.getString(4));
					
					
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
		
		
		return actor;
		
	}
}
