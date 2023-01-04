package com.miroshnicheko.springbootapp;

import com.miroshnicheko.data.Entity;
import com.miroshnicheko.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.Properties;

@SpringBootApplication
public class SpringBootAppApplication {
    @Autowired
    MyAppProperties props;

    public static void main(String[] args) {
        SpringApplication app =
                new SpringApplication(SpringBootAppApplication.class);

        // put additional settings here
        Properties properties = new Properties();
        properties.put("prop1","value1__from__app.setDefaultProperties(properties);");

        app.setDefaultProperties(properties);
        ConfigurableApplicationContext context = app.run(args);
        MyComponent component = (MyComponent) context.getBean("myComponent");
        System.out.println("## > App Started!");
        System.out.println("====== from main get bean get field ======> component.prop1 =" + component.prop1);
        MyAppProperties props = (MyAppProperties) context.getBean("myAppProperties");
        System.out.println("====== from main get bean get field ======> MyAppProperties.myappproperties =" + props.getMyappproperties());
        OtherAppProperties otherprops = (OtherAppProperties) context.getBean("otherAppProperties");
        System.out.println("====== from main get bean get field ======> MyAppProperties.myappproperties =" + otherprops.getMyappproperties());


      Entity e = Entity.builder().id("MyId").description("MyDescr").createdDate(LocalDateTime.now()).build();
      System.out.println(e);
        CommonRepository<Entity> repository = context.getBean(EntityRepository.class);
        System.out.println(repository);
        assert(repository!= null);
        repository.save(e);
        System.out.println( repository.findAll().iterator().hasNext());
    }

}
