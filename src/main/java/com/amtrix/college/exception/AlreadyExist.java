package com.amtrix.college.exception;

public class AlreadyExist extends RuntimeException{
    public AlreadyExist(String name) {
        super(name);
    }
}
