package com.ai5suoai.cloud.config;

import com.mongodb.Mongo;

import org.mongeez.Mongeez;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

/**
 * 这是是数据库的配置,仅仅只针对于mongoDB
 *
 * @author chenzhenjia
 * @since 16/5/11
 */
@Configuration
@Import(value = MongoAutoConfiguration.class)
//@EnableMongoAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class DatabaseConfiguration extends AbstractMongoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
    @Autowired
    MongoProperties mongoProperties;
    @Autowired
    Mongo mongo;

    @Override
    protected String getDatabaseName() {
        return mongoProperties.getDatabase();
    }

    @Override
    public Mongo mongo() throws Exception {
        return mongo;
    }

    @Override
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        MappingMongoConverter mappingMongoConverter = super.mappingMongoConverter();
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return mappingMongoConverter;
    }

    @Bean
    @Profile("!fast")
    public Mongeez mongeez() {
        log.info("configuration mongeez");
        Mongeez mongeez = new Mongeez();
        mongeez.setMongo(mongo);
        mongeez.setDbName(mongoProperties.getDatabase());
        mongeez.setFile(new ClassPathResource("/mongeez/master.xml"));
        mongeez.process();
        return mongeez;
    }
}
