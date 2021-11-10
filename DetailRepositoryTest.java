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

import com.revature.orderingsystem.model.Detail;
import com.revature.orderingsystem.repo.DetailRepository;

import org.springframework.boot.test.context.SpringBootTest;

//@DataJpaTest

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class DetailRepositoryTest {
@Autowired
private DetailRepository detailRepository;

/*
    @BeforeEach
    void initUseCase() {
         List<Detail> details = Arrays.asList(
                    new Detail(1,1,1,1)
            );
            detailRepository.saveAll(details);
    }

    @AfterEach
    public void destroyAll(){
        detailRepository.deleteAll();
    }
*/
    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
/*
    @Test
    void saveAll_success() {
        List<Detail> details = Arrays.asList(
                new Detail(2,2,2,2),
                new Detail(3,4,5,6),
                new Detail(1,1,1,1)
        );

        Iterable<Detail> allDetail = detailRepository.saveAll(details);

        AtomicInteger validIdFound = new AtomicInteger();
        allDetail.forEach(detail -> {
            if(detail.getDetailId()>0){
                validIdFound.getAndIncrement();
            }
        });

        assertThat(validIdFound.intValue()).isEqualTo(3);
    }
    */
    
     @Test
        void findAll_success() {
            List<Detail> allDetail = detailRepository.findAll();
            assertThat(allDetail.size()).isGreaterThanOrEqualTo(0);
        }

    @Test
    public void testMock() {
    DetailRepository mockObj = Mockito.mock(DetailRepository.class);
    List<Detail> detail = detailRepository.findAll();
    Mockito.when(mockObj.findAllByorderId(1)).thenReturn(detail);

    List<Detail> order = mockObj.findAllByorderId(1);

   // Assert.
    assertEquals(detail, order);
    Mockito.verify(mockObj).findAllByorderId(1); 
	
    }
    
}