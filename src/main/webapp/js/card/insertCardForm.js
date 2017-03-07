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

// db에 담기까지는 성공, dataType 제이슨으로 하면 안되는거 해결하기, cardFeeling 1로만 담기는 거 고치기, userSeq 받아오기, 지도에서 좌표 주기


