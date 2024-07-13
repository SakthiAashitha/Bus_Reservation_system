package Bus_res;
import java.util.Scanner;
import java.sql.*;

public class BusDemo {
	public static void main(String[] args) throws SQLException {
		
		BusDAO busdao = new BusDAO();
		busdao.getBusInfo();
		
		Scanner sc = new Scanner(System.in);
		int userOpt=1;
		
		while(userOpt==1) {
			System.out.println("Enter 1 to book 2 to exit:");
			userOpt=sc.nextInt();
			if(userOpt==1) {
				Booking booking=new Booking();
				if(booking.isAvailable()){
					BookingDAO bookingdao=new BookingDAO();
					bookingdao.addBooking(booking);
					System.out.println("=================================================");
					System.out.println("Your booking is successfull");
					System.out.println("=================================================");
				}
				else
					System.out.println("Sorry  for the inconvinience.\nBus is full.\nKindly choose some other bus or date.");
			}
			
		}
		sc.close();
	}
}
