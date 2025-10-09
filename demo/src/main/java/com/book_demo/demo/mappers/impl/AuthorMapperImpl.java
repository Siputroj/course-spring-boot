package com.book_demo.demo.mappers.impl;

import com.book_demo.demo.domain.dto.AuthorDto;
import com.book_demo.demo.domain.entities.AuthorEntity;
import com.book_demo.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {
    private final ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public AuthorDto mapTo(AuthorEntity a) {
        return modelMapper.map(a, AuthorDto.class);
    }
    @Override
    public AuthorEntity mapFrom(AuthorDto d) {
        return modelMapper.map(d, AuthorEntity.class);
    }
}
