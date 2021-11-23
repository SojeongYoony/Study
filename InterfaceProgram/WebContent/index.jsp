<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>시작화면</title>
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
	
	.input_area {
		padding: 10px;
	}
</style>


	<script>
		$(document).ready(function(){
			fnSelectStaffList();
			fnInsertStaff();
			fnDeleteStaff();
		});
		
	<%-------------------- fnSelectStaffList() -------------------%>
	function fnSelectStaffList(){
		$.ajax({
			     url: '/InterfaceProgram/selectStaffList.do',	
				type: 'get',
			dataType: 'json',
			 success: function(staffs){
				
				
				$.each(staffs, function(i, staff){
					if (staffs.length == 0) {
		                   $('<tr>')
		                   .append($('<td colspan="4">').text('등록된 사원이 없습니다.'))
		                   .appendTo('#staff_list');
		                } else { 
		                	
						$('#staff_list').empty();
		                   $.each(staffs, function(i, staff){
		                      $('<tr>')
		                      .append($('<td>').text(staff.sNo))
		                      .append($('<td>').text(staff.name))
		                      .append($('<td>').text(staff.dept))
		                      .append($('<td>').text(staff.regDate))
							  .append($('<td>').html('<input type="hidden" name="sNo" value="'+staff.sNo+'"><input type="button" value="삭제" class="delete_btn">'))				// *** tag를 만들어 넣어야 하므로 html 주의 ***
			                  .appendTo($('#staff_list'))
		                      
		                      
		                   }) // end for
		                   
		                } // end if
		             })
			 },
			    error: function(xhr){
				 		console.log(xhr.status)
			 }
			
			
		}) // end ajax
		
	} // end list function
	
/**************** 선생님 모범 답안 ! ajax와 table 만드는 function을 구분하여 사용하셨다 ****************
  
		  
		  	fn_staffTable을 생성하고, fn_selectStaffList를 생성하여,
		  	fn_selectStaffList function의 ajax가 success 하였을 때, fn_staffTable 함수를 호출하는 방법!!!
	  
	  
	 function fn_selectStaffList(){
			$.ajax({
				url: ,
				type: ,
				dataType: ,
				success: function() {
					$('#staff_list').empty();
					fn_staffTable(obj);
				},
				error: function() {
					alert('ajax 실패');
				}
			}) // end ajax
		} // end function
	 
	 function fn_staffTable(list){
			$.each(list, function(i, staff){
				$('<tr>')
				.append( $('<td>').text(staff.sNo) )
				.append( $('<td>').text(staff.name) )
				.append( $('<td>').text(staff.dept) )
				.append( $('<td>').text(staff.regDate) )
				.appendTo('#staff_list');
			});
		}
	
*************************************************************************************/
	
	<%-- ---------- fnInsertStaff() ---------- --%>	
	function fnInsertStaff(){
		$('#insert_btn').on('click', function(){
			let regName = /^[가-힣]{3,5}$/;
			let regSno = /^[0-9]{5}$/;
   /************* 시험 피드백 수정 : 아니다(!)를 붙이지 않아서 정규식 검사가 되지 않았다 *********/		
			if( !regSno.test($('#sNo').val()) ) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}

			if( !regName.test($('#dept').val()) ) {
				alert('부서는 3~5자리 한글입니다.');
				return;
			}
			
			$.ajax({
				url: '/InterfaceProgram/insertStaff.do',
				type: 'post',
				data: $('#fo').serialize(),
				dataType: 'json',
				success: function(obj){
	// 시험 문제 꼼꼼히 읽을 것. 시험 항목중, alert 하나 누락함 
	// 사원 등록이 성공한 경우 "사원 등록이 성공했습니다." 경고 메시지를 출력하시오.		
					alert('사원 등록이 성공했습니다.');
					fnSelectStaffList();
				},
				error: function(xhr){
					if(xhr.status == 1001) {
						alert(xhr.responseText);
					}
						
				}// end error
				
			}); // end ajax
			
		}); // end click event
	} // end fnInsert
	
	
	function fnDeleteStaff(){
		$('body').on('click', '.delete_btn', function(){
			if (confirm('삭제할까요?')) {
			$.ajax({
				url: 'deleteStaff.do',
				type: 'get',
				data: 'sNo=' + $(this).prev().val(),
				dataType: 'json',
				success: function(obj){
					if (obj.result){
						alert('삭제성공');
						fnSelectStaffList();
					} else {
						alert('삭제 실패');
					}
				},
				error: function(){
					alert('코드 수정 필요');
				}
			})
				
			}// end if
			
			
		
		})
};// 									
	/*
		제출 전, 포기했던 정규식..
			정규식 검사에 !을 빼먹지 말자!!
		
				// 정규식 
			// 사원번호 5자리 숫자
			// 부서 3~5자리 한글
			
			let regName = /^[가-힣]{3,5}$/;
			let regSno = /^[0-9]{5}$/
			
			if( regSno.test($('#sNo').val()) ) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}


			if( regName.test($('#dept').val()) ) {
				alert('부서는 3~5자리 한글입니다.');
				return;
			}
	*/
	
	
	
	
	</script>
	
</head>
<body>
	<div class="wrap">
			<h1>사원 정보 등록프로그램</h1>
			<br>
		<div class="input_area">
			<form id="fo">
				<input type="text" name="sNo" id="sNo" placeholder="사원번호">
				<input type="text" name="name" id="name" placeholder="사원명">
				<input type="text" name="dept" id="dept" placeholder="부서명">
				<input type="button" value="등록하기" id="insert_btn">
			</form>
		</div>
		<hr>
		<div class="list_area">
			<table>
				<thead>
					<tr>
						<td>사원번호</td>
						<td>사원명</td>
						<td>부서명</td>
						<td>입사일</td>
					</tr>
				</thead>
				<tbody id="staff_list"></tbody>
			</table>
		</div>
	</div>
</body>
</html>