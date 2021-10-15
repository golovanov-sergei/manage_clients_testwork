package com.manage_clients_testwork.exceptionhandler;

public class ClientSaveException extends RuntimeException{
        public ClientSaveException(String message) {
            super(message);
        }
}
