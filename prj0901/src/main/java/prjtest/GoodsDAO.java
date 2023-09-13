package prjtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDAO {
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

	private void close(AutoCloseable... a) {
		for (AutoCloseable item : a) {
			try {
				item.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public ArrayList<String> selectAll() {
		Connection con = dbcon();

		String sql = "select name from goodstbl";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(rs, pst, con);
		return list;
	}
	
	public void insertMenu3(Menu m) {
		Connection con = dbcon();
		
		String sql = "insert into goodstbl values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, m.getId());
			pst.setString(2, m.getName());
			pst.setString(3, m.getPrice());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close (pst,con);
	}
	
	public void deletOne(String id) {
		Connection con = dbcon();
		String sql = "delete from acorntbl where id=?";
		PreparedStatement pst  = null;
		
		try {
			pst =  con.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pst,con);
	}

	public static void main(String[] args) {
		GoodsDAO dao = new GoodsDAO();
		
		//Menu m = new Menu("test10","카푸치노","5000");
		//dao.insertMenu3(m);

	}

}