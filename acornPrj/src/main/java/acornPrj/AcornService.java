package acornPrj;
import java.util.ArrayList;

public class AcornService {
	
	
	AcornDAO dao = new AcornDAO();
	
	public ArrayList<Acorn> getAcorns(){
		
		ArrayList<Acorn> list = dao.selectAll();
		
		
		return list;
	}
	

}
