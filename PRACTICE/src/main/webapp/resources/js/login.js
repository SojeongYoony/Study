/**
 * 
 */
 
 
     onload = function(){

        let userId = document.getElementById('user_id');
        let userPw = document.getElementById('user_pw');
        let loginForm = document.getElementById('login_form');
        let logMsg = document.getElementsByClassName('log_msg');
        loginForm.onsubmit = function(event){
            if(userId.value == '') {
                alert('아이디를 입력하세요');
                userId.focus();
                event.preventDefault();
                return false;
            } else if (userPw.value == '') {
                alert('비밀번호를 입력하세요');
                userPw.focus();
                event.preventDefault();
                return false;
            }
        }
        
        userId.onkeyup = function(){

            if(this.value.length < 4) {
                $(logMsg[0]).text('아이디는 4자 이상입니다.')
                $(logMsg[0]).addClass('fail');
                // logMsg[0].textContent = '아이디는 4자 이상입니다.';
                // logMsg[0].className += ' fail';
                
            } else if(this.value.length >= 4) {
                $(logMsg[0]).text('정상적인 아이디입니다.')
                $(logMsg[0]).addClass('succ');
                // logMsg[0].textContent = '정상적인 아이디입니다.';
                // logMsg[0].className += ' succ';
            }
        };

    };