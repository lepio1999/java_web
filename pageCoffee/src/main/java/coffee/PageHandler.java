package coffee;

public class PageHandler {
	int currentPage; // 현재페이지
	int totRecords; // 총 레코드 수
	int pageSize; // 페이지 사이즈( 한 페이지에 보이는 글의 수)
	int grpSize; // 그룹의 사이즈

	int totalPage;
	int currentGrp;
	int grpStartPage;
	int grpEndPage;
	public PageHandler(int currentPage, int totRecords, int pageSize, int grpSize) {
		super();
		this.currentPage = currentPage;
		this.totRecords = totRecords;
		this.pageSize = pageSize;
		this.grpSize = grpSize;
		
		calcPage();
	}
	
	private void calcPage() {
		//총페이지
		int remain = totRecords % pageSize;
		if(remain == 0 ) {
			totalPage = totRecords / pageSize;
		}else {
			totalPage = totRecords / pageSize +1;
		}
		//현재 그룹
		int remain2 = currentPage % grpSize;
		if(remain2 == 0) {
			currentGrp = currentPage / grpSize;
		}else {
			currentGrp = currentPage / grpSize +1;
		}
		grpStartPage = (currentGrp -1) * grpSize +1;
		grpEndPage = currentGrp * grpSize;
		
		if(grpEndPage > totalPage) {
			grpEndPage = totalPage;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotRecords() {
		return totRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getGrpSize() {
		return grpSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getCurrentGrp() {
		return currentGrp;
	}

	public int getGrpStartPage() {
		return grpStartPage;
	}

	public int getGrpEndPage() {
		return grpEndPage;
	}
	
	
	

}
