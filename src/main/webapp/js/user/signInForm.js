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
    	easySign("google", googleUser.getBasicProfile().getEmail());
    }, function(error) {
    	alert(JSON.stringify(error, undefined, 2));
    });
}

w3IncludeHTML();


startApp();


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
				    	
						easySign("kakao", inputValue, res.id);
				    	
				    	
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


/*
 * type : 간편 로그인 종류(kakao, google)
 * id : email계정
 * key: 카카오에서 주는 key값
 * */
function easySign(type, id, key) {
	
//	if(key == undefined) key = "NULL";
	
	$.ajax({
		url : "../../user/easySign.do",
		data : {
			type : type,
			userId : id,
			userKey: key
		},
		dataType : "json",
		type: "post"
	}).done(function(result) {
		
		var msg;
		var opt;
		var title;

		if(result.msg == "signUp") {
			
			msg = "회원가입에 성공하였습니다.";
			opt = "success";
			title = "Success!";
			
			localStorage.setItem("id", id);
			localStorage.setItem("key", key);
			
		} else if (result.msg == "info") {
			msg = "사용중인 계정은 "+ result.user.userId +" 입니다. 다시 입력해주세요."
			opt = "fail";
			title = "Info";
			
		} else {
			
			msg = "로그인에 성공하였습니다.";
			opt = "success";
			title = "Success!";
			
			localStorage.setItem("id", id);
			localStorage.setItem("key", key);
		}
		
		// 로그인 또는 회원가입
		if(result.msg != "info") {
			
			swal(title, msg, opt);
			
			timer = setInterval(function () {
				if(timer != null) location.href="../../view/main/main.html";		    	
			    		timer = null;
		    }, 2500);
			
		// 카카오 로그인의 경우 회원가입된 계정과 동일해야 로그인 성공!
		} else {
			swal.showInputError(msg);
		}
		
	});
}