package com.talanlabs.rsqlbuilder.test;

import com.talanlabs.rsqlbuilder.RsqlBuilder;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainRsqlBuilder {

    public static void main(String[] args) {
        System.out.println(RsqlBuilder.rsql().bool("name").isTrue().query());
        System.out.println(RsqlBuilder.rsql().string("name").neq("t'es là").query());
        System.out.println(RsqlBuilder.rsql().string("name").eq("gaby").and().openGroup().intNum("age").gt(20).or().intNum("age").lte(40).closeGroup().query());

        System.out.println(RsqlBuilder.rsql().temporal("date").after(LocalDate.now(), true).query());
        System.out.println(RsqlBuilder.rsql().temporal("date").before(LocalDateTime.now(), false).query());
        System.out.println(RsqlBuilder.rsql().temporal("date").after(LocalTime.now(), false).query());
        System.out.println(RsqlBuilder.rsql().temporal("date").after(Instant.now(), false).query());
    }
}
