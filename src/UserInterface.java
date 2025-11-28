import java.util.Scanner;

public class UserInterface {
    private Scanner inputSC;
    MemberManager memberList;

    public UserInterface(Scanner inputSC) {
        this.inputSC = new Scanner(System.in);
        this.memberList = new MemberManager();
    }

    public void createUI() {

        while (true) {
            System.out.println("1. Opret Medlem\n" +
                    "2. ");


            int number = inputSC.nextInt();
            inputSC.nextLine();
            switch (number) {
                case 1:
                    System.out.println("Indtast Navn");
                    String name = inputSC.nextLine();
                    System.out.println("Intast nummer");
                    String phone = inputSC.nextLine();
                    System.out.println("Intast adresse");
                    String adress = inputSC.nextLine();
                    //System.out.println("Intast fødselsdag");
                    System.out.println("Aktivt medlemsskab?");

                    boolean activeStatus;
                    if(inputSC.nextInt() == 1){
                        activeStatus = true;
                    } else activeStatus = false;

            }
        }
    }
}
