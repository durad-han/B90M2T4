$(function (result) {
    $.ajax({
        type: "POST",
        url: "/b90m2t4/my/myFavoriteList.do",
        dataType: "json",
        data: {
			userSeq: 2
		}
        
    }).done(function (result) {
        boardList(result)
    });
});

function boardList(result) {
	$("#favoriteList").css("display", "block");	
	$("#favoritePage").css("display", "block");	
	$("#favoriteDetail").css("display", "none");	
	
    html = "";
    html += "<table border='1'>";
    html += "<tr>";
    html += "<th>글번호</th>";
    html += "<th>해시태그</th>";
    html += "<th>기분</th>";
    html += "<th>등록 시각</th>";
    html += "</tr>";
    
    for (var i = 0 ; i < result.list.length ; i++) {
    	var favoriteFeelImg;
    	switch(result.list[i].myFeeling) {
    		
    		case "1" : favoriteFeelImg="../../img/card/verygood.jpg";
    			break;
    		
    		case "2" : favoriteFeelImg="../../img/card/good.png";
    			break;
    		
    		case "3" : favoriteFeelImg="../../img/card/soso.png";
    			break;
    		
    		case "4" : favoriteFeelImg="../../img/card/bad.png";
    			break;
    		
    		case "5" : favoriteFeelImg="../../img/card/terrible.png";
    			break;
    		
    	}
    	
    	
    	
        html += "<tr>";
        html += "<td>" + result.list[i].mySeq + "</td>";
        html += "<td><a href='javascript:detail("+ result.list[i].mySeq +")'>" + result.list[i].myHashtag + "</a></td>";
        html += "<td><img src='"+ favoriteFeelImg +"'></img></td>";
        html += "<td>" + result.list[i].myRegDate + "</td>"; 
        html += "</tr>";
    }
    html += "</table>"
        $("#favoriteList").html(html);
    
    
    var paging = "";
	if(result.pageResult.endPage == 1){
		$("#myFavoritePage").html('<a href="#여기엔_페이지가_하나밖에_없다" class="w3-bar-item w3-button w3-hover-black">1</a>');
	}else{
		paging += '<a href="javascript:goPage(prev);" class="w3-bar-item w3-button w3-hover-black">«</a>';
		for(var i = 1 ; i <= result.pageResult.endPage ; i++){
			paging += '<a href="javascript:goPage('+i+');" class="w3-bar-item w3-black w3-button">'+i+'</a>';
		}
		paging += '<a href="javascript:goPage(next);" class="w3-bar-item w3-button w3-hover-black">»</a>';
		$("#myFavoritePage").html(paging);
	}
    
}



function detail(seq) {
	
	$("#favoriteList").css("display", "none");	
	$("#favoritePage").css("display", "none");	
	$("#favoriteDetail").css("display", "block");	
	
	$.ajax({
		type: "POST",
		url: "/b90m2t4/my/myFavoriteDetail.do",
		dataType: "json",
		data: {
			mySeq: seq
		}
	
	}).done(function (result) {
        boardDetail(result)
    });
}

function boardDetail(result) {
	
	$("#favoriteNo").html(result.mySeq);
	$("#favoriteTag").html(result.myHashtag);
	$("#favoriteContent").html(result.myContent);
	$("#favoriteFeeling").html(result.myFeeling);
	$("#favoriteDate").html(result.myRegDate);
	
	
	html += "<td>" + result.mySeq + "</td>"; 
    html += "<td>" + result.myHashtag + "</td>";
    html += "<td>" + result.myContent + "</td>";
    html += "<td>" + result.myFeeling + "</td>";
   
};



$("#btnMod").click(function() {
	
	$("#content").html();
	
	
	$.ajax({
		type: "POST",
		url: "/b90m2t4/my/myFavoriteUpdate.do",
		dataType: "json",
		data: {
			mySeq: mySeq,
			myContent: myContent,
			myHashtag: myHashtag,
			myFeeling: myFeeling
		
		}
	
	}).done(function (msg) {
		alert(msg);
    });
})



$("#btnDel").click(function() {
	$.ajax({
		type: "POST",
		url: "/b90m2t4/my/myFavoriteDelete.do",
		dataType: "json",
		data: {
			mySeq: mySeq,
			userSeq: userSeq,
			myContent: myContent,
			myHashtag: myHashtag,
			myFeeling: myFeeling,
			myRegDate: myRegDate
		}
	
			
	}).done(function (msg) {
		alert(msg);
    });
})
