var googleUser = {};
var startApp = function() {
	gapi.load('auth2', function(){
		auth2 = gapi.auth2.init({
			client_id: '151296050428-7up6bf2212jt0j9n3qeqm01b6r01q6ed.apps.googleusercontent.com',
			cookiepolicy: 'single_host_origin',
		});
		attachSignin(document.getElementById('customBtn'));
	});
};

function attachSignin(element) {
	console.log(element.id);
    auth2.attachClickHandler(element, {},
    function(googleUser) {
    	signIn("google", googleUser.getBasicProfile().getEmail());
    }, function(error) {
    	alert(JSON.stringify(error, undefined, 2));
    });
}

w3IncludeHTML();

Kakao.init('a2df2dc9167541f9eb937ed24a7e8133');

function loginWithKakao() {
	// 로그인 창을 띄웁니다.
	Kakao.Auth.login({
		success : function(authObj) {
		
		Kakao.Auth.setAccessToken(authObj.access_token);
		
		Kakao.API.request({
			url : '/v1/user/me',
			success : function(res) {
	
				swal({
					title: "사용자 정보 입력",
					text: "사용자 계정 정보를 입력해주세요:",
					type: "input",
					showCancelButton: true,
					closeOnConfirm: false,
					animation: "slide-from-top",
					inputPlaceholder: "사용자계정"
				},
				function(inputValue){
					if (inputValue === false) return false;
  
					if (inputValue === "") {
						swal.showInputError("You need to write email!");
				      		return false
				    	}
				    	
				    	signUp(inputValue, res.id);
				    	
				    	
					});
					
					
				},
				fail : function(error) {
					alert(JSON.stringify(error));
				}
			});
		},
		fail : function(err) {
			alert(JSON.stringify(err));
		}
	});
};

function signIn(type, key) {
	
	var dataObj;
	if(type=="kakao") {
		dataObj = {"userKey":key}
	}
	if(type=="google") {
		dataObj = {"userId":key}
	}

	$.ajax({
		url : "../../user/signIn.do",
		data : dataObj,
		dataType : "json",
		type: "post"
	}).done(function(msg) {

		if (msg == "SIGNUP") {
			// 아직 회원이 아니라면 회원가입 
			signUp(key, "");
		}
  
		swal("Success!", "로그인에 성공하였습니다.", "success");
		
		timer = setInterval(function () {
			if(timer != null) location.href="../../view/main/main.html";		    	
		    		timer = null;
	    }, 2500);
		
	});
}

function signUp(email, key) {

	$.ajax({
		url : "../../user/signUp.do",
		data : {
			"userId": email,
			"userKey": key
		},
		dataType : "json",
		type: "post"
	}).done(function(msg) {

		if (msg == "LOGIN") {
			swal("Info!", email + " 계정으로 이미 가입되었습니다.");
		return false;
		}
	
		swal("Success!", email + " 계정으로 회원가입 되었습니다.");
		
		timer = setInterval(function () {
			if(timer != null) location.href="../../view/main/main.html";		    	
		    		timer = null;
	    }, 2500);
	});
}

startApp();