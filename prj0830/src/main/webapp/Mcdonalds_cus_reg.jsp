<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	
	<title>Insert title here</title>

	<link href="./css/Mcdonalds.css" rel="stylesheet" />
	
</head>
<script>

function check() {
	let frm = document.frm;
	let cust_code = frm.cust_code;
	let cust_name = frm.cust_name;
	let cust_adress = frm.cust_adress;

	if (menu_code.value == "") { // 불필요한 .value 제거
		alert("등록할 코드를 입력하세요.");
		menu_code.focus();
		return false;
	}

	if (menu_set.value == "") { // 불필요한 .value 제거
		alert("등록할 이름을 입력하세요.");
		menu_set.focus();
		return false;
	}
	if (menu_price.value == "") { // 불필요한 .value 제거
		alert("등록할 새 주소를 입력하세요.");
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
<a href="./Mcdonalds_cus_reg.jsp">고객 정보 등록 /</a>
<a href="./Mcdonalds_cus.jsp">고객 정보 조회&변경 /</a>
<a href="./index.jsp">홈으로</a>
</nav>
	<!--submit 을 중지하고 싶을 때 사용 -->

	<form name="frm" action="McCusReg_action.jsp" method="post" onsubmit="return check()">
<table><caption><h2>새 고객 추가</h2></caption>
    <tr>
        <td>코드  </td>
        <td colspan="6"><input type="text" name="cust_code" placeholder="B000"></td>
        
    </tr>

    <tr>
        <td>이름</td>
        <td colspan="6"><input type="text" name="cust_name" ></td>

    </tr>
    <tr>
        <td>주소</td>
        <td colspan="6"><input type="text" name="cust_adress" placeholder="00구 0000">

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