package prj0901;

public class Customer {
	
	//class type 정의 <= 고객정보(구조가 있는 데이터)를 담을 수 있는 자료형 만드는것
	//class type로 변수를 만들 때는 반드시 new를 통해서 변수가 만들어진다. 변수를 객체라고 부른다.
	String id;
	String pw;
	String name;
	public Customer(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public Customer(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public Customer() {
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	


	// 생성자
	// setter getter
	// toString()

}
