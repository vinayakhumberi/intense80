var EVENT_TRACKER={
	setUserTrackingId:function(id){
		mixpanel.identify(id);
	},
	trackEventInMixPanel:function(label,properties) {
			mixpanel.track(label,properties);
	},
	trackEventGoogleAnalytics:function  (label,properties) {
		//code goes here..
	},
	trackEventAndLoadUrl:function (label,prams,redirectUrl,isMixPanel,isGoogleAnalytics,isOpenInNewTab){
		if(!prams){
			prams={};
		}
		if(BB_USER_ID){
			prams['userId']=BB_USER_ID;
		}
		if(BB_USER_EMAIL){
			prams['userEmail']=BB_USER_EMAIL;
		}
		if(isMixPanel){
			EVENT_TRACKER.trackEventInMixPanel(label,prams);
		}
		if(isGoogleAnalytics){
			EVENT_TRACKER.trackEventGoogleAnalytics(label,prams);
		}
		if(redirectUrl!==null){
			setTimeout(function(){window.location.assign(redirectUrl);},300);
		}
	}
}