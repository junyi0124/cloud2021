import com.atguigu.springcloud.PaymentMain8001;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest(classes= PaymentMain8001.class)
public class PaymentDaoTest {

    @Autowired
    private PaymentDao dao;

    @Test
    public void selectPaymentListShouldReturnData() {
        //arrange
        //such as insert one line of payment data

        //act
        List<Payment> payments = dao.getPayments();

        //assert
        Assert.notNull(payments,"true");
        Assert.notEmpty(payments,"ture");
        Assert.isTrue(payments.size() > 0,"true");
    }
}
