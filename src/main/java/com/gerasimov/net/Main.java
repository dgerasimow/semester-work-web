package com.gerasimov.net;

import com.gerasimov.net.helper.PasswordHelper;

public class Main {
    public static void main(String[] args) {
        System.out.println(PasswordHelper.encrypt("password"));
        System.out.println(PasswordHelper.encrypt("password"));
    }
}
