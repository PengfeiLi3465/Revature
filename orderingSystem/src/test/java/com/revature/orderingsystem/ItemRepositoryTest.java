package com.revature.orderingsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.google.common.base.Optional;
import com.revature.orderingsystem.model.Item;
import com.revature.orderingsystem.repo.ItemRepository;

//@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class ItemRepositoryTest {
@Autowired
private ItemRepository itemRepository;

/*
	@BeforeEach
	void initUseCase() {
		 List<Item> items = Arrays.asList(
	                new Item(1,"Burger",3.99f)
	        );
	        itemRepository.saveAll(items);
	}
	
	@AfterEach
    public void destroyAll(){
        itemRepository.deleteAll();
    }
*/	
	@Test
    void demoTestMethod() {
        assertTrue(true);
    }
/*	
	@Test
    void saveAll_success() {
        List<Item> items = Arrays.asList(
                new Item(2,"Salad",3.99f),
                new Item(3,"Shake",2.99f),
                new Item(4,"Fries",1.99f)
        );
        
        Iterable<Item> allItem = itemRepository.saveAll(items);
        
        AtomicInteger validIdFound = new AtomicInteger();
        allItem.forEach(item -> {
            if(item.getItemId()>0){
                validIdFound.getAndIncrement();
            }
        });
        
        assertThat(validIdFound.intValue()).isEqualTo(3);
	}
	
	 @Test
	    void findAll_success() {
	        List<Item> allItem = itemRepository.findAll();
	        assertThat(allItem.size()).isGreaterThanOrEqualTo(1);
	    }	
	
	*/
	@Test
	public void testMock() {
	ItemRepository mockObj = Mockito.mock(ItemRepository.class);	
	Mockito.when(mockObj.count()).thenReturn(111L);

    long userCount = mockObj.count();

   // Assert.
    assertEquals(111L, userCount);
    Mockito.verify(mockObj).count(); 
	
	}	
}



