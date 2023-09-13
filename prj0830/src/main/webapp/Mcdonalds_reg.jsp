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
		let menu_code = frm.menu_code;
		let menu_set = frm.menu_set;
		let menu_price = frm.menu_price;

		if (menu_code.value == "") { // 불필요한 .value 제거
			alert("새 메뉴코드를 입력하세요.");
			menu_code.focus();
			return false;
		}

		if (menu_set.value == "") { // 불필요한 .value 제거
			alert("새 세트메뉴 이름을 입력하세요.");
			menu_set.focus();
			return false;
		}
		if (menu_price.value == "") { // 불필요한 .value 제거
			alert("새 세트메뉴의 가격을 입력하세요.");
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
<a href="./Mcdonalds_reg.jsp">세트 메뉴 등록 /</a>
<a href="./Mcdonalds_list.jsp">세트 메뉴 조회&변경 /</a>
<a href="./index.jsp">홈으로</a>
</nav>
	<!--submit 을 중지하고 싶을 때 사용 -->

	<form name="frm" action="McReg_action.jsp" method="post" onsubmit="return check()">
<table> <caption><h2>새 메뉴 추가</h2></caption>
    <tr>
        <td>메뉴코드  </td>
        <td colspan="6"><input type="text" name="menu_code" placeholder="A000"></td>
        
    </tr>

    <tr>
        <td>메뉴 이름</td>
        <td colspan="6"><input type="text" name="menu_set" placeholder="불고기버거세트"></td>

    </tr>
    <tr>
        <td>메뉴가격</td>
        <td colspan="6"><input type="text" name="menu_price" placeholder="5000">

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