package com.example.alex.weatherApp;

import com.example.alex.weatherApp.model.Weather;
import org.junit.Test;

import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TestDate {


    @Test
    public void test() {
        Instant instant = Instant.ofEpochMilli(1548234000L);
        LocalDateTime date = instant.atZone(ZoneId.of("UTC")).toLocalDateTime();
        System.out.println(date);
    }

    @Test
    public void testParseToObject() {
        String content = "<div>" +
                "<p class=\"day-link\" data-link=\"//sinoptik.ua/погода-одесса/2019-01-18\">Пятница</p>\n" +
                "        <p class=\"date \">18</p>\n" +
                "        <p class=\"month\">января</p>" +
                "</div>";
        Weather weather = JAXB.unmarshal(new StringReader(content), Weather.class);
        System.out.println(weather);
    }
}
