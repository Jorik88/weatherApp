package com.example.alex.weatherApp;

import com.example.alex.weatherApp.model.Weather;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestParseSite {

//    private String url = "https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%BE%D0%B4%D0%B5%D1%81%D1%81%D0%B0/10-%D0%B4%D0%BD%D0%B5%D0%B9";
    private String url = "https://sinoptik.ua/погода-одесса/10-дней";

    @Test
    public void testParse() throws IOException {
        Document document = Jsoup.parse(new URL(url), 3000);
        Element first = document.select("div[class=tabs]").first();
        Elements days = first.select("div[class=main]");
        List<Weather> weathers = convertToWeather(days);
        Element selectToday = document.select("div[class=main loaded]").first();
        Weather weather = getWeather(selectToday, true);
        weathers.add(0, weather);
        System.out.println(weathers);

    }

    private List<Weather> convertToWeather(Elements elements) {
        List<Weather> weathers = new ArrayList<>();

        for (Element element : elements) {
            Weather weather = getWeather(element, false);
            weathers.add(weather);
        }

        return weathers;
    }

    private Weather getWeather(Element element, boolean today) {
        Weather weather = new Weather();
        if (today) {
            weather.setDayOfWeek(element.select("p[class=day-link]").text());
        } else {
            weather.setDayOfWeek(element.select("a[class=day-link]").text());
        }
        weather.setMonth(element.select("p[class=month]").text());
        weather.setMinTemperature(element.select("div[class=temperature]").select("div[class=min]").select("span").text());
        weather.setMaxTemperature(element.select("div[class=temperature]").select("div[class=max]").select("span").text());
        weather.setDayDate(element.select("p[class^=date]").text());
        return weather;
    }
}
