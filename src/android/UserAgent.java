package de.fastr.phonegap.plugins;

import java.util.Set;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaPlugin;

import android.webkit.WebSettings;
import android.webkit.WebView;

import org.json.JSONArray;
import org.json.JSONException;


public class UserAgent extends CordovaPlugin {
	//private CordovaInterface cordova;
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
		//this.cordova = cordova;
		this.setUserAgent();
  }
	private void setUserAgent(){
    WebView view = (WebView) this.webView.getView();
    WebSettings settings = view.getSettings();

    String originalUserAgent = settings.getUserAgentString();
		String newUserAgent = "";

		String configUserAgent = cordova.getActivity().getIntent().getStringExtra("useragent-android");
		String configUserAgentAppend = cordova.getActivity().getIntent().getStringExtra("useragent-android-append");

		if (configUserAgent != null){
			newUserAgent = configUserAgent;	
		}else{
			newUserAgent = originalUserAgent;
		}

		if (configUserAgentAppend != null){
			newUserAgent = newUserAgent + configUserAgentAppend;
		}
		settings.setUserAgentString(newUserAgent);
	}
}
