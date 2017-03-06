/**
 * 
 */
// 글자수 제한 및 글자수 표시
		$(document).ready(function () {
			$('#textarea').on('keyup', function () {
				if($(this).val().length > 140) {
					alert('글자수는 140자 까지입니다.');
					$(this).val($(this).val().substring(0, 140));
				}
				$('#count').html($(this).val().length + '/140');
			});
		});
		
		function popupOpen() {
			var popUrl = "insertCardFormPopup.html";
			var popOption = "width=400, height=200, resizable=yes, scrollbars=yes, status=no";
				window.open(popUrl, "", popOption);
		}
		
		
		
	/*	
		
		// 지도 관련 스크립트 
		
		
		// 	var x = document.getElementById("MyCurrentPosition");
		var latitude;
		var longitude;
		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(showPosition, showError);
			} else {
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		}

		function showPosition(position) {

			latitude = position.coords.latitude;
			longitude = position.coords.longitude;

			initMap();

			
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

// 			map.addListener('center_changed', function() {

// 				// 3 seconds after the center of the map has changed, pan back to the
// 				// marker.
// 				window.setTimeout(function() {
// 					map.panTo(marker.getPosition());
// 				}, 3000);
// 			});

			marker.addListener('click', function() {
// 				map.setZoom(8);
				alert("포지션값 : " + marker.getPosition());
				
			});
		}
		*/