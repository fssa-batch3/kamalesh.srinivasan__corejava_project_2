import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.fssa.needstobedone.dao.JobDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.services.JobService;
import java.util.ArrayList;
import java.util.List;

public class JobServiceTest {

    private JobService jobService;
    private JobDAO jobDAO;

    @Before
    public void setUp() {
        jobService = new JobService();
        jobDAO = new JobDAO();
    }

    @Test
    public void testValidCreateJob() {
        Job job1 = new Job("SoftwareDevelopment", 200000, "kikamakles@gmail.com");

        try {
            boolean result = jobService.createJob(job1);
            System.out.println("testCase");
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testInvalidCreateJob() {
        Job job1 = new Job("InvalidJob", 100, "invalid-email");

        try {
            boolean result = jobService.createJob(job1);
            assertFalse(result);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testValidUpdateJob() {
        Job job1 = new Job("SoftwareDevelopment", 200000, "kikamakles@gmail.com");

        try {
            boolean result = jobService.updateJob(job1);
            assertTrue(result);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testInvalidUpdateJob() {
        Job job1 = new Job("InvalidJob", 100, "invalid-email");

        try {
            boolean result = jobService.updateJob(job1);
            assertFalse(result);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testValidDeleteJob() {
        String jobId = "validJobId";

        try {
            boolean result = jobService.deleteJob(jobId);
            assertTrue(result);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testInvalidDeleteJob() {
        String jobId = "invalidJobId";

        try {
            boolean result = jobService.deleteJob(jobId);
            assertFalse(result);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testValidListJobs() {
        String jobId = "validJobId";
        List<Job> expectedJobs = new ArrayList<>();
        expectedJobs.add(new Job("SoftwareDevelopment", 200000, "kikamakles@gmail.com"));

        try {
            List<Job> result = jobService.listJobs(jobId);
            assertEquals(expectedJobs.size(), result.size());
            assertEquals(expectedJobs.get(0).getTitle(), result.get(0).getTitle());
            assertEquals(expectedJobs.get(0).getPrice(), result.get(0).getPrice());
            assertEquals(expectedJobs.get(0).getEmail(), result.get(0).getEmail());
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testInvalidListJobs() {
        String jobId = "invalidJobId";

        try {
            List<Job> result = jobService.listJobs(jobId);
            assertNull(result);
        } catch (ServiceException | DAOException e) {
            e.printStackTrace();
            fail();
        }
    }
}
