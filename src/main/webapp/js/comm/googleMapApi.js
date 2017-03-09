// 지도 관련 스크립트 

var latitude = 37.4944104;
var longitude = 127.0279339;

$(function() {
	initMap();
})
/*
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition, showError);
    }
    else {
    	mapDiv.innerHTML = "Geolocation is not supported by this browser.";
    }
}


function showPosition(position) {
    latitude = position.coords.latitude;
    longitude = position.coords.longitude;
    initMap();

}

function showError(error) {
    switch (error.code) {
        case error.PERMISSION_DENIED :
        	mapDiv.innerHTML = "User denied the request for Geolocation."
            break;
        case error.POSITION_UNAVAILABLE :
        	mapDiv.innerHTML = "Location information is unavailable."
            break;
        case error.TIMEOUT :
        	mapDiv.innerHTML = "The request to get user location timed out."
            break;
        case error.UNKNOWN_ERROR :
        	mapDiv.innerHTML = "An unknown error occurred."
            break;
    }
}

*/
/**
 *  출발지와 목적지의 거리를 km로 반환
 *  구면 코사인 법칙 : 구면 삼각법
 */
function computeDistance(startCoords, destCoords) {
	var startLatRads  = degreesToRadians(startCoords.latitude );
	var startLongRads = degreesToRadians(startCoords.longitude);
	var destLatRads   = degreesToRadians(destCoords.latitude  );
	var destLongRads  = degreesToRadians(destCoords.longitude );

	var Radius = 6371; // radius of the Earth in km
	var distance = Math.acos(
			       		Math.sin(startLatRads) * Math.sin(destLatRads) + 
			       		Math.cos(startLatRads) * Math.cos(destLatRads) *
			       		Math.cos(startLongRads - destLongRads)
			       ) * Radius;

	return distance;
}
/**
 *  1(라디안) = 180 / Math.PI, 1(degree) = Math.PI / 180
 *  반지름이 1일 경우 원의 전체 둘레 : 2 * Math.PI
 */
function degreesToRadians(degrees) {
	radians = (degrees * Math.PI) / 180;
	console.log(degrees  + " - " + (degrees * Math.PI) + " - " + radians);
	return radians;
}



// 지도 소환
function initMap() {

    var myLatlng = {
        lat : latitude,
        lng : longitude
    };
    var map = new google.maps.Map(document.getElementById('mapDiv'), {
        zoom : 15,
        center : myLatlng
    });
    var marker = new google.maps.Marker({
        position : myLatlng,
        map : map,
        title : 'Click to zoom'
    });

    
    // 원 그리기
    var populationOptions = {
            strokeColor: '#000000',
            strokeOpacity: 0.5,
            strokeWeight: 2,
            fillColor: '#808080',
            fillOpacity: 0.1,
            map: map,
            center: myLatlng,
            radius: 1000
            };
    cityCircle = new google.maps.Circle(populationOptions);
    
    // 마커 클릭시 좌표 반환
    marker.addListener('click', function() {
    	alert("포지션값 : " + marker.getPosition());
    	alert("포지션값 : " + marker.getPosition());
        
        console.dir(marker.getPosition());
    });
}
