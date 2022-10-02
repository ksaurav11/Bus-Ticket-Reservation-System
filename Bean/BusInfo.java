package com.masai.Bean;

public class BusInfo {
	int busnumber;
	String Bname; 
	String Broute; 
	String Btype; 
	int availseats; 
	String departureTime ; 
	String ArrivalTime; 
	String contact; 
	
	public BusInfo() {
		// TODO Auto-generated constructor stub
	}

	public BusInfo(int busnumber, String bname, String broute, String btype, int availseats, String departureTime,
			String arrivalTime, String contact) {
		super();
		this.busnumber = busnumber;
		Bname = bname;
		Broute = broute;
		Btype = btype;
		this.availseats = availseats;
		this.departureTime = departureTime;
		ArrivalTime = arrivalTime;
		this.contact = contact;
	}

	public int getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(int busnumber) {
		this.busnumber = busnumber;
	}

	public String getBname() {
		return Bname;
	}

	public void setBname(String bname) {
		Bname = bname;
	}

	public String getBroute() {
		return Broute;
	}

	public void setBroute(String broute) {
		Broute = broute;
	}

	public String getBtype() {
		return Btype;
	}

	public void setBtype(String btype) {
		Btype = btype;
	}

	public int getAvailseats() {
		return availseats;
	}

	public void setAvailseats(int availseats) {
		this.availseats = availseats;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "BusInfo [busnumber=" + busnumber + ", Bname=" + Bname + ", Broute=" + Broute + ", Btype=" + Btype
				+ ", availseats=" + availseats + ", departureTime=" + departureTime + ", ArrivalTime=" + ArrivalTime
				+ ", contact=" + contact + "]";
	}
	

}
