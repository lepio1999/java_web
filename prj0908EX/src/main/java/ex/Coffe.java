package ex;

public class Coffe {
	//ArrayList에 커피정보 (Coffee 클래스 사용 ) , code="c001" name="아메리카노" price=2000 , 여러개를 저장하고 출력하기
	String code;
	String name;
	String price;
	
public Coffe() {
	// TODO Auto-generated constructor stub
}

public Coffe(String code, String name, String price) {
	super();
	this.code = code;
	this.name = name;
	this.price = price;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

@Override
public String toString() {
	return "Coffe [code=" + code + ", name=" + name + ", price=" + price + "]";
}
	
	
	
	

}
