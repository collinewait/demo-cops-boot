package com.example.wait.democopsboot.infrastructure.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "copsboot-security")
public class SecurityConfiguration {
	private String mobileAppClientId = "copsboot-mobile-client";
	private String mobileAppClientSecret = "ccUyb6vS4S8nxfbKPCrN";

	public String getMobileAppClientId() {
		return mobileAppClientId;
	}

	public void setMobileAppClientId(String mobileAppClientId) {
		this.mobileAppClientId = mobileAppClientId;
	}

	public String getMobileAppClientSecret() {
		return mobileAppClientSecret;
	}

	public void setMobileAppClientSecret(String mobileAppClientSecret) {
		this.mobileAppClientSecret = mobileAppClientSecret;
	}
}
