package Bus_res;

import java.sql.*;

public class BusDAO {
	public void getBusInfo() throws SQLException {
		
		String query="select * from Bus;";
		Connection con = DB.getConnection();
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus no:"+rs.getInt(1));
			if(rs.getInt(2)==1) {
				System.out.println("AC:YES");
			}
			else
				System.out.println("AC:NO");
			System.out.println("Capacity:"+rs.getInt(3));
			System.out.println("--------------------------------------------------");
		}
	}
	
	public int getCapacity(int n) throws SQLException {
		Connection con=DB.getConnection();
		Statement st=con.createStatement();
		
		String query="select capacity from bus where id="+n+";";
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
		
	}

}
