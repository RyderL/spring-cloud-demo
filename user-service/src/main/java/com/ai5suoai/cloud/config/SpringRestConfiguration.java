package com.ai5suoai.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * spring rest data 的配置
 *
 * @author chenzhenjia
 * @since 16/5/23
 */
@Configuration
public class SpringRestConfiguration extends RepositoryRestConfigurerAdapter {
    /**
     * 创建一个 validator 放到 spring ,并设为主的数据校验
     */
    @Bean
    @Primary
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    /**
     * 给 rest-data 添加上校验
     */
    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        // 修改时的数据校验
        validatingListener.addValidator("beforeSave", validator());
        // 插入时的数据校验
        validatingListener.addValidator("beforeCreate", validator());
    }


}
