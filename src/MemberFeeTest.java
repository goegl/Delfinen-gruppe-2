import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberFeeTest {

    @Test
    void calculateInactiveMemberFee() {
        MemberFee fee  = new MemberFee();
        double result = fee.calculateFee(false, LocalDate.of(1900,12,29));
        assertEquals(500, result);
    }
    @Test
    void calculateActiveSeniorMemberFee() {
        MemberFee fee  = new MemberFee();
        double result = fee.calculateFee(true, LocalDate.of(2001,12,29));
        assertEquals(result, 1600);
    }
    @Test
    void calculateActiveJuniorMemberFee() {
        MemberFee fee  = new MemberFee();
        double result = fee.calculateFee(true, LocalDate.of(2020,12,29));
        assertEquals(result, 1000);
    }
    @Test
    void calculateRetireeMemberFee() {
        MemberFee fee  = new MemberFee();
        double result = fee.calculateFee(true, LocalDate.of(1900,12,29));
        assertEquals(result, 1200);
    }
}