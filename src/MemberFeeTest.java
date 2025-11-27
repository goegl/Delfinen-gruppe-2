import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberFeeTest {

    @Test
    void calculateMemberFee() {
        MemberFee fee  = new MemberFee();
        double result = fee.calculateFee(true, LocalDate.of(1900,12,29));
        assertEquals(result, 1200);
    }
}