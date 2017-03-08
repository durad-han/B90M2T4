//----- 카드 정보 받아오기 -------------------------------------------------------------------
function cardListSet(){
		$.ajax({
			url: "/b90m2t4/card/retrieveList.json",
			type: "POST",
			dataType: "json"
		})
		.done(makeCardList);
	}

//----- 카드 리스트 출력 -------------------------------------------------------------------
function makeCardList(cardListMap){
	var html = "";
	var cards = cardListMap['cardList'];
	var page = cardListMap['pageResult'];
	
	for (var i = 0 ; i < cards.length ; i++ ){
		html = "";
		html += '<div class="cardSheet">';
		var card = cards[i];
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
		html += '</div>';
		
		switch(i){
			case 0: $("#card1").html(html); break;
			case 1: $("#card2").html(html); break;
			case 2: $("#card3").html(html); break;
		}
	}
	
	if (cards == null){
		html += '<div class="card">';
		html += '등록된 카드가 없습니다 <br><br>';
		html += '<button>카드 등록하기?<button>';
		html += '</div>';
		$("#card1").html(html);
	}
		
	var paging = "";
		if(page.endPage == 1){
			$("#cardListPage").html('<a href="#여기엔_페이지가_하나밖에_없다" class="w3-bar-item w3-button w3-hover-black">1</a>');
		}else{
			paging += '<a href="javascript:goPage(prev);" class="w3-bar-item w3-button w3-hover-black">«</a>';
			for(var i = 1 ; i <= page.endPage ; i++){
				paging += '<a href="javascript:goPage('+i+');" class="w3-bar-item w3-black w3-button">'+i+'</a>';
			}
			paging += '<a href="javascript:goPage(next);" class="w3-bar-item w3-button w3-hover-black">»</a>';
			$("#cardListPage").html(paging);
		}
}

//----- 카드 페이지 이동 -------------------------------------------------------------------
function goPage(page){
	$.ajax({
		url: "/b90m2t4/card/retrieveList.json",
		type: "POST",
		data: {
			pageNo: page
		},
		dataType: "json"
	})
	.done(makeCardList);
}
	
 cardListSet();