COMMON_UTILITIES = {
    setCookie: function(c_name, c_value, c_expiry) {
        var d = new Date();
        d.setTime(d.getTime() + (c_expiry * 24 * 60 * 60 * 1000));
        var expires = "expires=" + d.toGMTString();
        document.cookie = c_name + "=" + c_value + "; " + expires + ";domain=;path=/";
    },
    getCookie: function(c_name) {
        //This function retrieves user cookies from the user browser
        var name = c_name + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') c = c.substring(1);
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    },
    deleteCookie: function(c_name) {
        //This function deletes the cookie from the user browser
        document.cookie = c_name + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
    },
    cleanCookie: function(c_name) {
        //This function cleans the cookie to a null entry in the user browser
        setCookie(c_name, '', COOKIE_EXPIREY_90);
    },
    ajaxUrl: function(title, url) {
        if (typeof(history.pushState) != "undefined") {
            var obj = {
                Title: title,
                Url: url
            };
            history.pushState(obj, obj.Title, obj.Url);
        } else {
            alert("Browser does not support HTML5.");
        }
    },
    validateRegisterForm: function(id) {
        jQuery(".err-msg").remove();
        var flag = true;
        if (!jQuery(id + " [name='name']").val()) {
            jQuery(id + " [name='name']").after("<p class='err-msg'>Please enter your name</p>");
            flag = false;
        }
        if (!jQuery(id + " [name='email']").val()) {
            jQuery(id + " [name='email']").after("<p class='err-msg'>Please enter your email id</p>");
            flag = false;
        } else {
            var re = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
            if (!jQuery(id + " [name='email']").val().match(re)) {
                jQuery(id + " [name='email']").after("<p class='err-msg'>Please enter valid email id</p>");
                flag = false;
            }
        }
        if (!jQuery(id + " [name='phone']").val()) {
            jQuery(id + " [name='phone']").after("<p class='err-msg'>Please enter your phone number</p>");
            flag = false;
        }
        return flag;
    }
}

var COMMON_FUNCTIONS = {
    submitToZoho: function() {
        if (COMMON_UTILITIES.validateRegisterForm('#reg-form')) {
            I80_MAIN.postJsonData(I80_HOME_URL + I80_API_FOLDER + I80_ZOHO_UPDATES + INSERT_LEAD_TO_ZOHO, jQuery("#reg-form").serialize(), 'COMMON_FUNCTIONS.submitToZohoAfterResponse');
            jQuery("#register-popup .form-group button").append("<img src='"+I80_HOME_URL+"assets/img/loader_white.gif' alt='' />");
        }
    },
    submitToZohoAfterResponse: function(data) {
        if (data) {
            jQuery('#register-popup').modal('hide');
            jQuery("#thank-you-dialog").modal('show');
            jQuery("#register-popup .form-group button").empty();
            jQuery("#register-popup .form-group button").html("Submit Information");
        }
    },
    openCommonRegisterPopup:function(batch_id,course_id){
		jQuery("#batch-selector").removeClass('hide');
    	if(batch_id){
    		jQuery("#batch-selector").addClass('hide');
    		jQuery("#reg-form select[name='batch']").val(batch_id);

    	}
    	jQuery("#course-selector").removeClass("hide");
    	if(course_id){
    	jQuery("#course-selector").addClass("hide");
		jQuery("#reg-form select[name='course']").val(course_id);
    	}
    	jQuery("#register-popup").modal('show');
    },
    openContactUsDialog:function(){
    	jQuery("#talk-to-us-dialog").modal('show');
    },
    navigateToTheUrl:function(url){
    	location.href=url;
    }
}