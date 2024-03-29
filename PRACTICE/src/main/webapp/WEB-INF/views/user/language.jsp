<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>language</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style type="text/css">
	.wrap {
		display: flex;
		justify-content: center;
	}
	.left, .right {
		padding: 10px;
	}
</style>
</head>
<body>

	<h1 style="text-align: center;">언어 감지 API 구현</h1>
	
	<div class="wrap">
	
		<div class="left">
			<form>
				<select id="source"> <!-- CHANGE EVENT  -->
					<option value="">언어선택</option>
					<option value="ko">한국어</option>
					<option value="en">영어</option>				
				</select><br>
				<textarea rows="20" cols="60" id="text" placeholder="번역할 내용 입력"></textarea><br>
				<input type="button" value="번역하기" id="btn">
			</form>
		</div>
		
		<div class="right">
			<form>
				<select id="target">
					<option value=""></option>
					<option value="ko">한국어</option>
					<option value="en">영어</option>
				</select><br>
				<textarea rows="20" cols="60" id="translated"></textarea><br>
			</form>
		</div>
		
	</div>


</body>
</html>

