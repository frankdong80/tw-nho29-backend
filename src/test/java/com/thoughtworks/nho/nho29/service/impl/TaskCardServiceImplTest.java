package com.thoughtworks.nho.nho29.service.impl;

import com.thoughtworks.nho.nho29.domain.TaskCardRepository;
import com.thoughtworks.nho.nho29.service.TaskCardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@SpringBootTest
public class TaskCardServiceImplTest {
    @Mock
    TaskCardRepository repo;

    @InjectMocks
    private TaskCardServiceImpl taskCardServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void test_getTaskCardListByTrainingClubId_while_id_is_correct() {
        when(repo.findAllByTrainingClubId(anyLong())).thenReturn(Collections.emptyList());

        Long trainingCLubId = 1l;
        assertTrue(taskCardServiceImpl.getTaskCardListByTrainingClubId(trainingCLubId).size() >= 0);
        verify(repo).findAllByTrainingClubId(eq(trainingCLubId));
        verifyNoMoreInteractions(repo);
    }
}
