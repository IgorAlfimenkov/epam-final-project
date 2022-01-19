package java.com.alfimenkov.finalproject.repo;

import com.alfimenkov.finalproject.config.JpaConfig;
import com.alfimenkov.finalproject.entity.Ticket;
import com.alfimenkov.finalproject.entity.User;
import com.alfimenkov.finalproject.repo.ITicketRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
public class TicketRepoTest {


    @Resource
    private ITicketRepository ticketRepository;

    @Mock
    private Ticket expectedResult;

    @Before
    public void setTicket() {

        expectedResult = new Ticket()
                .setCustomerName("testName")
                .setCustomerSurname("testSurname")
                .setDate(new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void createTicketTest() {

        expectedResult = ticketRepository.save(expectedResult);

        Ticket actualResult = ticketRepository.findById(expectedResult.getId()).get();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void deleteTicketTest() {

        expectedResult = ticketRepository.save(expectedResult);

        ticketRepository.deleteTicketById(expectedResult.getId());

        Ticket actualResult = ticketRepository.findById(expectedResult.getId()).get();
        Assert.assertNull(actualResult);
    }

    @Test
    public void updateTicketTest() {

        expectedResult = ticketRepository.save(expectedResult);

        expectedResult.setCustomerName("Surname_");
        ticketRepository.save(expectedResult);

        Ticket actualResult = ticketRepository.findById(expectedResult.getId()).get();
        Assert.assertEquals(expectedResult, actualResult);
    }

}
