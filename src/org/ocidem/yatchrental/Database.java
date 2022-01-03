package org.ocidem.yatchrental;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;
public class Database {
	public String databaseName;
	public String driver = "org.sqlite.JDBC";
	public String connURL;

	public Database(String dbName){
		databaseName = dbName;
		connURL = String.format("jdbc:sqlite:%s.sqlite", databaseName);
		try {
			Class.forName(driver);
		}
		catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println(String.format("Database '%s' initialized.", databaseName));
		
		createTable("Yatchs", new String[]{
			"id INTEGER PRIMARY KEY AUTOINCREMENT",
			"model VARCHAR(255) NOT NULL",
			"color VARCHAR(7) NOT NULL",
			"price FLOAT NOT NULL",
			"office INTEGER NOT NULL",
			"isRent INTEGER DEFAULT 0"
		});

		createTable("Rentals", new String[] {
			"id INTEGER PRIMARY KEY AUTOINCREMENT",
			"name VARCHAR(255) NOT NULL",
			"surname VARCHAR(255) NOT NULL",
			"phoneNumber VARCHAR(255) NOT NULL",
			"yatch INTEGER NOT NULL",
			"startDate BIGINT NOT NULL",
			"endDate BIGINT NOT NULL"
		});
	}
	
	public Rental getRental(String col, String val) {
		String sql = String.format("SELECT * FROM Rentals WHERE %s=%s;", col, val);
		Connection conn = null;
		Rental rental = null;
		try {
			conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				rental =  new Rental(
					res.getInt(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
					res.getInt(5),
					res.getLong(6),
					res.getLong(7)
				);
			}else
				System.out.println(String.format("Couldn't find rental with %s: %s", col, val));
			stmt.close();
			res.close();
			conn.close();
		}catch(Exception e) {Utils.Error(e);}
		return rental;
	}
	
	public Yatch getYatch(String col, String val) {
		String sql = String.format("SELECT * FROM Yatchs WHERE %s=%s;", col, val);
		Connection conn = null;
		Yatch yatch = null;
		try {
			conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				yatch =  new Yatch(
					res.getInt(1),
					res.getString(2),
					res.getString(3),
					res.getFloat(4),
					res.getInt(5),
					res.getBoolean(6)
				);
			}else 
				System.out.println(String.format("Couldn't find yatch with %s: %s", col, val));
			
			stmt.close();
			res.close();
			conn.close();
		}catch(Exception e) {Utils.Error(e);}
		
		return yatch;
	}
	
	public void removeYatch(String col, String val) {
		Connection conn = null;
		try {
			String sql = String.format("DELETE FROM Yatchs WHERE %s=%s;", col, val);
			conn = DriverManager.getConnection(connURL);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(Exception e) {Utils.Error(e);}
	}

	public void createTable(String name, String[] columns) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connURL);
			ResultSet res = conn.getMetaData().getTables(null, null, name, null);
			if(!res.next()) {
				String sql = "CREATE TABLE "+name+"(";
				for(int i=0; i<columns.length-1; i++) {
					sql += columns[i]+", ";
				}
				sql += columns[columns.length-1]+")";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				res.close();
				conn.close();
				System.out.println("Table '"+name+"' Created");
			}else {
				res.close();
				conn.close();
			}
		}catch(Exception e) {Utils.Error(e);}
	}
	
	public void addEntry(String tableName, Map<String, String> values) {//Get a dictionary as argument for predefined values like RentalOffice id etc.
		Connection conn = null;
		String keys = "(";
		String vals = "(";
		Iterator<Map.Entry<String, String>> iterator = values.entrySet().iterator();
	    while (true) {
	        Map.Entry<String, String> entry = iterator.next();
	        if(iterator.hasNext()) {
	        	keys+=entry.getKey()+", ";
	        	vals+="'"+entry.getValue()+"', ";
	        }else {
	        	keys+=entry.getKey()+")";
	        	vals+="'"+entry.getValue()+"')";
	        	break;
	        }
	    }
		String sql = String.format("INSERT INTO %s %s VALUES %s;", tableName, keys, vals);
		try {
			conn = connect();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(Exception e) {Utils.Error(e);}
	}
	
	private Connection connect() throws SQLException {
		return DriverManager.getConnection(connURL);
	}
}

