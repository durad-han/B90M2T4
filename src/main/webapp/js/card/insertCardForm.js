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

// 해시태그 팝업 오픈
function popupOpen() {
	var popUrl = "insertCardFormPopup.html";
    var popOption = "width=400, height=270, resizable=yes, scrollbars=yes, status=no";
	window.open(popUrl, "", popOption);
}

// 카드 작성
$("#cardInsert").submit(function() {
    
//  if ($("#cardLongitude").val() == null) {
//      alert("현재 위치를 조회해주세요 ^^");
//      $("#cardLongitude").focus();
//      return false;
//  }
  if ($("#cardContent").val() == null) {
      alert("당신의 이야기를 입력해주세요 ^^");
      $("#cardContent").focus();
      return false;
  }
  if ($("#cardHashtag").val() == null) {
      alert("해시태그를 1개 이상 입력해주세요 ^^");
      $("#cardHashtag").focus();
      return false;
  }
  console.log($("input[name=cardImg]").val());
  
  var fd = new FormData();

  if($("input[name=cardImg]").val()) {
      var files = $("input[name=cardImg]")[0].files;
      for (var i = 0 ; i < files.length ; i++) {
          fd.append("cardImgPath", files[i]);
      }        
  }
  
  fd.append("cardContent", $("[name=cardContent]").val());
  fd.append("cardFeeling", $("input[name=cardFeeling]:checked").val());
  fd.append("cardHashtag", $("input[name=cardHashtag]").val());
  fd.append("cardLongitude", $("input[name=cardLongitude]").val());
  fd.append("cardLatitude", $("input[name=cardLatitude]").val());
  
  $.ajax({
      url: "/b90m2t4/card/insert.do",
      type: "post",
      data: fd,
      dataType: "html",
      processData: false,
      contentType: false
  })
  .done (function (result) {
      alert("msg");
      location.href="../../view/main/main.html";
  })
  .fail (function (jqXhr, textStatus, errorText) {
      alert("에러발생 : " + errorText);
  });    
  return false;
});
