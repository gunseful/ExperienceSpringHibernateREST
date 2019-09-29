package kz.gunseful.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// Говорим, что это конфигурация
@Configuration
// Включаем MVC
@EnableWebMvc
// Указываем где искать контроллеры и остальные компоненты
@ComponentScan("kz.gunseful")
public class WebConfig {

//    @Bean
//    public UrlBasedViewResolver setupViewResolver() {
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        // указываем где будут лежать наши веб-страницы
//        resolver.setPrefix("/pages/");
//        // формат View который мы будем использовать
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//
//        return resolver;
//    }

}