package com.elghallali.ebook.model.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2331161481658560071L;
	
	private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

}
