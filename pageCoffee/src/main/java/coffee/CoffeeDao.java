package coffee;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeDao {
	
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
	
	public int getTotalCnt() {
		Connection con = dbcon();
		String sql = "select count(*) from coffeetbl";
		int totalCnt = 0;

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// close();
		return totalCnt;

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
	
	public ArrayList<Coffee> selectAll(){
		Connection con = dbcon();
		ResultSet rs = null;
		PreparedStatement pst = null;
		
		String sql = "select * from coffeetbl";
		
		ArrayList<Coffee> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				
				Coffee c = new Coffee(code, name, price);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(rs,pst,con);
		return list;
	}
	
	public ArrayList<Coffee>getListPage(int page, int pageSize){
		int startPage = 1, endPage = 5;
		
		startPage = ((page-1)*pageSize )+1;
		endPage = page * pageSize;
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select * from (select rownum num, code, name, price from coffeetbl) where num between ? and ?";
		
		System.out.println(sql);
		ArrayList<Coffee> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, startPage);
			pst.setInt(2, endPage);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString(2);
				String name = rs.getString(3);
				String price = rs.getString(4);
				
				Coffee c = new Coffee(code, name, price);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		CoffeeDao dao = new CoffeeDao();
		System.out.println("ok");
		
		//ArrayList<Coffee> list = dao.selectAll();
		//System.out.println(list);
		
		ArrayList<Coffee> list = dao.getListPage(1, 5);
		System.out.println(list);
		
		
		//int result = dao.getTotalCnt();
		//System.out.println(result);
	}

}
