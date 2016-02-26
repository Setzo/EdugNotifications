package com.github.setzo.crawler.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.github.setzo.crawler.config.ApplicationConfig;
import com.github.setzo.crawler.entity.Mission;

public class DatabaseHandlerService {

	private Connection con;

	public void connect() throws SQLException {

		if (con != null) {
			return;
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		con = DriverManager.getConnection(
				ApplicationConfig.getDatabaseConnectionUrl(), 
				ApplicationConfig.getDatabaseUsername(), 
				ApplicationConfig.getDatabasePassword()
		);
	}

	public void disconnect() {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkIfMissionExists(Mission mission) throws SQLException {
		
		this.connect();
		
		PreparedStatement check = 
				con.prepareStatement
				("select count(*) as count from Missions where name=?");
		
		check.setString(1, mission.getName());
		ResultSet checkRes = check.executeQuery();

		checkRes.next();
		int count = checkRes.getInt(1);
		
		checkRes.close();
		check.close();
		
		return count != 0;
	}
	
	public void saveMission(Mission mission) throws SQLException {
		
		this.connect();
		
		PreparedStatement insert = 
				con.prepareStatement
				("insert into Missions (type, name, dateFound) value(?, ?, ?)");
		
		int col = 1;
		insert.setInt(col++, mission.getType().getId());
		insert.setString(col++, mission.getName());
		insert.setTimestamp(col++, new Timestamp(mission.getDate().getEpochSecond() * 1000L));
		
		insert.executeUpdate();
		
		insert.close();
	}
}
