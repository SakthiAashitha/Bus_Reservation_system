package Bus_res;

import java.sql.*;
import java.util.Date;

public class BookingDAO {
	public int getBooked(int busNo,Date date) throws SQLException {
		Connection con = DB.getConnection();
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		String query="select count(passenger_name) from bookings where busno=? and travel_date=?;";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,busNo);
		pst.setDate(2, sqldate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	
	public void  addBooking(Booking booking) throws SQLException{
		Connection con = DB.getConnection();
		String query ="insert into bookings values(?,?,?);";
		PreparedStatement pst = con.prepareStatement(query);
		java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		pst.setString(1,booking.passengerName);
		pst.setInt(2,booking.busNo);
		pst.setDate(3,sqldate);
		
		pst.executeUpdate();
	}
}
