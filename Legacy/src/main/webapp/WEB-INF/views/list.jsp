<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!-- c:choose등을 사용하기위해서 선언해주는 taglib -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 폰으로 볼수있는 반응형 웹(viewport -->
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>리스트페이지</title>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- 볼때는 .min없는 파일로보고 쓸때는 .min붙은 파일쓰는게좋음(압ㅇ축) 부트스트랩 css파일 -->

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="/css/starter-template.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<!-- <script src="/js/jquery-3.4.1.js"></script>
<script src="/js/bootstrap.min.js"></script> -->
<!-- 부트스트랩 cdn 으로 작동  -->


<script type="text/javascript">
 function keyword_check(){
  if(document.search.keyword.value==''){ //검색어가 없을 경우  
  alert('검색어를 입력하세요'); //경고창 띄움 
  document.search.keyword.focus(); //다시 검색창으로 돌아감 
  return false; 
  }
  else return true;
 }
</script>

</head>
<body>
	<div class="container" >
		<h1>도서관리</h1>
		<div align="right">
			<form method="get" action="search" onsubmit="return keyword_check()">
			<%-- <select name="option">
				<option value="ID">도서번호</option>
				<option value="NAME">도서명</option>
				<option value="PUBLISHER">출판사</option>
			</select> --%>
			 <input type="text" name="keyword"> 
 			 <input type="submit" value="검색" class="btn btn-sm btn-outline-dark">
			</form>
			</div>
			
		<table class="table table-hover">
			<thead>
				<tr class="bg-warning">
					<th colspan="2">도서번호</th>
					<th colspan="1">도서명</th>
					<th colspan="1">출판사</th>
					<th colspan="1">가격</th>
					<th ></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${list.size()>0}">
						<c:forEach var="item" items="${list}">

							<tr>
								<td colspan="2" onclick="location.href='view?bookid=${item.bookid}'">${item.bookid}</td>
								<td>${item.bookname }</td>
								<td>${item.publisher }</td>
								<td>${item.price }</td>

								<td><a href="update?bookid=${item.bookid }" type="button"
									class="btn btn-sm btn-outline-warning">수정</a> 
									<a href="delete?bookid=${item.bookid }" type="button"
									class="btn btn-sm btn-outline-info">삭제</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">등록된 도서가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div>${pager.pagination}</div>
		<div align="right">
			<a href="insert" class="btn btn-outline-dark">등록</a> 
			<a href="dummy" class="btn btn-outline-danger">쓰레기 100개등록</a> 
			<a href="init" class="btn btn-outline-secondary">전체삭제</a>
		</div>
	</div>
</body>
</html>


