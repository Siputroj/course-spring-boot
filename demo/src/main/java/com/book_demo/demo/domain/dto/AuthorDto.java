///  Data transfer object. We dont want our front end layer of the program to know the implementation
/// of the backend entities such as authors and books. to do this, we need to create a data transfer object that masks
/// the backend objects

package com.book_demo.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {
    private Long id;
    private String name;
    private Integer age;
}
