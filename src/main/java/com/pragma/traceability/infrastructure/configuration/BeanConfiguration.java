package com.pragma.traceability.infrastructure.configuration;

import com.pragma.traceability.domain.api.ILogServicePort;
import com.pragma.traceability.domain.spi.ILogPersistencePort;
import com.pragma.traceability.domain.usecase.LogUseCase;
import com.pragma.traceability.infrastructure.out.mongo.adapter.LogMongoAdapter;
import com.pragma.traceability.infrastructure.out.mongo.mapper.ILogEntityMapper;
import com.pragma.traceability.infrastructure.out.mongo.repository.ILogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ILogRepository logRepository;
    private final ILogEntityMapper logEntityMapper;

    @Bean
    public ILogPersistencePort logPersistencePort() {
        return new LogMongoAdapter(logRepository, logEntityMapper);
    }

    @Bean
    public ILogServicePort logServicePort() {
        return new LogUseCase(logPersistencePort());
    }
}