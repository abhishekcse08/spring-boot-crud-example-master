package com.magnus.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private double price;
}

/*
    CREATE DATABASE TICKET;
    USE TICKET;
    CREATE TABLE PRODUCT_TBL (id int,name varchar(255),quantity int,price decimal(10,2));
    insert into PRODUCT_TBL values (001,'JHON',12,40.39);
    DROP TABLE PRODUCT_TBL;

);*/
