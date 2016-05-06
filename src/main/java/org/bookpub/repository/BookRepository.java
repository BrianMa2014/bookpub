package org.bookpub.repository;

import org.bookpub.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MaMingJiang on 2016/2/16.
 */
@Repository
public interface BookRepository extends CrudRepository<Book,String> {

    Book findBookByIsbn(String isbn);
}
