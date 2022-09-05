package com.itmo.lab3.model.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public enum Color {
    BLACK("black"), RED("red"), GREEN("green"),
    WHITE("white");

    String value;
}