<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 폰으로 볼수있는 반응형 웹(viewport -->
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<title>Insert</title>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- 볼때는 .min없는 파일로보고 쓸때는 .min붙은 파일쓰는게좋음(압ㅇ축) 부트스트랩 css파일 -->

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="/css/starter-template.css">
</head>
<body>
	<div class="table-responsive-lg">
		<h1>도서 등록</h1>

		<form action="insert" method="post" >
			<table class="table table-bordered">
				<tr>
					<td>도서&nbsp;번호 :
					<input type="number" name="bookid" value="${item.bookid }">
					</td>
				</tr>
				<tr>
					<td>도 &nbsp;서&nbsp;&nbsp;명 :
					<input type="text" name="bookname">
					</td>
				</tr>
				<tr>
					<td>출&nbsp;&nbsp;판&nbsp;&nbsp;사 :
					<input type="text" name="publisher">
					</td>
				</tr>
				<tr>
					<td>가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;격 :
					<input type="number" name="price">
					</td>
				</tr>
			</table>
			<input type="submit" value="등록!">
			<input type="submit" value="list로" onclick="javascript: form.action='/book/list';"/>
		</form>
	</div>
</body>
</html>