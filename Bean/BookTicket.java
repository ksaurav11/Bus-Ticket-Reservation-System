package com.masai.Bean;

public class BookTicket {
	
	int bnumber ; 
	String Bname;
	String Passname;
	int noOfSeats;
	String source;
	String destintion;
	String date;
	
	public BookTicket() {
		// TODO Auto-generated constructor stub
	}

	public BookTicket(int bnumber, String bname, String passname, int noOfSeats, String source, String destintion,
			String date) {
		super();
		this.bnumber = bnumber;
		Bname = bname;
		Passname = passname;
		this.noOfSeats = noOfSeats;
		this.source = source;
		this.destintion = destintion;
		this.date = date;
	}

	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	public String getBname() {
		return Bname;
	}

	public void setBname(String bname) {
		Bname = bname;
	}

	public String getPassname() {
		return Passname;
	}

	public void setPassname(String passname) {
		Passname = passname;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestintion() {
		return destintion;
	}

	public void setDestintion(String destintion) {
		this.destintion = destintion;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BookTicket [bnumber=" + bnumber + ", Bname=" + Bname + ", Passname=" + Passname + ", noOfSeats="
				+ noOfSeats + ", source=" + source + ", destintion=" + destintion + ", date=" + date + "]";
	}
	
	

}
