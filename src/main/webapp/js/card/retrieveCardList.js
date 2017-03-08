/**
 * 	src/main/webapp/view/card/retrieveCardDetail.html
 */
console.log("카드js펑");
//$(function() {
function cardListSet(){
		console.log("카드만들기 시도");
		$.ajax({
			url: "/b90m2t4/card/retrieveList.json",
			type: "POST",
			dataType: "json"
		})
		.done(makeCardList);
	}
	//----- 카드 리스트 작성중 -------------------------------------------------------------------
	function makeCardList(cardListMap){
		console.log("카드 작성");
		var html = "";
		var cards = cardListMap['cardList'];
		var page = cardListMap['pageResult'];
		// 디버그용 console.dir
		console.dir(cards);
		console.dir(page);
		
		for (var i = 0 ; i < cards.length ; i++ ){
			html += '<div class="card">';
			var card = cards[i];
			html += card.commentContent + '<br><br>';
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
				
			html += card.commentRegDate + '<br><br>';
			html += '</div>';
	// 		$("#card"+i).html(html);
			$("#card1").html(html);
		}
		
		if (cards == null){
			html += '<div class="card">';
			html += '등록된 카드가 없습니다 <br><br>';
			html += '<button>카드 등록하기?<button>';
			html += '</div>';
			$("#card1").html(html);
			
		}
	}
	
//});

 cardListSet();