$(document).ready(function(){
    $('#login').submit( function(event)
    {
        $(".error").remove();
        var loginData = {
            login: $("#login-login").val(),
            password: $("#password-password").val(),
        };

        $.post(
            "/login",
            loginData,
            func,
            "json"
        );

        function func(responseData)
        {
            console.log(responseData);
            if (!responseData.success) {
                if(responseData.errors.loginEmpty) {
                    $("#login-from-login-form").append(
                        '<div class="error">' + responseData.errors.loginEmpty + '</div>'
                    )
                } if(responseData.errors.passwordEmpty) {
                    $("#password-from-login-form").append(
                        '<div class="error">' + responseData.errors.passwordEmpty + '</div>'
                    )
                } if(responseData.errors.passwordTooShort) {
                    $("#password-from-login-form").append(
                        '<div class="error">' + responseData.errors.passwordTooShort + '</div>'
                    )
                }
            } else {
                window.location.href = "/profile?id=" + responseData.loggedUserId;
            }
        }
        event.preventDefault();
    });
});