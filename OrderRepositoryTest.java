
package com.revature.orderingsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

//import com.google.common.base.Optional;
import com.revature.orderingsystem.model.Order;
import com.revature.orderingsystem.repo.OrderRepository;

//import junit.framework.Assert;

//@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class OrderRepositoryTest {
@Autowired
private OrderRepository OrderRepository;

/*
	@BeforeEach
	void initUseCase() {
		 List<Order> orders = Arrays.asList(
	                new Order(1,1,1,4.40f, "Note")
	        );
	        OrderRepository.saveAll(orders);
	}
	
	@AfterEach
    public void destroyAll(){
        OrderRepository.deleteAll();
    }
*/	
	@Test
    void demoTestMethod() {
        assertEquals(1,1);
    }
	/*
	@Test
    void saveAll_success() {
        List<Order> orders = Arrays.asList(
                new Order(2,2,2,4.70f, "Note"),
                new Order(3,4,5,4.90f, "Note"),
                new Order(4,5,6,4.30f, "Note")
                );
        
        Iterable<Order> allOrder = OrderRepository.saveAll(orders);
        
        AtomicInteger validIdFound = new AtomicInteger();
        allOrder.forEach(Order -> {
            if(Order.getOrderId()>0){
                validIdFound.getAndIncrement();
            }
        });
        
        assertThat(validIdFound.intValue()).isEqualTo(3);
	}
	
	 @Test
	    void findAll_success() {
	        List<Order> allOrder = OrderRepository.findAll();
	        assertThat(allOrder.size()).isGreaterThanOrEqualTo(1);
	    }	
	*/
	
	@Test
	public void testMock() {
	OrderRepository mockObj = Mockito.mock(OrderRepository.class);	
	Mockito.when(mockObj.count()).thenReturn(111L);

    long userCount = mockObj.count();

   // Assert.
    assertEquals(111L, userCount);
    Mockito.verify(mockObj).count(); 
	}	
}


