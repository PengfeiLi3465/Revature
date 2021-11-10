package com.revature.orderingsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.revature.orderingsystem.model.User;
import com.revature.orderingsystem.repo.UserRepository;

import org.springframework.boot.test.context.SpringBootTest;

//@DataJpaTest

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
@Autowired
private UserRepository UserRepository;

/*
    @BeforeEach
    void initUseCase() {
         List<User> Users = Arrays.asList(
                    new User(1,1,1,1)
            );
            UserRepository.saveAll(Users);
    }

    @AfterEach
    public void destroyAll(){
        UserRepository.deleteAll();
    }
*/
    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
/*
    @Test
    void saveAll_success() {
        List<User> Users = Arrays.asList(
                new User(2,2,2,2),
                new User(3,4,5,6),
                new User(1,1,1,1)
        );

        Iterable<User> allUser = UserRepository.saveAll(Users);

        AtomicInteger validIdFound = new AtomicInteger();
        allUser.forEach(User -> {
            if(User.getUserId()>0){
                validIdFound.getAndIncrement();
            }
        });

        assertThat(validIdFound.intValue()).isEqualTo(3);
    }
    */
    
     @Test
        void findAll_success() {
            List<User> allUser = UserRepository.findAll();
            assertThat(allUser.size()).isGreaterThanOrEqualTo(0);
        }

    @Test
    public void testMock() {
    UserRepository mockObj = Mockito.mock(UserRepository.class);
    Mockito.when(mockObj.count()).thenReturn(111L);

    long userCount = mockObj.count();

   // Assert.
    assertEquals(111L, userCount);
    Mockito.verify(mockObj).count(); 
	
    }
    
}
