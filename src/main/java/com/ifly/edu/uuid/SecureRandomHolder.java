package com.ifly.edu.uuid;


import java.security.SecureRandom;

class SecureRandomHolder {
    public static final SecureRandom INSTANCE = new SecureRandom();

    SecureRandomHolder() {
    }
}
