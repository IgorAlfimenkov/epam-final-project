package com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.config.JpaConfig;
import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.repo.IUserRepository;
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
public class UserRepoTest {

    @Resource
    private IUserRepository userRepository;

    @Mock
    private User expectedResult;

    @Before
    public void setTestUser() {

        expectedResult = new User()
                .setEmail("test@mail.com")
                .setName("Ivan")
                .setSurname("Ivanov");
    }

    @Test
    public void createUserTest() {

        expectedResult = userRepository.save(expectedResult);

        User actualResult = userRepository.findUserById(expectedResult.getId());

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteUserTest() {

        expectedResult = userRepository.save(expectedResult);
        userRepository.deleteById(expectedResult.getId());

        User actualResult = userRepository.findUserById(expectedResult.getId());

        Assert.assertNull(actualResult);
    }

    @Test
    public void updateUserTest() {

        expectedResult = userRepository.save(expectedResult);
        expectedResult.setName("Petr");
        userRepository.save(expectedResult);

        User actualResult = userRepository.findUserById(expectedResult.getId());
        Assert.assertEquals(expectedResult, actualResult);
    }
}
