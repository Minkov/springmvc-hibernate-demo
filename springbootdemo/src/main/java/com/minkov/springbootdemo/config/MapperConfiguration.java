package com.minkov.springbootdemo.config;

import com.minkov.springbootdemo.mappings.MappingsInitializer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    private static ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        MappingsInitializer.initMappings(mapper);
        mapper.validate();
    }

    @Bean
    public ModelMapper modelMapper() {
        return mapper;
    }
}
