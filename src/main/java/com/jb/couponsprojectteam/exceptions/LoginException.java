package com.jb.couponsprojectteam.exceptions;

import com.jb.couponsprojectteam.beans.ClientType;

public class LoginException extends Exception {

    public LoginException(String message) {
        super(message);
    }

    public LoginException(ClientType clientType) {
        super("Invalid login " + clientType.toString());
    }

}
