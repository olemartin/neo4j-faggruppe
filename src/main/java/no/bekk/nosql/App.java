package no.bekk.nosql;

import no.bekk.nosql.integration.Repository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        Repository repo = context.getBean(Repository.class);
        repo.populate();
    }
}
