package com.masai.Dao;

import java.util.List;

import com.masai.Bean.BusInfo;
import com.masai.Bean.User;
import com.masai.Extension.BusNotFoundException;
import com.masai.Extension.InsufficientTicketException;
import com.masai.Extension.UserNotFoundException;

public interface BusTicketdao {
	
	public String loginAdmin(String username,String password) throws UserNotFoundException;
	public List<BusInfo> prvoidebusdetails() throws BusNotFoundException;
	public String confirmTheSeat(User user) throws InsufficientTicketException;

}
