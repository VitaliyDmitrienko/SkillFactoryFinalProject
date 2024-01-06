package org.example.exception;

public class UserNotFoundException2 extends RuntimeException {

//        private static final long serialVersionUID = 1L;
        public UserNotFoundException2(String msg) {
            super(msg);
        }
    }