package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Bean.BusInfo;
import com.masai.Bean.User;
import com.masai.Extension.BusNotFoundException;
import com.masai.Extension.InsufficientTicketException;
import com.masai.Extension.UserNotFoundException;
import com.masai.Utility.DBUtil;

public class BusTicketdaoIImpl implements BusTicketdao{
	
	

	@Override
	public String loginAdmin(String username, String password) throws UserNotFoundException {
		String message = "";

		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Administrator where Ausername=? and "
					+ "Apassword = ?"); 
		   ps.setString(1, username);
		   ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				message = rs.getString("Ausername");
			}
			
		}catch (SQLException e) {
			throw new UserNotFoundException("no user found");
		}
		
		return message;
	}


	@Override
	public List<BusInfo> prvoidebusdetails() throws BusNotFoundException {
		List<BusInfo> info = new ArrayList<>();
		
	try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from BusInfo"); 
		
		ResultSet rs=ps.executeQuery();
		
		boolean flag = true;
		while(rs.next()) {
			flag=false;
			int No = rs.getInt("BNumber");
			String bname = rs.getString("BName");
			String route = rs.getString("BRoute");
			String type = rs.getString("BType");
			String availseats = rs.getString("AvailSeats");
			String dtime = rs.getString("departureTime");
			String Atime = rs.getString("Arrival_Time");
			String contact = rs.getString("contact");
			
			BusInfo binfo = new BusInfo(No, bname, route, type, No, dtime, Atime, contact) ;
			info.add(binfo);
		}
		
		if(flag) {
			throw new BusNotFoundException("No Bus Record found");
		}
			
		} catch (SQLException e) {
		 throw new BusNotFoundException(e.getMessage());
		}
		
		
		
		return info;
	}

	


	@Override
	public String confirmTheSeat(User user) throws InsufficientTicketException {
		String message ="";
		try(Connection conn = DBUtil.provideConnection()) {
			System.out.println("Enter Bus Number");
			Scanner scanner =  new Scanner(System.in);
			int busNo = scanner.nextInt();
			PreparedStatement ps = conn.prepareStatement("select * from businfo where Bnumber =?");
			ps.setInt(1, busNo);
			ResultSet rSet=	ps.executeQuery();
			if(rSet.next()) {
				
			int avSeat =	rSet.getInt("availseats");
			
			if(avSeat>user.getNoOfseat()) {
				PreparedStatement ps1 = conn.prepareStatement("insert into BookTicket values(?,?,?,?,?,?,?,?,?,?)");
				ps1.setInt(1, busNo);
				ps1.setString(2,rSet.getString("BName") );
				ps1.setString(3,user.getUsername());
				ps1.setInt(4, user.getAge());
				ps1.setString(5, user.getGender());
				ps1.setInt(6, user.getNoOfseat());
				ps1.setString(7, user.getSource());
				ps1.setString(8, user.getDestination());
				ps1.setString(9, user.getDate());
				
				int newSeat = rSet.getInt("AvailSeats")-user.getNoOfseat();
			
				PreparedStatement ps2 = conn.prepareStatement("update Businfo set AvailSeats= ? where BNumber = ?");
				ps2.setInt(1, newSeat);
				ps2.setInt(2, busNo);
				
				message = "seat confirmed Contact to "+rSet.getString("contact")+" for further information";
				
				
				
			}else {
				throw new InsufficientTicketException("Insufficient seats");
			}
				
				
				
			}
		}catch (SQLException e) {
			throw new InsufficientTicketException("No Bus found");
		}
		
		
		return message;
	}

}
