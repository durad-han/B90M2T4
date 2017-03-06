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