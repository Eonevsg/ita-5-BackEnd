package com.project.ita5.school;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Override
    public List<String> fetchSchools() {
        RestTemplate restTemplate = new RestTemplate();
        String url1 = "https://lt.wikipedia.org/w/api.php?action=parse&format=json&prop=sections&page=Sąrašas:Lietuvos_aukštosios_mokyklos&section=1&prop=wikitext";
        String url2 = "https://lt.wikipedia.org/w/api.php?action=parse&format=json&prop=sections&page=Sąrašas:Lietuvos_aukštosios_mokyklos&section=4&prop=wikitext";

        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        Object schoolsPart1 = restTemplate.getForObject(url1, Object.class);
        Object schoolsPart2 = restTemplate.getForObject(url2, Object.class);

        List<String> schools = new ArrayList<>(purifyText(schoolsPart1));
        schools.addAll(purifyText(schoolsPart2));
        Collections.sort(schools, Collator.getInstance(new Locale("lt")));

        return schools;
    }

    private List<String> purifyText(Object input){
        List<String> schools = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<=\\[\\[)[A-Z-a-zą-žA-Ž ]*(?=\\]\\])");
        Matcher matcher = pattern.matcher(input.toString());
        while (matcher.find()) {
            schools.add(matcher.group());
        }
        return schools;
    }
}
