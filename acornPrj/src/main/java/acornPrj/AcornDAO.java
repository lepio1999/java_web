package acornPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class AcornDAO {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";

		public Connection dbcon() {

			Connection con = null;
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
				if (con != null)
					System.out.println("ok");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		public void close(AutoCloseable... a) {
			
			for (AutoCloseable item : a) {
				try {
					item.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		public ArrayList<Acorn> selectAll() {
			Connection con = dbcon();
			ResultSet rs = null;
			PreparedStatement pst = null;

			// sql
			String sql = "select * from acorntbl";

			ArrayList<Acorn> list = new ArrayList<>();
			// sql실행
			try {
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();

				while (rs.next()) {
					
					String id=  rs.getString(1) ;
					String pw=  rs.getString(2) ;
					String name=  rs.getString(3) ;
					
					list.add( new Acorn(id, pw, name));
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(rs, pst, con);
			return list;
		
		}

}
