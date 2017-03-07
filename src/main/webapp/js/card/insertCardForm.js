/**
 * 
 */
// 글자수 제한 및 글자수 표시
$(document).ready(function() {
	$('#cardContent').on('keyup', function() {
		if ($(this).val().length > 140) {
			alert('글자수는 140자 까지입니다.');
			$(this).val($(this).val().substring(0, 140));
		}
		$('#count').html($(this).val().length + '/140');
	});
});

function popupOpen() {
	var popUrl = "insertCardFormPopup.html";
	var popOption = "width=400, height=200, resizable=yes, scrollbars=yes, status=no";
	window.open(popUrl, "", popOption);
}

// 파일 업로드

$("#cardInsert").submit(function() {
	
	
	if ($("#cardContent").val() === null) {
		alert("당신의 이야기를 입력해주세요 ^^");
		$("#cardContent").focus();
		return false;
	}
	if ($("#cardFeeling").val() === null) {
		alert("당신의 기분을 선택해주세요 ^^");
		$("#cardFeeling").focus();
		return false;
	}
	if ($("#cardHashtag").val() === null) {
		alert("해시태그를 1개 이상 입력해주세요 ^^");
		$("#cardHashtag").focus();
		return false;
	}
	if ($("#cardLongitude").val() === null) {
		alert("현재 위치를 조회해주세요 ^^");
		$("#cardLongitude").focus();
		return false;
	}

	var fd = new FormData();
	var file = $("#cardImg")[0].files;
	
	fd.append("cardContent", $("input[name=cardContent]").val());
	fd.append("cardFeeling", $("input[name=cardFeeling]").val());
	fd.append("cardHashtag", $("input[name=cardHashtag]").val());
	fd.append("cardLongitude", $("input[name=cardLongitude]").val());
	fd.append("cardLatitude", $("input[name=cardLatitude]").val());
		
	for (var i = 0 ; i < files.length ; i++) {
		fd.append("cardImgPath", files[i]);
	}
	
	$.ajax({
		url: "/b90m2t4/card/insert.do",
		type: "POST",
		data: fd,
		dataType: "json",
		processData: false,
		contentType: false
	})
	.done (function (result) {
		
	})
	.fail (function (jqXhr, textStatus, errorText) {
		alert("에러발생 : " + errorText);
	});	
	return false;
});


