package com.rollingstone.dao.jpa;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.rollingstone.domain.Todo;

public interface TODORepository extends PagingAndSortingRepository<Todo, Long> {

	// TODO Change this JPA Repository to add custom query methods  to suit your application
	
	Page<Todo> findAll(Pageable pageable);
}
