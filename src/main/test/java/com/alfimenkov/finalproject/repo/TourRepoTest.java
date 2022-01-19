package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.config.JpaConfig;

import com.alfimenkov.finalproject.entity.Tour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
public class TourRepoTest {

    @Resource
    private ITourRepository tourRepository;

    @Mock
    private Tour expectedResult;

    @Before
    public void setTestTour(){

        expectedResult = new Tour()
                .setName("Test name")
                .setDescription("Desc")
                .setQuantity(2)
                .setIsHot(true)
                .setCategories(null)
                .setPrice(null);
    }

    @Test
    public void createTourTest() {
        expectedResult = tourRepository.save(expectedResult);

        Tour actualResult = tourRepository.findTourById(expectedResult.getId());

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteTourTest() {
        expectedResult = tourRepository.save(expectedResult);

        tourRepository.deleteById(expectedResult.getId());

        Tour actualResult = tourRepository.findTourById(expectedResult.getId());
        Assert.assertNull(actualResult);
    }

    @Test
    public void findTourTest() {
        expectedResult = tourRepository.save(expectedResult);

        Tour actualResult = tourRepository.findTourById(expectedResult.getId());

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateTourTest() {
        expectedResult = tourRepository.save(expectedResult);

        expectedResult.setQuantity( 1);
        tourRepository.save(expectedResult);

        Tour actualResult = tourRepository.findTourById(expectedResult.getId());

        Assert.assertEquals(expectedResult, actualResult);
    }
}
