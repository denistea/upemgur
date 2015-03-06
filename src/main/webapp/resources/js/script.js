$(document).ready(function(){
    $(".image-container").justifiedGallery({
        rowHeight : 200,
        margins : 3,
        fixedHeight : true,
        captionSettings : { animationDuration : 100,
                            visibleOpacity : 0.7,
                            nonVisibleOpacity : 0.0}
    });
    
    $("#subscriptionForm\\:inputEmail").keyup(checkEmail);
    $("#subscriptionForm\\:inputLogin").keyup(checkLogin);
    //$("#inputPassword").blur(checkPassword());
    $("#subscriptionForm\\:inputPassword").keyup(checkPassword);
    $("#subscriptionForm\\:confirmPassword").keyup(checkPassword);
});

function checkEmail() {
    if(validEmail($("#subscriptionForm\\:inputEmail").val())) {
        $("#subscriptionForm\\:inputEmail").parent().removeClass("has-error");
        //$("#badEmail").addClass("sr-only");
    }
    else {
        $("#subscriptionForm\\:inputEmail").parent().addClass("has-error");
        //$("#badEmail").removeClass("sr-only");
    }
}

function checkLogin() {
    var re= /^[^\W\d_]\w*$/;
    if(($("#subscriptionForm\\:inputLogin").val().length >= 3)
            && (re.test($("#subscriptionForm\\:inputLogin").val()) )) {
        $("#subscriptionForm\\:inputLogin").parent().removeClass("has-error");
        //$("#badLogin").addClass("sr-only");
    }
    else {
        $("#subscriptionForm\\:inputLogin").parent().addClass("has-error");
        //$("#badLogin").removeClass("sr-only");
    }
}

function checkPassword() {
    if(($("#subscriptionForm\\:inputPassword").val() == $("#subscriptionForm\\:confirmPassword").val())
            &&($("#subscriptionForm\\:inputPassword").val().length >= 4)) {
        $("#subscriptionForm\\:inputPassword").parent().removeClass("has-error");
        $("#subscriptionForm\\:confirmPassword").parent().removeClass("has-error");
    }
    else {
        $("#subscriptionForm\\:inputPassword").parent().addClass("has-error");
        $("#subscriptionForm\\:confirmPassword").parent().addClass("has-error");
    }
}

function checkInscription() {
    var validForm = false;

}

function validEmail(email) { 
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
} 

function reload() {
    $(".image-container").justifiedGallery({
        rowHeight : 200,
        margins : 3,
        fixedHeight : true,
        captionSettings : { animationDuration : 0,
                            visibleOpacity : 0.7,
                            nonVisibleOpacity : 0.0}
    });
}