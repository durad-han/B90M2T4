/**
 * 
 */
 var googleUser = {};
  var startApp = function() {
    gapi.load('auth2', function(){
      // Retrieve the singleton for the GoogleAuth library and set up the client.
      auth2 = gapi.auth2.init({
        client_id: '151296050428-7up6bf2212jt0j9n3qeqm01b6r01q6ed.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
        // Request scopes in addition to 'profile' and 'email'
        //scope: 'additional_scope'
      });
      attachSignin(document.getElementById('customBtn'));
    });
  };

  function attachSignin(element) {
    console.log(element.id);
    auth2.attachClickHandler(element, {},
        function(googleUser) {
    		signUp(googleUser.getBasicProfile().getEmail());
        }, function(error) {
          alert(JSON.stringify(error, undefined, 2));
        });
  }