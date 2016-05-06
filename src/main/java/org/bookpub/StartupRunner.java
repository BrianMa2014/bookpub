package org.bookpub;

import org.bookpub.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;

/**
 * Created by MaMingJiang on 2016/2/16.
 */
public class StartupRunner implements CommandLineRunner {

    protected static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

    @Autowired
    private DataSource ds;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
         System.out.println("Hello World");
         logger.info("DataSource:" + ds.toString());
        try {
            logger.info("book count : " + bookRepository.findBookByIsbn("111").getAuthor().getFirstName());
        }catch(Exception e){
            logger.info(e.getMessage());
        }
    }
}
