/**
 * 
 */

// 지도 관련 스크립트 

var latitude;
var longitude;

function getLocation() {
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(showPosition, showError);
	}
	else {
		x.innerHTML = "Geolocation is not supported by this browser.";
	}
}

function showPosition(position) {
	latitude = position.coords.latitude;
	longitude = position.coords.longitude;
	initMap();

	/*
	x.innerHTML = "Latitude: " + position.coords.latitude + "<br>Longitude: " + position.coords.longitude;
	var locations = [['center', position.coords.latitude, position.coords.longitude], ['friends1', 37.4938, 127.023], ['friends2', 37.4921, 127.026]];
	var mapOptions = {
		zoom: 13,
		center: new google.maps.LatLng(position.coords.latitude, position.coords.longitude)
	};
	var map = new google.maps.Map(document.getElementById("mapDiv"), mapOptions);
	for (i = 0 ; i < locations.length ; i++) {
		var myLatLng = new google.maps.LatLng(locations[i][1], locations[i][2]);
		var marker = new google.maps.Marker({
			position: myLatLng,
			map : map,
			title : locations[i][0]
		});
		marker.setMap(map);
	}
	*/
	// To add the marker to the map, call setMap();
}

function showError(error) {
	switch (error.code) {
		case error.PERMISSION_DENIED :
			x.innerHTML = "User denied the request for Geolocation."
			break;
		case error.POSITION_UNAVAILABLE :
			x.innerHTML = "Location information is unavailable."
			break;
		case error.TIMEOUT :
			x.innerHTML = "The request to get user location timed out."
			break;
		case error.UNKNOWN_ERROR :
			x.innerHTML = "An unknown error occurred."
			break;
	}
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
		console.dir(marker.getPosition());
	});
}

