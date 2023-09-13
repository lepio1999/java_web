package moviePrj_09_06;

public class Movie {
	String name;
	String chart;
	String year;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChart() {
		return chart;
	}
	public void setChart(String chart) {
		this.chart = chart;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "movie [name=" + name + ", chart=" + chart + ", year=" + year + "]";
	}
	public Movie(String name, String chart, String year) {
		super();
		this.name = name;
		this.chart = chart;
		this.year = year;
	}
	
	
	
}
