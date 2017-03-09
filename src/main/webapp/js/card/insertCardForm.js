/**
 * 
 */
// 글자수 제한 및 글자수 표시
$(document).ready(function() {
	$('#writeCardContent').on('keyup', function() {
		if ($(this).val().length > 140) {
			alert('글자수는 140자 까지입니다.');
			$(this).val($(this).val().substring(0, 140));
		}
		$('#count').html($(this).val().length + '/140');
	});
});







//내 위치 가져오기

var latitude = "";
var longitude = "";
window.onload = getMyLocation;
function getMyLocation() {
	if (navigator.geolocation) navigator.geolocation.getCurrentPosition(displayLocation, displayError);
}
function displayLocation(position) {
	latitude = position.coords.latitude;
	longitude = position.coords.longitude;
	var location = document.getElementById("a");
	location.innerHTML = "당신의 위치 : 위도(" + latitude + "), 경도(" + longitude + ")";
}
function displayError(error) {}










// 해시태그 팝업 오픈
function popupOpen() {
	var popUrl = "../card/insertCardFormPopup.html";
    var popOption = "width=400, height=270, resizable=yes, scrollbars=yes, status=no";
	window.open(popUrl, "", popOption);
}

$("#cancle").click(function () {
	  location.href="../../view/main/main.html";
});


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
  fd.append("cardLongitude", longitude);
  fd.append("cardLatitude", latitude);
  
  $.ajax({
      url: "/b90m2t4/card/insert.do",
      type: "post",
      data: fd,
      dataType: "html",
      processData: false,
      contentType: false
  })
  .done (function () {
	  location.href="/b90m2t4/view/main/main.do";
  })
  .fail (function (jqXhr, textStatus, errorText) {
      alert("에러발생 : " + errorText);
  });    
  return false;
});
