package io.github.arthurrmoura.config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class JacksonOffsetDateTimeMapper{
	
    @Primary
    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
			@Override
			public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt)throws IOException, JsonProcessingException {
				String strData = p.getText();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime ldt = LocalDateTime.parse(strData, formatter);
				OffsetDateTime ofsdt = OffsetDateTime.of(ldt, ZoneOffset.of(OffsetDateTime.now().getOffset().toString())); 
				return ofsdt;
			}
        });
        objectMapper.registerModule(simpleModule);

        return objectMapper;
    }

}
