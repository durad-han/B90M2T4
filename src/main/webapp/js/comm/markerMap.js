var z = 19;
var rad = 200;
var distance = 200;
var arrCard = [];

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
    cardListSet()
}, false); 

function markerInitMap() {
	
  switch(distance) {
    case "200": 
	  rad = 200; z = 19; break;
    case "400": 
    	rad = 400; z = 18; break;
    case "600": 
    	rad = 600; z = 17; break;
    case "800": 
    	rad = 800; z = 16; break;
    case "1000": 
    	rad = 1000; z = 15; break;
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
  if(arrCard) {
	  for (var i = 0; i < arrCard.length; ++i) {
		  console.dir(arrCard[i])
		  var marker2 = new google.maps.Marker({
	      position: {
	        lat: arrCard[i].lat,
	        lng: arrCard[i].log
	      },
	      map: markerMap
	    });
	    attachSecretMessage(marker2, arrCard[i].tag);
	  }
  }
}


function attachSecretMessage(marker2, secretMessage) {
  var infowindow = new google.maps.InfoWindow({
    content: secretMessage
  });

  marker2.addListener('click', function() {
    infowindow.open(marker2.get('markerMap'), marker2);
  });
}

markerInitMap();

