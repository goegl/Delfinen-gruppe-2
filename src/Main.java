import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Member andreas = new Member("Andreas", "12345678", "Vejen 1", LocalDate.of(1999, 2,5), 1, true);
        System.out.println(andreas);
    }
}
