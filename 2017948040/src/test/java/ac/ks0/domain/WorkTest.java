package ac.ks0.domain;

import ac.ks0.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkTest {

    @Autowired
    private WorkRepository workRepository;

    private Work savedWork;

    @Before
    public void init() {
        savedWork = workRepository.save(Work.builder()
        .company("(주)홍길동").position("개발자").website("http://www.company.domain").startdate(LocalDate.of(2019,1,1))
        .enddate(LocalDate.of(2019,1,2)).summry("...요약")
        .build());
    }

    @Test
    public void testFindIDWork(){
        Work foundWork = workRepository.findById(savedWork.getIdx()).orElse(null);
        assertThat(foundWork.getIdx()).isEqualTo(savedWork.getIdx());
    }
}
