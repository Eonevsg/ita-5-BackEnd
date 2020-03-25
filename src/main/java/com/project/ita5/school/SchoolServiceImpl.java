package com.project.ita5.school;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Value("${highSchoolUrl1}")
    private String highSchoolUrl1;

    @Value("${highSchoolUrl2}")
    private String highSchoolUrl2;

    @Override
    public List<String> fetchSchools() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        Object schoolsPart1 = restTemplate.getForObject(highSchoolUrl1, Object.class);
        Object schoolsPart2 = restTemplate.getForObject(highSchoolUrl2, Object.class);

        List<String> schools = new ArrayList<>(purifyText(schoolsPart1));
        schools.addAll(purifyText(schoolsPart2));
        Collections.sort(schools, Collator.getInstance(new Locale("lt")));

        return schools;
    }

    private List<String> purifyText(Object input) {
        List<String> schools = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<=\\[\\[)[A-Z-a-zą-žA-Ž ]*(?=\\]\\])");
        Matcher matcher = pattern.matcher(input.toString());
        while (matcher.find()) {
            schools.add(matcher.group());
        }
        return schools;
    }
}
