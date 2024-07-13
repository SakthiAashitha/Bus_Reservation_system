package Bus_res;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:");
		passengerName=sc.next();
		System.out.println("Enter Bus no:");
		busNo=sc.nextInt();
		System.out.println("Enter Date(dd-MM-yyyy):");
		String dateip=sc.next();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		try 
		{
			date=dateformat.parse(dateip);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
	}
	public boolean isAvailable() throws SQLException{
		
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao=new BookingDAO();
		
		int capacity=busdao.getCapacity(busNo);
		
		int booked=bookingdao.getBooked(busNo,date);
		
		return booked<capacity;		
	}
}