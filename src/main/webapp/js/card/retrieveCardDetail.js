//----- 카드 정보 받아오기 -------------------------------------------------------------------
function cardSet(){
	$.ajax({
		url: "/b90m2t4/card/retrieve.json",
		type: "POST",
		data: {cardSeq: cardNo },
		dataType: "json"
	})
	.done(makeCard);
}

//----- 카드 출력 -------------------------------------------------------------------
function makeCard(card){
	var html = "";
	html += '<div class="card">';
	html += card.cardContent + '<br><br>';
	html += card.cardHashtag + '<br><br>';
	
	var feeling = "";
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
	
	commentSet();
}
	
//----- 카드 정보 받아오기 -------------------------------------------------------------------
function commentSet(){
	console.log(cardNo+"번 코멘트 가져와 ");
	$.ajax({
		url: "/b90m2t4/card/retrieveCommentList.json",
		type: "POST",
		data: {	cardSeq: cardNo },
		dataType: "json"
	})
	.done(makeComment);
}


// ------------------------------------------------------------------------------------------

function makeComment(commentMap){
	console.log("코멘트 go!")
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
	console.log("코멘트 길이 : "+comments.length);
	if (comments.length == 0){
		console.log("길이가 0 일 경우");
		html = '<div class="comment">';
		html += '아무도 이 카드에 반응하지 않았습니다 <br><br>';
		html += '<button>첫 댓글 남기기<button>';
		html += '</div>';
		
	}
	console.log("코멘트 입력");
		$("#commentArea").html(html);
		$("#commentCount").html(page.count);
		
		console.log("코멘트 페이징 시작");
		var paging = "";
		if(page.endPage == 1){
			console.log("페이지가 한개야");
			$("#commentPagingArea").html('<a href="#여기엔_페이지가_하나밖에_없다" class="w3-bar-item w3-button w3-hover-black">1</a>');
		}else{
			console.log("페이징 작업 시작");
			paging += '<a href="javascript:goCommentPage(prev);" class="w3-bar-item w3-button w3-hover-black">«</a>';
			for(var i = 1 ; i <= page.endPage ; i++){
				console.log("페이징 반복 작업중");
				paging += '<a href="javascript:goCommentPage('+i+');" class="w3-bar-item w3-black w3-button">'+i+'</a>';
			}
			paging += '<a href="javascript:goCommentPage(next);" class="w3-bar-item w3-button w3-hover-black">»</a>';
			$("#commentPagingArea").html(paging);
		}	
}

//----- 코멘트 페이지 이동 ------------------------------------------------------------------------------------------
function goCommentPage(cPage) {
	$.ajax({
		url: "/b90m2t4/card/retrieveCommentList.json",
		type: "POST",
		data: {	cardSeq: cardNo,
				pageNo: cPage
				},
		dataType: "json"
	})
	.done(makeComment);
}
//----- 코멘트 등록 ------------------------------------------------------------------------------------------
$("#commentInsert").submit(function commentInsertForm() {
	window.open("insertCommentForm.html", "", "width=500, height=250, resizable=yes, scrollbars=yes, status=no");
});

cardSet();