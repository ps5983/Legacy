<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
	<div>
		<h1>도서 상세보기</h1>
		<div>
			<form action="list" method="post">
				<div>
					<p>
						<label>도서&nbsp;번호 : </label> 
						<input type="number" name="bookid" value="${item.bookid }" readonly>
					</p>
				</div>
				<div>
					<p>
						<label>도 &nbsp;서&nbsp;&nbsp;명 :</label>  <input type="text" name="bookname" value="${item.bookname }" readonly>
					</p>
				</div>

				<div>
					<p>
						<label>출&nbsp;&nbsp;판&nbsp;&nbsp;사 :</label><input type="text" name="publisher" value="${item.publisher }" readonly>
					</p>
				</div>

				<div>
					<p>
						<label>가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;격 : </label> <input type="number" name="price" value="${item.price }" readonly>
					</p>
				</div>

				<input type="submit" value="목록으로">
			</form>
			<form action="update" method="post">
			<input type="button" value="수정하기" onClick="location.href='update?bookid=${item.bookid }'">
			</form>
		</div>
	</div>
</body>
</html>