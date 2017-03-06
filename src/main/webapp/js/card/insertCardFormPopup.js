/**
 * 
 */

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
				text += list[i].hashtagContent + "<br>";
			}
		$("#tagList").html(text);
		};
	});
});
