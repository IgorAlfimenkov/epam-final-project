package java.com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.config.JpaConfig;
import com.alfimenkov.finalproject.entity.Role;
import com.alfimenkov.finalproject.repo.IRoleRepository;
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
public class RoleRepoTest {

    @Resource
    private IRoleRepository roleRepository;

    @Mock
    private Role expectedResult;

    @Before
    public void setTestRole() {

        expectedResult = new Role()
                .setName("TEST")
                .setCredentials(null);
    }

    @Test
    public void createRoleTest() {

        expectedResult = roleRepository.save(expectedResult);

        Role actualResult = roleRepository.findRoleById(expectedResult.getId());

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteRoleTest() {

        expectedResult = roleRepository.save(expectedResult);
        roleRepository.deleteRoleById(expectedResult.getId());

        Role actualResult = roleRepository.findRoleById(expectedResult.getId());

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void updateRoleTest() {
        expectedResult = roleRepository.save(expectedResult);

        expectedResult.setName("NO TEST");
        roleRepository.save(expectedResult);

        Role actualResult = roleRepository.findRoleById(expectedResult.getId());
        Assert.assertEquals(expectedResult, actualResult);
    }
}
