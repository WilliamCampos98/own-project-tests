package com.boot.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.boot.entities.Users;
import com.boot.repo.UserRepo;

//componente donde agregaremos informacion adicional a los tokens
//por medio de un hashMap para esto consultamos el usuario que trae el
//authentication manager y le colocamos la informacion
@Component
public class InfoAditionalToken implements TokenEnhancer {

	private Map<String, Object> info;

	@Autowired
	private UserRepo repo;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		try {
			info = new HashMap<String, Object>();
			Users user = repo.findByUser(authentication.getName());
			info.put("Empresa", "I-Strategies");
			info.put("user_name", user.getId() + ": " + user.getUser());
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
			return accessToken;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
