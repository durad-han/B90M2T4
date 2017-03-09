
$(function() {
	var distance = 200;
	var z = 18;
	var rad = 200;
	
	var p = document.getElementById("markerRange");
    res = document.getElementById("distanceResult");
	
	p.addEventListener("input", function() {
		
		var unit = "m";
		var val = p.value;
		
		distance = p.value;
		
		if(p.value == "1000") {
			unit = "km";
			val = "1";
		}
		
	    res.innerHTML = val + unit;
	    markerInitMap();
	}, false); 
	
	// 지도 관련 스크립트 
	function markerInitMap() {
	 
	  if(distance == "200") {
		  rad = 200;
		  z = 19;
	  } else if(distance == "400") {
		  rad = 400;
		  z = 18;
		  
	  } else if(distance == "600") {
		  rad = 600;
		  z = 17;
	  } else if(distance == "800") {
		  rad = 800;
		  z = 16;
	  } else {
		  rad = 1000;
		  z = 15;
	  }
		
	  var markerMap = new google.maps.Map(document.getElementById('markerMap'), {
	    zoom: z,
	    center: {lat: 37.4944104, lng: 127.0279339}
	  });
	  
	//원 그리기
	  var markerpopulationOptions = {
	          strokeColor: '#000000',
	          strokeOpacity: 0.5,
	          strokeWeight: 2,
	          fillColor: '#808080',
	          fillOpacity: 0.1,
	          map: markerMap,
	          center: {lat: 37.4944104, lng: 127.0279339},
	          radius: rad
	          };
	  cityCircle = new google.maps.Circle(markerpopulationOptions);
	  
	  var secretMessages = ['#안녕 #하이 #방가', '#', 'the', 'secret', 'message'];
	  var latSpan = 37.4944104;
	  var lngSpan = 127.0279339;
	  for (var i = 0; i < secretMessages.length; ++i) {
		  latSpan += 0.0005;
		  lngSpan += 0.0005;
	    var marker2 = new google.maps.Marker({
	      position: {
	        /*lat: latSpan * Math.random(),
	        lng: lngSpan * Math.random()*/
	        lat: latSpan,
	        lng: lngSpan
	      },
	      map: markerMap
	    });
	    attachSecretMessage(marker2, secretMessages[i]);
	  }
	}
	
	
	function attachSecretMessage(marker2, secretMessage) {
	  var infowindow = new google.maps.InfoWindow({
	    content: secretMessage
	  });
	
	  marker2.addListener('click', function() {
	    infowindow.open(marker.get('markerMap'), marker2);
	  });
	}
	
	markerInitMap();
})

