import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Member andreas = new Member("Andreas", "12345678", "Vejen 1", LocalDate.of(1999, 2,5), 1, true);
        CompetitiveMember emil = new CompetitiveMember("Emil", "87654321", "Gaden", LocalDate.of(1997, 9, 5), 2, false);
        emil.disciplines.add(Disciplines.CRAWL);
        System.out.println(andreas + "\n" + emil);
    }
}
