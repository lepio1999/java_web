package burger;

public class Burger {
	
	String menuCode;
	String menuName;
	String menuPrice;
	
	
	public Burger(String menuCode, String menuName, String menuPrice) {
		super();
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}


	@Override
	public String toString() {
		return "Burger [menuCode=" + menuCode + ", menuName=" + menuName + ", menuPrice=" + menuPrice + "]";
	}


	public String getMenuCode() {
		return menuCode;
	}


	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}


	public String getMenuPrice() {
		return menuPrice;
	}


	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}


	private void burger() {
		// TODO Auto-generated method stub

	}
	

}
