package com.ai5suoai.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenzhenjia
 * @since 16/7/2
 */
//@Configuration
//@EnableWebMvc
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> types = new ArrayList<MediaType>() {{
            add(MediaType.TEXT_HTML);
            add(MediaType.APPLICATION_JSON);
        }};
        converter.setSupportedMediaTypes(types);
        converters.add(converter);
    }

    @Bean
    @Primary
    public SimpleMappingExceptionResolver exceptionResolver() {
        return new CustomMappingExceptionResolver();
    }

    public static class CustomMappingExceptionResolver extends SimpleMappingExceptionResolver {
        private static final Logger log = LoggerFactory.getLogger(CustomMappingExceptionResolver
                .class);

        @Override
        protected ModelAndView getModelAndView(String viewName, Exception ex, HttpServletRequest request) {
            return super.getModelAndView(viewName, ex, request);
        }

        @Override
        protected ModelAndView getModelAndView(String viewName, Exception ex) {
            log.info("获取view,viewName:{}", viewName);
            ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
            mv.addObject("exception", ex);
            return mv;
        }
    }
}
