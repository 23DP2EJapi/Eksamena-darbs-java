package lv.rvt;

import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Bibliotēkas Sistēma =====");
            System.out.println("1. Pievienot jaunu grāmatu");
            System.out.println("2. Parādīt visas grāmatas");
            System.out.println("3. Meklēt grāmatu pēc nosaukuma");
            System.out.println("4. Pievienot jaunu klientu");
            System.out.println("5. Parādīt visus klientus");
            System.out.println("6. Klients paņem grāmatu");
            System.out.println("7. Klients atdod grāmatu");
            System.out.println("8. Dzēsts vai rediģēt grāmatu");
            System.out.println("9. Dzēst vai rediģet klientu");
            System.out.println("0. Iziet");
            System.out.print("Izvēlies opciju: ");

            String choice = scanner.nextLine();
            Thread.sleep(5000);
//111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
            if (choice.equals("1")) {
                System.out.print("Ievadi nosaukumu: ");
        String nosaukums = scanner.nextLine();
        System.out.print("Ievadi autoru: ");
        String autors = scanner.nextLine();
        System.out.print("Ievadi izdošanas gadu: ");
        int izdosana = Integer.parseInt(scanner.nextLine());
        System.out.print("Ievadi izdevēju: ");
        String izdevejs = scanner.nextLine();
        String pieejamiba = "Pieejama";

        Gramatas gramata = new Gramatas(nosaukums, autors, izdosana, izdevejs, pieejamiba);
        Gramatas.addBook(gramata);
        System.out.println("Grāmata pievienota!");
        Thread.sleep(5000);
        //2222222222222222222222222222222222222222222222222222222222222222222222222222222222222
            } else if (choice.equals("2")) {
                System.out.println("1 Nekārtot");
                System.out.println("2 Kārtot pēc nosaukuma");
                System.out.println("3 Kārtot pēc autora");
                System.out.println("Izvēlies opciju: ");
                String izvele = scanner.nextLine();
                
                if (izvele.equals("1")){
                    ArrayList<Gramatas> books = Gramatas.getBookLists();
                    for (Gramatas g : books) {
                        System.out.println(g);
                    }
                } else if(izvele.equals("2")){
                    Gramatas.shortByName();
                } else if(izvele.equals("3")){
                    Gramatas.shortByAuthor();
                }
                Thread.sleep(5000);
//3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
            } else if (choice.equals("3")) {

                System.out.println("1. Meklēt pēc Grāmatas nosaukuma");
                System.out.println("2. Meklēt pēc Autora");
                System.out.println("3. Meklēt pēc visiem parametriem");
                String izvele1 = scanner.nextLine();

                if(izvele1.equals("1")){
                    System.out.println("Ievadiet grāmatas nosaukumu:");
                    String nosaukums3 = scanner.nextLine();
                    System.out.println(Gramatas.findbookbynosaukums(nosaukums3));
                } else if(izvele1.equals("2")){
                    System.out.println("Ievadiet grāmatas autoru:");
                    String nosaukums2 = scanner.nextLine();
                    System.out.println(Gramatas.findbookbyautors(nosaukums2));
                } else if(izvele1.equals("3")){
                    System.out.println("Ievadiet grāmatas nosaukumu:");
                    String nosaukums = scanner.nextLine();
                    System.out.println("Ievadiet grāmatas autoru:");
                    String autors = scanner.nextLine();
                    System.out.println("Ievadiet grāmatas izlaišanas gadu:");
                    int izlaišana = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ievadiet grāmatas izdevēju:");
                    String izdevejs = scanner.nextLine();
                    Gramatas.findbook(new Gramatas(nosaukums, autors, izlaišana, izdevejs, izdevejs));
                }
                Thread.sleep(5000);
//444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
            } else if (choice.equals("4")) {
                System.out.print("Ievadi vārdu: ");
                String vards = scanner.nextLine();
                System.out.print("Ievadi uzvārdu: ");
                String uzvards = scanner.nextLine();
                System.out.print("Ievadi kontaktinformāciju: ");
                String kontakts = scanner.nextLine();
        
                Klients klients = new Klients(vards, uzvards, kontakts);
                Klients.addPerson(klients);
                System.out.println("Klients pievienots!");
                //5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555
                Thread.sleep(5000);
            } else if (choice.equals("5")) {
                ArrayList<Klients> klienti = Klients.getPersonsLists();
                for (Klients k : klienti) {
                    System.out.println(k);
                }
                //666666666666666666666666666666666666666666666666666666666666666666666666
                Thread.sleep(5000);
            } else if (choice.equals("6")) {//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                System.out.print("Ievadi klienta vārdu: ");
                String vards = scanner.nextLine();
                System.out.print("Ievadi klienta uzvārdu: ");
                String uzvards = scanner.nextLine();
                System.out.print("Ievadi klienta kontaktinfo: ");
                String kontaktinfo = scanner.nextLine();
                System.out.print("Ievadi grāmatas nosaukumu: ");
                String nosaukums = scanner.nextLine();
                System.out.print("Ievadi autoru: ");
                String autors = scanner.nextLine();
                System.out.print("Ievadi izdošanas gadu: ");
                int izdosana = Integer.parseInt(scanner.nextLine());
                System.out.print("Ievadi izdevēju: ");
                String izdevejs = scanner.nextLine();
        
             
                System.out.print("Ievadi termiņu (dienās): ");
                int termins = Integer.parseInt(scanner.nextLine());
        
                String result = Turetaj.takeBook(new Gramatas(nosaukums, autors,izdosana, izdevejs, "Pieejama"), new Klients(vards, uzvards, kontaktinfo), termins);
                System.out.println(result);
                Thread.sleep(5000);

                //77777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
            } else if (choice.equals("7")) {
                System.out.print("Ievadi klienta vārdu: ");
                String vards = scanner.nextLine();
                System.out.print("Ievadi klienta uzvārdu: ");
                String uzvards = scanner.nextLine();
                System.out.print("Ievadi kontaktinformāciju: ");
                String nosaukums = scanner.nextLine();
                //Gramatas izveide
                System.out.print("Ievadi grāmatas nosaukumu: ");
                String vardsgr = scanner.nextLine();
                System.out.print("Ievadi autora vārdu un uzvārdu: ");
                String uzvardsgr = scanner.nextLine();
                System.out.print("Ievadi Izdošanas gadu: ");
                int x = Integer.valueOf(scanner.nextLine());
                System.out.print("Ievadi Izdevēju: ");
                String izdevejs = scanner.nextLine();
                System.out.println(Turetaj.returnBook(new Gramatas(vardsgr, uzvardsgr, x, izdevejs, "Pieejama"), new Klients(vards, uzvards, nosaukums), 14));
        

        }
        else if (choice.equals("0")){
            break;
        }else if (choice.equals("8")){
            System.out.println("1. Dzēst grāmatu");
            System.out.println("2. Rediģēt grāmatu");
            String ievade = scanner.nextLine();
            
            if(ievade.equals("1")){
        System.out.print("Ievadi nosaukumu: ");
        String nosaukums = scanner.nextLine();
        System.out.print("Ievadi autoru: ");
        String autors = scanner.nextLine();
        System.out.print("Ievadi izdošanas gadu: ");
        int izdosana = Integer.parseInt(scanner.nextLine());
        System.out.print("Ievadi izdevēju: ");
        String izdevejs = scanner.nextLine();
        String pieejamiba = "Pieejama";

        Gramatas gramata = new Gramatas(nosaukums, autors, izdosana, izdevejs, pieejamiba);
        Gramatas gramata1 = new Gramatas(nosaukums, autors, izdosana, izdevejs, "Nepieejama");
        Gramatas.deleteBook(gramata);
        Gramatas.deleteBook(gramata1);
        System.out.println("Grāmata dzēsta");
    }else if(ievade.equals("2")){


    System.out.print("Ievadi nosaukumu: ");
    String nosaukums = scanner.nextLine();
    System.out.print("Ievadi autoru: ");
    String autors = scanner.nextLine();
    System.out.print("Ievadi izdošanas gadu: ");
    int izdosana = Integer.parseInt(scanner.nextLine());
    System.out.print("Ievadi izdevēju: ");
    String izdevejs = scanner.nextLine();
    String pieejamiba = "Pieejama";

    Gramatas gramata = new Gramatas(nosaukums, autors, izdosana, izdevejs, pieejamiba);
    
    System.out.print("Ievadi nosaukumu: ");
    nosaukums = scanner.nextLine();
    System.out.print("Ievadi autoru: ");
    autors = scanner.nextLine();
    System.out.print("Ievadi izdošanas gadu: ");
    izdosana = Integer.parseInt(scanner.nextLine());
    System.out.print("Ievadi izdevēju: ");
    izdevejs = scanner.nextLine();
    Gramatas gramata1 = new Gramatas(nosaukums, autors, izdosana, izdevejs, pieejamiba);
    Gramatas.editbook(gramata, gramata1);
    System.out.println("Grāmata mainīta");
    }
        Thread.sleep(5000);
        }else if (choice.equals("9")){
            System.out.print("Ievadi vārdu: ");
            System.out.println("1. Dzēst personu");
            System.out.println("2. Rediģēt personu");
            System.out.print("Ievadie izvēli:");
            String ievade = scanner.nextLine();
            if (ievade.equals(1)){
                System.out.print("Ievadi vārdu: ");
                String vards = scanner.nextLine();
                System.out.print("Ievadi uzvārdu: ");
                String uzvards = scanner.nextLine();
                System.out.print("Ievadi kontaktinformāciju: ");
                String kontakts = scanner.nextLine();
        
                Klients klients = new Klients(vards, uzvards, kontakts);
                Klients.deletePerson(klients);
            }else if(ievade.equals(2)){
                System.out.print("Ievadi vārdu: ");
                String vards = scanner.nextLine();
                System.out.print("Ievadi uzvārdu: ");
                String uzvards = scanner.nextLine();
                System.out.print("Ievadi kontaktinformāciju: ");
                String kontakts = scanner.nextLine();
        
                Klients klients = new Klients(vards, uzvards, kontakts);
                

                System.out.print("Ievadi jauno vārdu: ");
                vards = scanner.nextLine();
                System.out.print("Ievadi jauno uzvārdu: ");
                uzvards = scanner.nextLine();
                System.out.print("Ievadi jauno kontaktinformāciju: ");
                kontakts = scanner.nextLine();
        
                Klients klients2 = new Klients(vards, uzvards, kontakts);
                Klients.editPerson(klients, klients2);
            }
                
        }
    }

    
}

}