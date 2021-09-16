package group.rxcloud.rmg.email.interfaces.aws;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication(scanBasePackages = "group.rxcloud.rmg.email.*")
public class EmailRSocketAwsApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(EmailRSocketAwsApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
