package com.revature.orderingsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.orderingsystem.model.Detail;
import com.revature.orderingsystem.repo.DetailRepository;

@SpringBootTest
class OrderingSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void demoTestMethod() {
        assertEquals(1,1);
    }

	

}


