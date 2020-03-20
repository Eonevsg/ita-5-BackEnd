package com.project.ita5.school;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Override
    public List<Object> fetchSchools() {
        RestTemplate restTemplate = new RestTemplate();
        String url1 = "https://lt.wikipedia.org/w/api.php?action=parse&format=json&prop=sections&page=Sąrašas:Lietuvos_aukštosios_mokyklos&section=1&prop=wikitext";
        String url2 = "https://lt.wikipedia.org/w/api.php?action=parse&format=json&prop=sections&page=Sąrašas:Lietuvos_aukštosios_mokyklos&section=4&prop=wikitext";
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        Object result1 = restTemplate.getForObject(url1, Object.class);
        Object result2 = restTemplate.getForObject(url2, Object.class);
        List<Object> result = new ArrayList<>();
        result.add(result1);
        result.add(result2);
        return result;
    }
}
