package com.thoughtworks.nho.nho29.service.impl;

import com.thoughtworks.nho.nho29.domain.TrainingClubUser;
import com.thoughtworks.nho.nho29.repository.TrainingClubUserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@SpringBootTest
public class TrainingClubUserServiceTest {

    @Mock
    private TrainingClubUserRepository trainingClubUserRepository;

    @InjectMocks
    private TrainingClubUserServiceImpl trainingClubUserService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_findByUserName() {
        when(trainingClubUserRepository.findByUsername(Mockito.anyString())).thenReturn(buildTrainingClubUser());

        TrainingClubUser result = trainingClubUserService.findByUsername("Steven");

        Assert.assertEquals(result.getId().longValue(), 1l);
        Assert.assertEquals(result.getPassword(), "Hello, World!");
    }

    @Test
    public void test_findOne() {
        when(trainingClubUserRepository.findById(anyLong())).thenReturn(Optional.of(buildTrainingClubUser()));

        TrainingClubUser result = trainingClubUserService.findOne(1l);

        Assert.assertEquals(result.getId().longValue(), 1l);
        Assert.assertEquals(result.getPassword(), "Hello, World!");
    }

    @Test
    public void test_findOne_with_none_result_from_rep() {
        when(trainingClubUserRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));

        TrainingClubUser result = trainingClubUserService.findOne(1l);

        Assert.assertEquals(result.getId().longValue(), -1l);
        Assert.assertEquals(result.getPassword(), "");
        Assert.assertEquals(result.getUsername(), "Unknown");
    }

    private TrainingClubUser buildTrainingClubUser() {
        TrainingClubUser trainingClubUser = new TrainingClubUser();
        trainingClubUser.setId(1l);
        trainingClubUser.setPassword("Hello, World!");
        trainingClubUser.setUsername("Steven");
        return trainingClubUser;
    }

}
