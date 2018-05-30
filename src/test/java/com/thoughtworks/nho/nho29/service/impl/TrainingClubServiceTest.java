package com.thoughtworks.nho.nho29.service.impl;

import com.thoughtworks.nho.nho29.domain.TrainingClub;
import com.thoughtworks.nho.nho29.repository.TrainingClubRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TrainingClubServiceTest {

    @Mock
    private TrainingClubRepository trainingClubRepository;

    @InjectMocks
    private TrainingCludServiceImpl trainingClubService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_findTrainingClubById() {

        when(trainingClubRepository.findById(Mockito.anyLong())).thenReturn(buildTrainingCludEntity());

        TrainingClub result = trainingClubService.findTrainingClubById(1l);
        Assert.assertEquals(result.getId().longValue(), 1l);
        Assert.assertEquals(result.getName(), "NHO29");

    }


    private Optional<TrainingClub> buildTrainingCludEntity() {
        TrainingClub trainingClub = new TrainingClub();
        trainingClub.setDescription("This is nho29!");
        trainingClub.setId(1l);
        trainingClub.setName("NHO29");
        trainingClub.setThumbnailUrl("10.255.10.102://icons/first_icon.jpg");

        return Optional.of(trainingClub);
    }

}
