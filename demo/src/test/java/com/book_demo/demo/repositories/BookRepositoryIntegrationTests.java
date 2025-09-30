package com.book_demo.demo.repositories;

import com.book_demo.demo.TestDataUtil;
import com.book_demo.demo.domain.Author;
import com.book_demo.demo.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {

    private BookRepository underTest;

    @Autowired
    public BookRepositoryIntegrationTests(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        Book book = TestDataUtil.createTestBookA(author);
        Book bookEntity = underTest.save(book);
        Optional<Book> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookEntity);
    }

//    @Test
//    public void testThatBookCanBeUpdated() {
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthorId(author.getId());
//        underTest.create(bookA);
//
//        bookA.setTitle("UPDATED");
//        underTest.update(bookA.getIsbn(), bookA);
//
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isPresent();
//        assertThat(result.get()).isEqualTo(bookA);
//    }
//
//
//    @Test
//    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthorId(author.getId());
//        underTest.create(bookA);
//
//        Book bookB = TestDataUtil.createTestBookB();
//        bookB.setAuthorId(author.getId());
//        underTest.create(bookB);
//
//        Book bookC = TestDataUtil.createTestBookC();
//        bookC.setAuthorId(author.getId());
//        underTest.create(bookC);
//
//        List<Book> result = underTest.find();
//        assertThat(result)
//                .hasSize(3)
//                .containsExactly(bookA, bookB, bookC);
//    }
//
//    @Test
//    public void testThatBookCanBeDeleted() {
//        Author author = TestDataUtil.createTestAuthorA();
//        authorDao.create(author);
//
//        Book bookA = TestDataUtil.createTestBookA();
//        bookA.setAuthorId(author.getId());
//        underTest.create(bookA);
//
//        underTest.delete(bookA.getIsbn());
//
//        Optional<Book> result = underTest.findOne(bookA.getIsbn());
//        assertThat(result).isEmpty();
//    }
}
