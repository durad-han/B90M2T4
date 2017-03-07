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
var fd = new FormData();
var file = $("#cardImg")[0].files;

fd.append("cardContent", $("#cardContent").val());
fd.append("cardFeeling", $("#selectFeeling").val());
fd.append("cardHashtag", $("#hashtagText").val());
fd.append("cardLongitude", $("#cardLongitude").val());
fd.append("cardLatitude", $("#cardLatitude").val());
fd.append("cardImgpath", $("#cardImg").files[0]);

$.ajax({
	url: "",
	type: "",
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


