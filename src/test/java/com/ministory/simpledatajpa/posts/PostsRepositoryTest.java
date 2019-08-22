package com.ministory.simpledatajpa.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void tearDown() {
        postsRepository.deleteAll();
    }

    @Test
    public void savePostsTest() {
        //given
        postsRepository.save(Posts.builder()
                .author("ministory")
                .content("Hello Data JPA")
                .title("This is title of Data JPA")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then

        Posts posts = postsList.get(0);
        assertThat(posts.getAuthor(), is("ministory"));
        assertThat(posts.getContent(), is("Hello Data JPA"));
        assertThat(posts.getTitle(), is("This is title of Data JPA"));
    }
}
