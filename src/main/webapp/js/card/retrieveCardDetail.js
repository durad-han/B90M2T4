console.log("outer : "+cardNo);
function cardSet(){
	console.log("inner"+cardNo);

	$.ajax({
		url: "/b90m2t4/card/retrieve.json",
		type: "POST",
		data: {cardSeq: cardNo },
		dataType: "json"
	})
	.done(makeCard);
	
	$.ajax({
		url: "/b90m2t4/card/retrieveCommentList.json",
		type: "POST",
		data: {	cardSeq: cardNo,
				pageNo: 1
				},
		dataType: "json"
	})
	.done(makeComment);
}

function makeCard(card){
	var html = "";
		html += '<div class="card">';
		html += card.cardContent + '<br><br>';
		html += card.cardHashtag + '<br><br>';
		
	var feeling = "";
	console.log("cardFeeling : "+card.cardFeeling);
	switch(card.cardFeeling){
	case '1':	feeling = 'verygood.jpg';	break;
	case '2':	feeling = 'good.png';	break;
	case '3':	feeling = 'soso.png';	break;
	case '4':	feeling = 'bad.png';	break;
	case '5':	feeling = 'terrible.png';	break;
	}; 
		html += '<img src="../../img/card/' + feeling + '"/> <br><br>';
		
		html += card.cardRegDate + '<br><br>';
	
	if (card == null){
		html += '카드가 존재하지 않습니다 <br><br>';
	}
	$("#cardHere").html(html);
}

//----- 코멘트 등록 ------------------------------------------------------------------------------------------
$("#commentInsert").submit(function commentInsertForm() {
	window.open("insertCommentForm.html", "", "width=500, height=250, resizable=yes, scrollbars=yes, status=no");
});
// ------------------------------------------------------------------------------------------

function makeComment(commentMap){
	var html = "";
	var comments = commentMap['commentList'];
	var page = commentMap['pageResult'];
	// 디버그용 console.dir
	console.dir(comments);
	console.dir(page);
	
	for (var i = 0 ; i < comments.length ; i++ ){
			html += '<div class="comment">';
			var comment = comments[i];
			html += comment.commentContent + '<br><br>';
			html += comment.commentRegDate + '<br><br>';
			html += '</div>';
	}
	
	if (comments == null){
		html += '<div class="comment">';
		html += '아무도 이 카드에 반응하지 않았습니다 <br><br>';
		html += '<button>첫 댓글 남기기<button>';
		html += '</div>';
		
	}
		$("#commentArea").html(html);
		$("#commentCount").html(page.count);
}

function goPage(pageNo) {
	$.ajax({
		url: "/b90m2t4/card/retrieveCommentList.json",
		type: "POST",
		data: {	cardSeq: 1,
				pageNo: page.pageNo
				},
		dataType: "json"
	})
	.done(makeComment);
}

cardSet();