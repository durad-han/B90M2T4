/**
 * 
 */
// 글자수 제한 및 글자수 표시
$("#hashtagInput").keyup( function(e) {
	if (e.keyCode == 13) {
		opener.document.getElementById("hashtagText").value += " ";
		opener.document.getElementById("hashtagText").value += $("#hashtagInput").val();
		self.close();
	}
	console.log($("#hashtagInput").val());
	$.ajax({
		url : "/b90m2t4/card/retrieveHashtag.do",
		type : "POST",
		data : {"hashtagInput" : $("#hashtagInput").val()},
		dataType : "json"
	}).done( function(list) {
		console.log(list);
		var text = "";
		if (list.length != 0) {
			for (var i = 0; i < list.length; i++) {
				text += "<button type='button' id='b" + i + "' onclick='clickEvent(\"#" + list[i].hashtagContent + "\")'>#"
				+ list[i].hashtagContent + "</button><br>";
			}
		$("#tagList").html(text);
		};
	});
});

function clickEvent(value) {
	$("#hashtagInput").val(value);
	opener.document.getElementById("hashtagText").value += " ";
	opener.document.getElementById("hashtagText").value += $("#hashtagInput").val();
	self.close();
}
