package com.example.demo.sqls;

public class DemoSqls {
    public static final String FIND_BY_ENO = "SELECT * FROM sample WHERE eno = :eno";

    public static final String GET_STOCK_PRICE_BY_BRC = "" +
            "SELECT * " +
            "FROM sample " +
            "WHERE brc = :brc";
}
