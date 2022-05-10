package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.config.JpaConfig;
import com.alfimenkov.finalproject.entity.Category;
import com.alfimenkov.finalproject.repo.ICategoryRepository;
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
public class CategoryRepoTest {

    @Resource
    ICategoryRepository categoryRepository;

    @Mock
    Category expectedResult;

    @Before
    public void setTestCategory() {

        expectedResult = new Category()
                .setName("Test_Category")
                .setTours(null);
    }

    @Test
    public void createCategoryTest() {

        expectedResult = categoryRepository.save(expectedResult);

        Category actualResult = categoryRepository.getById(expectedResult.getId());

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteCategoryTest() {

        expectedResult = categoryRepository.save(expectedResult);
        categoryRepository.deleteCategoryById(expectedResult.getId());

        Category actualResult = categoryRepository.getById(expectedResult.getId());
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateCategoryTest() {

        expectedResult = categoryRepository.save(expectedResult);

        expectedResult.setName("AAAA");
        categoryRepository.save(expectedResult);

        Category actualResult = categoryRepository.findCategoryById(expectedResult.getId());
        Assert.assertEquals(expectedResult, actualResult);

    }
}
