//----- 카드 정보 받아오기 -------------------------------------------------------------------
function cardListSet(){
	console.log("? " + distance)
		$.ajax({
			url: "/b90m2t4/card/retrieveList.json",
			type: "POST",
			dataType: "json",
			data: {distance: distance}
		})
		.done(makeCardList);
}
//----- 카드 리스트 출력 -------------------------------------------------------------------
function makeCardList(cardListMap){
	var html = "";
	var cards = cardListMap['cardList'];
	var page = cardListMap['pageResult'];
	
	for (var i = 0 ; i < cards.length ; i++ ){
		var card = cards[i];
		arrCard.push({
			lat: card.cardLatitude,
			log: card.cardLongitude,
			tag: card.cardHashtag
		});
		html = "";
		html += '<div class="cardSheet" id="cardSeq'+card.cardSeq+'">';
		html += '<span id="cardContent">'+ card.cardContent + '</span><br><br>';
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
			case 0: $("#card1").html(html);
						var card1 = card.cardSeq;
					$("#card1").on("click", function(){
						cardNo = card1;
						$("#cardList").load("../card/retrieveCardDetail.html?cardSeq="+card1);
					}); break;
			case 1: $("#card2").html(html);
						var card2 = card.cardSeq;
					$("#card2").on("click", function(){
						cardNo = card2;
						$("#cardList").load("../card/retrieveCardDetail.html?cardSeq="+card2);
					}); break;
			case 2: $("#card3").html(html);
						var card3 = card.cardSeq;
					$("#card3").on("click", function(){
						cardNo = card3;
						$("#cardList").load("../card/retrieveCardDetail.html?cardSeq="+card3);
					}); break;
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
//----- 거리 계산 -------------------------------------------------------------------
function computeDistance(startCoords, destCoords) {
	var startLatRads  = degreesToRadians(startCoords.latitude );
	var startLongRads = degreesToRadians(startCoords.longitude);
	var destLatRads   = degreesToRadians(37.4944104 );
	var destLongRads  = degreesToRadians(127.0279339);

	var Radius = 6371; // radius of the Earth in km
	var distance = Math.acos(
			       		Math.sin(startLatRads) * Math.sin(destLatRads) + 
			       		Math.cos(startLatRads) * Math.cos(destLatRads) *
			       		Math.cos(startLongRads - destLongRads)
			       ) * Radius;

	return distance;
}
function degreesToRadians(degrees) {
	radians = (degrees * Math.PI) / 180;
	console.log(degrees  + " - " + (degrees * Math.PI) + " - " + radians);
	return radians;
}
 cardListSet();
