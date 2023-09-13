package coffee;

public class Coffee {
	String code;
	String name;
	String price;
	public Coffee(String code, String name, String price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Coffe [code=" + code + ", name=" + name + ", price=" + price + "]";
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}

	
}
