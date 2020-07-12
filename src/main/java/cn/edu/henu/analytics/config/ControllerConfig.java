package cn.edu.henu.analytics.config;

import cn.edu.henu.analytics.controller.gen.TableController;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.JpaRepository;
import xyz.luchengeng.spread.reader.ReaderBuilder;
import xyz.luchengeng.spread.reader.SpreadSheetReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ControllerConfig {
    @Value("#{${tables}}")
    private Map<String,String> tables;
    @Autowired
    private Map<String, JpaRepository<?,Long>> repos;
    @Bean
    public SpreadSheetReader realEstateReader() throws IOException {
        return new ReaderBuilder().fromStream(new ClassPathResource("real_estate_schema.json").getInputStream()).build();
    }
    @Bean
    public Map<String, TableController<?>> controllerMap() throws IOException {
        val map = new HashMap<String,TableController<?>>();
        for(Map.Entry<String,String> entry : tables.entrySet()){
            map.put(entry.getKey(),new TableController<>(new ReaderBuilder().fromStream(new ClassPathResource(entry.getValue()).getInputStream()).build(),repos.get(entry.getKey().substring(0, 1).toLowerCase() + entry.getKey().substring(1)+"Repo")));
        }
        return map;
    }
}
