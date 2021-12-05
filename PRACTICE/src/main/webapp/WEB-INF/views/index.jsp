<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX.JSP</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<link rel="stylesheet" href="resources/css/login.css">
<script type="text/javascript" src="resources/js/login.js"></script>
<script>
	var naverLogin = new naver.LoginWithNaverId({
		clientId: "_SGCqXrZPI5g0pMyEdOe", 
		callbackUrl: "http://localhost/login_result.do", // 콜백할 페이지
		isPopup: false,
		loginButton: {color: "green",type: 3, height: 50}
	});	
	naverLogin.init();
	
        // 버튼을 위설정에서 만들지않고 이미지를 가지고왔을땐 아래 코드 추가
	$(document).on("click", "#naverLogin", function(){
		var btnNaverLogin = document.getElementById("naverIdLogin").firstChild;
		btnNaverLogin.click();
	});
</script>



</head>
<body>
	<h1>여기가 제일 처음으로 열리는 Page</h1>
	<a href="viewUser.do">회원정보보기</a>
	<a href="view.board">게시글상세보기</a>
	
	<!-- Login Form -->
	<div>
		<div id="naverIdLogin" style="display:none;"></div>
		<div id="naverLogin" class="naver"><img alt="" src="/btn_naver.png"> 네이버 간편 로그인</div>		
	</div>
	
	    <div class="container">
        <header>
            <div class="login_img"><a href="http://sinchon.koreaisacademy.com/">koreaIt</a>
            </div>
        </header>
        <section>
            <form id="login_form" action="index.html" method="post"> <!--method="POST"-->
            <div class="check_login_wrap">
                <p>※ 회원구분을 위해 체크해 주세요</p>
                <label class="selector" for="student">
                    <input class="check_login" id="student" type="radio" name="check_type" value="수강생">
                    <span>수강생</span>
                </label>
                
                <label class="selector" for="normal">
                    <input class="check_login" id="normal" type="radio" name="check_type" value="일반회원">
                    <span>일반회원</span>
                </label>

            </div>
                <div class="input_box">
                    <input id="user_id" class="input_log" type="text" name="user_id" placeholder="아이디" > <!-- required --> <!-- autofocus -->
                    <p class="log_msg"></p>
                    <input id="user_pw" class="input_log" type="password" name="user_pw" placeholder="●●●●" ><!-- required -->
                    <p class="log_msg"></p> 
                </div>
                <div class="login_btn">
                    <button type="submit" id="sub_btn">로그인</button>  <!-- submit 버튼자리.. -->
                </div>
            </form>
        </section>
        <footer>
            <div class="btn_wrap">
                <div class="two_btn">
                    <p class="title">아직 회원이 아닌가요?</p>
                    <p class="msg">가입하면 다양한 서비스 이용이 가능합니다.</p>
                    <div class="btn">
                        <a href="#">회원가입</a>
                    </div>
                </div>
                <div class="two_btn">
                    <p class="title">아이디/비밀번호를 잊으셨나요?</p>
                    <p class="msg">간단하게 아이디/비밀번호를 찾을 수 있습니다.</p>
                    <div class="btn">
                        <a href="#">아이디/비밀번호 찾기</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
	
	
</body>
</html>