package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.Bean.BusInfo;
import com.masai.Bean.User;
import com.masai.Dao.BusTicketdao;
import com.masai.Dao.BusTicketdaoIImpl;
import com.masai.Extension.BusNotFoundException;
import com.masai.Extension.InsufficientTicketException;
import com.masai.Extension.UserNotFoundException;
import com.mysql.cj.protocol.x.ContinuousOutputStream;

public class LoginUsecse {
	
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		
			BusTicketdao dao = new BusTicketdaoIImpl();
			System.out.println("Enter username");
			String username = scanner.next();
			System.out.println("Enter password");
			String password = scanner.next();
		try {
			String message =	dao.loginAdmin(username, password);
			
			System.out.println("Welcome to "+message+" travels");
			
				
			int count = 0 ; 
			while(count<3) {
				
				System.out.println("What do you want to give \n"
						+ "1. All Bus Details\n"
						+ "2. Book Bus ticket\n"
						+ "10. Exit");
				
				System.out.println();
				System.out.println("Type Number here....");
				
				int num= scanner.nextInt();
				if(num==1) {
					BusTicketdao dao1 = new BusTicketdaoIImpl();
					List<BusInfo> busdet;
					try {
						busdet = dao1.prvoidebusdetails();
						System.out.println("Bus information is ");
						System.out.println(busdet);
					} catch (BusNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
										
				}else if(num==2) {
					BusTicketdao dao1 = new BusTicketdaoIImpl();
					
					System.out.println("Enter passenger name ");
					String name = scanner.next();
					System.out.println("Enter passenger Age ");
					int ageInteger = scanner.nextInt();
					System.out.println("Enter passenger gender ");
					String gender = scanner.next();
					System.out.println("Enter passenger Seats ");
					int seats = scanner.nextInt();
					System.out.println("Enter source ");
					String source = scanner.next();
					System.out.println("Enter destination ");
					String dest = scanner.next();
					System.out.println("Enter date in formate YYYY-MM-DD ");
					String date = scanner.next();
					User user= new User(username, ageInteger, gender, seats, source, dest, date);
					 
				    try {
						String message1  = dao1.confirmTheSeat(user);
						System.out.println(message1);
					} catch (InsufficientTicketException e) {

							System.out.println(e.getMessage());
					}
				
				}else if(num==10) {
					count=10;
				}
			
				
				count++;
			}//while close
			
			
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
			
	
		System.out.println("Thank You");
		
	}

}
