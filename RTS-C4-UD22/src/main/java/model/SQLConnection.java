package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SQLConnection {
	
	/** Attribute */
	public Connection connection;
	
	public String db = null;
	

	/** Constructor */
	public SQLConnection () {
		makeConection();
	}
	
	
	/**
	 * @return the db
	 */
	public String getDb() {
		return db;
	}


	/**
	 * @param db the db to set
	 */
	public void setDb(String db) {
		this.db = db;
	}


	/**
	* Method where the user enters the data of his server / sql and the connection is established
	*/
	public void makeConection() {
	    String ip = JOptionPane.showInputDialog(null,"Introduce los datos de la conexión sql\nIp:"); 

	    String user = JOptionPane.showInputDialog(null,"Usuario: ");

	    String pass = JOptionPane.showInputDialog(null,"Contraseña: ");
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://"+ip+":3306?useTimezone=true&serverTimezone=UTC",user,pass);
			JOptionPane.showMessageDialog(null,"Conectado al Sevidor");				
		}catch (SQLException | ClassNotFoundException ex ) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
		}
	}
	
	/**
	* Method that close the connection
	*/
	public void closeConnection() {
		
		try {
			connection.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	/**
	* Method that create a db
	* @param name name of the new db 
	*/	
	public void createDB(String name) {
				
		try {
			String Query = "CREATE DATABASE "+name;
			Statement st = connection.createStatement();
			st.executeUpdate(Query);
			db = name;
			JOptionPane.showMessageDialog(null,"Se ha creado la base de datos "+name+ " de forma exitosa");					
		}catch (SQLException ex) {
			
		}
	}
	
	
	/**
	* Method that get the all the data from a table
	* @param SQLquery select query
	* @return the data returned by the statement
	*/	
	public ResultSet getValues (String SQLquery) {
		java.sql.ResultSet resultSet = null;
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(Querydb);
			
			Statement st = connection.createStatement();
			 resultSet = st.executeQuery(SQLquery);
				
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
		}
		
		return resultSet;
	}


	/**
	* Method that executes queries to a db
	* @param SQLquery sql statement to be executed into the db
	*/	
	public void insertData (String SQLquery) {
		
		try {
			String Querydb = "USE "+db+";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(Querydb);
			
			Statement st = connection.createStatement();
			st.executeUpdate(SQLquery);
			System.out.println("\nSentencia ejecutada exitosamente");			
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
		}
	}
}