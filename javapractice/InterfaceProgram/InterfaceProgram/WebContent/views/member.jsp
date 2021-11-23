<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>member list / insert / delete</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		*{
			padding: 0;
			margin: 0;
			box-sizing: border-box;
		}
		.wrap {
			width: 1500px;
			margin: 0 auto;
			padding: 10px;
			display: flex;
		}
		.input_area {
			width: 300px;
			padding: 10px;
		}
		.list_area {
			width: 1200px;
			padding: 10px;
		}
		.list_area table {
			border-collapse: collapse;
			width: 100%;
		}
		.list_area table td {
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
			padding: 3px 5px;
			text-align: center;
		}
	</style>
	<script>
	</script>


	<script>
		$(document).ready(function(){
			fnSelectMemberList();
			fnInsertMember();
			fnDeleteMember();
		}); // page load 
		
	<%-- ---------- fnSelectMemberList() ---------- --%>		
		function fnSelectMemberList(){
			$.ajax({
					 url: '/InterfaceProgram/selectMemberList.do',	// contextPath가 없을 때 표시가 안됨.
					type: 'get',
				dataType: 'json',
				 success: function(members){
					
					
					$.each(members, function(i, member){
						if (members.length == 0) {
			                   $('<tr>')
			                   .append($('<td colspan="6">').text('등록된 회원이 없습니다.'))
			                   .appendTo('#member_list');
			                } else { 
			                	
							$('#member_list').empty();
			                   $.each(members, function(i, member){
			                      $('<tr>')
			                      .append($('<td>').text(member.no))
			                      .append($('<td>').text(member.name))
			                      .append($('<td>').text(member.age))
			                      .append($('<td>').text(member.birthday))
			                      .append($('<td>').text(member.regDate))
						          .append($('<td>').html('<input type="button" value="삭제" class="delete_btn" data-no="' + member.no + '">') )	// data('no') data :: 키워드 no::변수명
			                      .appendTo($('#member_list'))
			                   }) // end for
			                   
			                } // end if
			             })
				 },
				    error: function(xhr){
					 		console.log(xhr.status)
				 }
			}) // End ajax
		} // End fnSelectMemberList
		
	<%-- ---------- fnInsertMember() ---------- --%>	
		function fnInsertMember(){
			$('#insert_btn').on('click', function(){
				if( $('#no').val().length < 6 || isNaN($('#no').val())) {
					alert('회원번호는 6자리 숫자입니다.');
					return;
				}
				
				$.ajax({
					url: '/InterfaceProgram/insertMember.do',
					type: 'post',
					data: $('#f').serialize(),
					dataType: 'json',
					success: function(obj){
						alert('회원 등록이 성공했습니다.');
						fnSelectMemberList();
					},
					error: function(xhr){
						if(xhr.status == 2001) {
							alert(xhr.responseText);
						} else if (xhr.status == 2002) {
							alert(xhr.responseText);
						} else if (xhr.status == 2003) {
							alert(xhr.responseText);
						}
							
					}// end error
					
				}); // end ajax
				
			}); // end click event
		} // end fnInsert
		
		
		
		
		
		
		
		
	<%-- ---------- fnDeleteMember() ---------- --%>	
		
		function fnDeleteMember(){
			$('body').on('click', '.delete_btn', function(){
				let deleteNo = $(this).data('no');
				if(confirm('회원번호 '+ deleteNo +' 회원의 정보를 삭제할까요?')) {
					$.ajax({
						url: '/InterfaceProgram/deleteMember.do',
						type: 'get',
						data: 'no=' + deleteNo,
						dataType: 'json',
						success: function(obj){
							if(obj.result){
								alert('회원번호 ' + deleteNo +' 회원 정보가 삭제되었습니다.');
								fnSelectMemberList();
							} else {
								alert('삭제실패');
							}
						},
						error: function(){
							alert('응답 실패');
						}
					})// end ajax
				}
				
			})
			
		} // end fnDeleteMember
		
		
	</script>


</head>
<body>
	<div class="wrap">
		<div class="input_area">
			<form id="f">
				<input type="text" name="no" id="no" placeholder="회원번호(6자리)"><br>
				<input type="text" name="name" id="name" placeholder="회원명"><br>
				<input type="text" name="age" id="age" placeholder="나이"><br>
				<input type="text" name="birthday" id="birthday" placeholder="생일"><br>
				<input type="button" value="등록하기" id="insert_btn">
			</form>
		</div>
		<div class="list_area">
			<table>
				<thead>
					<tr>
						<td>회원</td>
						<td>회원명</td>
						<td>나이</td>
						<td>생일</td>
						<td>가입일</td>
						<td>비고</td>	
					</tr>
				</thead>
				<tbody id="member_list"></tbody>
			</table>
		</div>
	</div>
</body>
</html>