package com.springboot.hello1.parser;

public interface Parser <T> {
    T parse(String str);
}
