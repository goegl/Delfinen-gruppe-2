import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Add members
        Member andreas = new Member("Andreas", "12345678", "Vejen 1", LocalDate.of(1999, 2,5), 1, true);
        CompetitiveMember emil = new CompetitiveMember("Emil", "87654321", "Gaden", LocalDate.of(1920, 9, 5), 2, true);

        //Add diciplines
        emil.disciplines.add(Disciplines.CRAWL);
        emil.disciplines.add(Disciplines.BUTTERFLY);
        emil.disciplines.add(Disciplines.BREASTSTROKE);

        System.out.println(andreas + "\n" + emil);
        Result result = new Result(emil, Disciplines.CRAWL, 17.2, LocalDate.now());

        MemberManager mm = new MemberManager();
        mm.createMember("Anders And", "12345678", "Vejen 1", LocalDate.of(1999, 2,5), 1, true);

    }
}
