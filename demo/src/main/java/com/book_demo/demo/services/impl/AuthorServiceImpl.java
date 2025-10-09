package com.book_demo.demo.services.impl;

import com.book_demo.demo.domain.entities.AuthorEntity;
import com.book_demo.demo.repositories.AuthorRepository;
import com.book_demo.demo.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {

        return authorRepository.save(authorEntity);
    }
}
