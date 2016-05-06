package org.bookpub.repository;

import org.bookpub.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by MaMingJiang on 2016/2/17.
 */
@RepositoryRestResource
public interface AuthorRepository extends CrudRepository<Author,Long>{
}
