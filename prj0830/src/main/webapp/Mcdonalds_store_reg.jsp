<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	
	<title>Insert title here</title>
	<link href="./css/index.css" rel="stylesheet" />
	<link href="./css/Mcdonalds.css" rel="stylesheet" />
	<link href="./css/insert.css" rel="stylesheet" />
	
</head>
<script>

function check() {
	let frm = document.frm;
	let store_code = frm.store_code;
	let store_loc = frm.store_loc;
	let store_m = frm.store_m;

	if (menu_code.value == "") { // 불필요한 .value 제거
		alert("등록할 코드를 입력하세요.");
		menu_code.focus();
		return false;
	}

	if (menu_set.value == "") { // 불필요한 .value 제거
		alert("등록할 지점명을 입력하세요.");
		menu_set.focus();
		return false;
	}
	if (menu_price.value == "") { // 불필요한 .value 제거
		alert("등록할 지점장 이름 입력하세요.");
		menu_price.focus();
		return false;
	}


		return true;
	}

</script>

<body>
<div class="main">

<header><img src="https://arteepedicab.com/wp-content/uploads/2021/01/McDonalds-Logo.png" ></header>
<nav>
<a href="./Mcdonalds_store_reg.jsp">고객 정보 등록 /</a>
<a href="./Mcdonalds_store.jsp">고객 정보 조회&변경 /</a>
<a href="./index.jsp">홈으로</a>
</nav>
	<!--submit 을 중지하고 싶을 때 사용 -->

	<form name="frm" action="McStoreReg_action.jsp" method="post" onsubmit="return check()">
<table><caption><h2>새 지점 추가</h2></caption>
    <tr>
        <td>지점코드  </td>
        <td colspan="6"><input type="text" name="store_code" placeholder="P000"></td>
        
    </tr>

    <tr>
        <td>지점이름</td>
        <td colspan="6"><input type="text" name="store_loc" placeholder="00점" ></td>

    </tr>
    <tr>
        <td>지점장 이름</td>
        <td colspan="6"><input type="text" name="store_m" >

        </td>

    <tr>
        <td colspan="7">
            <div class="button">
            <button>등록</button>
            <button>취소</button>
            </div>
        </td>

    </tr>
</table>
	</form>
	<footer></footer>
	</div>
</body>

</html>