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
    $("#subscriptionForm\\:inputPassword").keyup(checkPassword);
    $("#subscriptionForm\\:confirmPassword").keyup(checkPassword);
    $("#subscriptionForm\\:subscriptionButton").click(checkInscription);
    
    $("#uploadForm\\:uploadButton").click(checkUpload);
});

function checkEmail() {
    if(validEmail($("#subscriptionForm\\:inputEmail").val())) {
        $("#subscriptionForm\\:inputEmail").parent().removeClass("has-error");
        return true;
    }
    else {
        $("#subscriptionForm\\:inputEmail").parent().addClass("has-error");
        return false;
    }
}

function checkLogin() {
    var re= /^[^\W\d_]\w*$/;
    if(($("#subscriptionForm\\:inputLogin").val().length >= 3)
            && (re.test($("#subscriptionForm\\:inputLogin").val()) )) {
        $("#subscriptionForm\\:inputLogin").parent().removeClass("has-error");
        return true;
    }
    else {
        $("#subscriptionForm\\:inputLogin").parent().addClass("has-error");
        return false;
    }
}

function checkPassword() {
    if(($("#subscriptionForm\\:inputPassword").val() == $("#subscriptionForm\\:confirmPassword").val())
            &&($("#subscriptionForm\\:inputPassword").val().length >= 4)) {
        $("#subscriptionForm\\:inputPassword").parent().removeClass("has-error");
        $("#subscriptionForm\\:confirmPassword").parent().removeClass("has-error");
        return true;
    }
    else {
        $("#subscriptionForm\\:inputPassword").parent().addClass("has-error");
        $("#subscriptionForm\\:confirmPassword").parent().addClass("has-error");
        return false;
    }
}

function checkUpload() {
    var validForm = true;
    
    $("#uploadForm\\:inputTitle").parent().removeClass("has-error");
    
    if(!$("#uploadForm\\:inputImage").val()) {
        validForm = false;
    }
    if(!$("#uploadForm\\:inputTitle").val()) {
        $("#uploadForm\\:inputTitle").parent().addClass("has-error")
        validForm = false;
    }
    
    return validForm;
}

function checkInscription() {
    return (checkEmail() && checkLogin() && checkPassword());
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