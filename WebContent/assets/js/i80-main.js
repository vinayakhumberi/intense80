/*
 * The API Call are made based on the URI's set here
 * Any Changes made here will effect the API call throughout the application
 */
var I80_API='api/';
var I80_API_BUILDER = "?";
var I80_API_PRAM_APPEND = "&api_mode=1";
//API Appends are to be listed here
var I80_API_FOLDER='apis/';
var I80_ZOHO_UPDATES='zoho/';
var INSERT_LEAD_TO_ZOHO='insertLeadsToZoho';
//API default PRAMS passed are to be listed here
var BBGP_STD_DSKTP_WIDTH=1024;
/*
 * The Cookies used in the projects have to be captured
 * The variables declared here are used in the entire project
 */
var I80_MAIN={
	 getJsonData: function(api_url,afterResponse,afterComplete){
		jQuery.ajax({
			type: 'GET',
			url: api_url,
			dataType: 'JSON',
            // username: 'CapriCoast',
            // password: 'CapriCoast',
			success: function(json_data){
				I80_MAIN.callAfterResponseFunction(json_data,afterResponse);
			},
            complete: function(){
                if(afterComplete){
                    I80_MAIN.callAfterResponseFunction(null,afterComplete);
                }
            },
            error: function (event,xhr, ajaxOptions, thrownError) {
                console.error('Unable to reach '+afterResponse+'\n An Event has thrown the following error: '+xhr.status+'--->'+ajaxOptions.message);
            }
		});
	},
	postJsonData: function(api_url,post_data,afterResponse,afterComplete){
		jQuery.ajax({
	        type:'POST',
	        url: api_url,
	        dataType:'JSON',
            data: post_data,
            // username: 'CapriCoast',
            // password: 'CapriCoast',
	        success:function(json_data){
	        	I80_MAIN.callAfterResponseFunction(json_data,afterResponse);
	        },
            complete: function(){
                if(afterComplete){
                    I80_MAIN.callAfterResponseFunction(null,afterComplete);
                }
            },
            error: function (event,xhr, ajaxOptions, thrownError) {
                console.error('Unable to reach '+afterResponse+'\n An Event has thrown the following error: '+xhr.status+'--->'+ajaxOptions.message);
            }
	    });   
	},
 	callAfterResponseFunction: function(data,functionName){
        var fn=functionName.split('.');
		switch(fn[0]){
			case('HOME'):
				HOME[fn[1]](data);
			break;
			case('COURSE'):
                COURSE[fn[1]](data);
			break;
            default:
                COMMON_FUNCTIONS[fn[1]](data);
            break;
		}
	}	
} 