package lv.rvt;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(ConsoleColors.CYAN + "\n===== Bibliotēkas Sistēma =====" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "1. Pievienot jaunu grāmatu" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2. Parādīt visas grāmatas" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "3. Meklēt grāmatu" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "4. Pievienot jaunu klientu" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "5. Parādīt visus klientus" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "6. Klients paņem grāmatu" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "7. Klients atdod grāmatu" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "8. Dzēsts vai rediģēt grāmatu" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "9. Dzēst vai rediģet klientu" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "10. meklēt klietus" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "0. Iziet" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN + "Izvēlies opciju: " + ConsoleColors.RESET);

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print(ConsoleColors.GREEN + "Ievadi nosaukumu: " + ConsoleColors.RESET);
                String nosaukums = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi autoru: " + ConsoleColors.RESET);
                String autors = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi izdošanas gadu: " + ConsoleColors.RESET);
                int izdosana = Integer.parseInt(scanner.nextLine());
                System.out.print(ConsoleColors.GREEN + "Ievadi izdevēju: " + ConsoleColors.RESET);
                String izdevejs = scanner.nextLine();
                String pieejamiba = "Pieejama";

                Gramatas gramata = new Gramatas(nosaukums, autors, izdosana, izdevejs, pieejamiba);
                Gramatas.addBook(gramata);
                System.out.println(ConsoleColors.GREEN + "Grāmata pievienota!" + ConsoleColors.RESET);
                Thread.sleep(4000);
                clearConsole();

            } else if (choice.equals("2")) {
                System.out.println(ConsoleColors.CYAN + "1 Nekārtot" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN + "2 Kārtot pēc nosaukuma" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.CYAN + "3 Kārtot pēc autora" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.GREEN + "Izvēlies opciju: " + ConsoleColors.RESET);
                String izvele = scanner.nextLine();

                if (izvele.equals("1")) {
                    ArrayList<Gramatas> personlist = Gramatas.getBookLists();

                    System.out.printf("+------------------------------+--------------------------+--------+--------------------------+-------------+\n");
                    System.out.printf("| Nosaukums                    | Autors                   | Gads   | Izdevējs                 | Pieejamība  |\n");
                    System.out.printf("+------------------------------+--------------------------+--------+--------------------------+-------------+\n");

                    for (Gramatas gr : personlist) {
                        System.out.printf("| %-28s | %-24s | %-6d | %-24s | %-11s |\n",
                                gr.getname(),
                                gr.getautors(),
                                gr.getidosana(),
                                gr.getizdevejs(),
                                gr.Pieejamība()
                        );
                    }

                    System.out.printf("+------------------------------+--------------------------+--------+--------------------------+-------------+\n");
                } else if (izvele.equals("2")) {
                    Gramatas.shortByName();
                } else if (izvele.equals("3")) {
                    Gramatas.shortByAuthor();
                }
                Thread.sleep(4000);
                clearConsole();

            } else if (choice.equals("3")) {

                System.out.println(ConsoleColors.BLUE + "1. Meklēt pēc Grāmatas nosaukuma" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "2. Meklēt pēc Autora" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "3. Meklēt pēc visiem parametriem" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.GREEN + "izdari izvēli: " + ConsoleColors.RESET);
                String izvele1 = scanner.nextLine();

                if (izvele1.equals("1")) {
                    System.out.println(ConsoleColors.GREEN + "Ievadiet grāmatas nosaukumu:" + ConsoleColors.RESET);
                    String nosaukums3 = scanner.nextLine();
                    System.out.println(Gramatas.findbookbynosaukums(nosaukums3));
                } else if (izvele1.equals("2")) {
                    System.out.println(ConsoleColors.GREEN + "Ievadiet grāmatas autoru:" + ConsoleColors.RESET);
                    String nosaukums2 = scanner.nextLine();
                    System.out.println(Gramatas.findbookbyautors(nosaukums2));
                } else if (izvele1.equals("3")) {
                    System.out.println(ConsoleColors.GREEN + "Ievadiet grāmatas nosaukumu:" + ConsoleColors.RESET);
                    String nosaukums = scanner.nextLine();
                    System.out.println(ConsoleColors.GREEN + "Ievadiet grāmatas autoru:" + ConsoleColors.RESET);
                    String autors = scanner.nextLine();
                    System.out.println(ConsoleColors.GREEN + "Ievadiet grāmatas izlaišanas gadu:" + ConsoleColors.RESET);
                    int izlaišana = Integer.parseInt(scanner.nextLine());
                    System.out.println(ConsoleColors.GREEN + "Ievadiet grāmatas izdevēju:" + ConsoleColors.RESET);
                    String izdevejs = scanner.nextLine();
                    Gramatas.findbook(new Gramatas(nosaukums, autors, izlaišana, izdevejs, izdevejs));
                }
                Thread.sleep(4000);
                clearConsole();

            } else if (choice.equals("4")) {
                System.out.print(ConsoleColors.GREEN + "Ievadi vārdu: " + ConsoleColors.RESET);
                String vards = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi uzvārdu: " + ConsoleColors.RESET);
                String uzvards = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi kontaktinformāciju: " + ConsoleColors.RESET);
                String kontakts = scanner.nextLine();

                Klients klients = new Klients(vards, uzvards, kontakts);
                Klients.addPerson(klients);
                System.out.println(ConsoleColors.GREEN + "Klients pievienots!" + ConsoleColors.RESET);
                Thread.sleep(4000);
                clearConsole();

            } else if (choice.equals("5")) {
                ArrayList<Klients> klienti = Klients.getPersonsLists();

                // Galvene
                System.out.printf("+----------------------+----------------------+-----------------------------+\n");
                System.out.printf("| Vārds                | Uzvārds              | Kontaktinformācija          |\n");
                System.out.printf("+----------------------+----------------------+-----------------------------+\n");

                for (Klients k : klienti) {
                    System.out.printf("| %-20s | %-20s | %-27s |\n",
                            k.getname(),
                            k.getLastnamme(),
                            k.getKontakinfo()
                    );
                }

                System.out.printf("+----------------------+----------------------+-----------------------------+\n");
                Thread.sleep(4000);
                clearConsole();
            } else if (choice.equals("6")) {
                ArrayList<Klients> klienti = Klients.getPersonsLists();

                System.out.printf("+----------------------+----------------------+-----------------------------+\n");
                System.out.printf("| Vārds                | Uzvārds              | Kontaktinformācija          |\n");
                System.out.printf("+----------------------+----------------------+-----------------------------+\n");

                for (Klients k : klienti) {
                    System.out.printf("| %-20s | %-20s | %-27s |\n",
                            k.getname(),
                            k.getLastnamme(),
                            k.getKontakinfo()
                    );
                }
                System.out.printf("+----------------------+----------------------+-----------------------------+\n");
                Gramatas.shortByName();

                System.out.print(ConsoleColors.GREEN + "Ievadi klienta vārdu: " + ConsoleColors.RESET);
                String vards = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi klienta uzvārdu: " + ConsoleColors.RESET);
                String uzvards = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi klienta kontaktinfo: " + ConsoleColors.RESET);
                String kontaktinfo = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi grāmatas nosaukumu: " + ConsoleColors.RESET);
                String nosaukums = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi autoru: " + ConsoleColors.RESET);
                String autors = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi izdošanas gadu: " + ConsoleColors.RESET);
                int izdosana = Integer.parseInt(scanner.nextLine());
                System.out.print(ConsoleColors.GREEN + "Ievadi izdevēju: " + ConsoleColors.RESET);
                String izdevejs = scanner.nextLine();

                System.out.print(ConsoleColors.GREEN + "Ievadi termiņu (dienās): " + ConsoleColors.RESET);
                int termins = Integer.parseInt(scanner.nextLine());

                String result = Turetaj.takeBook(new Gramatas(nosaukums, autors, izdosana, izdevejs, "Pieejama"), new Klients(vards, uzvards, kontaktinfo), termins);
                System.out.println(result);
                Thread.sleep(4000);
                clearConsole();

            } else if (choice.equals("7")) {
                ArrayList<Klients> klienti = Klients.getPersonsLists();

                System.out.printf("+----------------------+----------------------+-----------------------------+\n");
                System.out.printf("| Vārds                | Uzvārds              | Kontaktinformācija          |\n");
                System.out.printf("+----------------------+----------------------+-----------------------------+\n");

                for (Klients k : klienti) {
                    System.out.printf("| %-20s | %-20s | %-27s |\n",
                            k.getname(),
                            k.getLastnamme(),
                            k.getKontakinfo()
                    );
                }
                System.out.printf("+----------------------+----------------------+-----------------------------+\n");
                System.out.println(Turetaj.getLists());

                System.out.print(ConsoleColors.GREEN + "Ievadi klienta vārdu: " + ConsoleColors.RESET);
                String vards = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi klienta uzvārdu: " + ConsoleColors.RESET);
                String uzvards = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi kontaktinformāciju: " + ConsoleColors.RESET);
                String nosaukums = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi grāmatas nosaukumu: " + ConsoleColors.RESET);
                String vardsgr = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi autora vārdu un uzvārdu: " + ConsoleColors.RESET);
                String uzvardsgr = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi Izdošanas gadu: " + ConsoleColors.RESET);
                int x = Integer.valueOf(scanner.nextLine());
                System.out.print(ConsoleColors.GREEN + "Ievadi Izdevēju: " + ConsoleColors.RESET);
                String izdevejs = scanner.nextLine();
                System.out.println(Turetaj.returnBook(new Gramatas(vardsgr, uzvardsgr, x, izdevejs, "Pieejama"), new Klients(vards, uzvards, nosaukums), 14));
                Thread.sleep(4000);
                clearConsole();

            } else if (choice.equals("0")) {
                break;
            } else if (choice.equals("8")) {
                System.out.println(ConsoleColors.BLUE + "1. Dzēst grāmatu" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "2. Rediģēt grāmatu" + ConsoleColors.RESET);
                String ievade = scanner.nextLine();

                if (ievade.equals("1")) {
                    System.out.print(ConsoleColors.GREEN + "Ievadi nosaukumu: " + ConsoleColors.RESET);
                    String nosaukums = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi autoru: " + ConsoleColors.RESET);
                    String autors = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi izdošanas gadu: " + ConsoleColors.RESET);
                    int izdosana = Integer.parseInt(scanner.nextLine());
                    System.out.print(ConsoleColors.GREEN + "Ievadi izdevēju: " + ConsoleColors.RESET);
                    String izdevejs = scanner.nextLine();
                    String pieejamiba = "Pieejama";

                    Gramatas gramata = new Gramatas(nosaukums, autors, izdosana, izdevejs, pieejamiba);
                    Gramatas gramata1 = new Gramatas(nosaukums, autors, izdosana, izdevejs, "Nepieejama");
                    Gramatas.deleteBook(gramata);
                    Gramatas.deleteBook(gramata1);
                    System.out.println(ConsoleColors.RED + "Grāmata dzēsta" + ConsoleColors.RESET);

                } else if (ievade.equals("2")) {

                    System.out.print(ConsoleColors.GREEN + "Ievadi nosaukumu: " + ConsoleColors.RESET);
                    String nosaukums = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi autoru: " + ConsoleColors.RESET);
                    String autors = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi izdošanas gadu: " + ConsoleColors.RESET);
                    int izdosana = Integer.parseInt(scanner.nextLine());
                    System.out.print(ConsoleColors.GREEN + "Ievadi izdevēju: " + ConsoleColors.RESET);
                    String izdevejs = scanner.nextLine();
                    String pieejamiba = "Pieejama";

                    Gramatas gramata = new Gramatas(nosaukums, autors, izdosana, izdevejs, pieejamiba);

                    System.out.print(ConsoleColors.GREEN + "Ievadi nosaukumu: " + ConsoleColors.RESET);
                    nosaukums = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi autoru: " + ConsoleColors.RESET);
                    autors = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi izdošanas gadu: " + ConsoleColors.RESET);
                    izdosana = Integer.parseInt(scanner.nextLine());
                    System.out.print(ConsoleColors.GREEN + "Ievadi izdevēju: " + ConsoleColors.RESET);
                    izdevejs = scanner.nextLine();
                    Gramatas gramata1 = new Gramatas(nosaukums, autors, izdosana, izdevejs, pieejamiba);
                    Gramatas.editbook(gramata, gramata1);
                    System.out.println(ConsoleColors.GREEN + "Grāmata mainīta" + ConsoleColors.RESET);
                }
                Thread.sleep(4000);
                clearConsole();

            } else if (choice.equals("9")) {
                System.out.println(ConsoleColors.BLUE + "1. Dzēst personu" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.BLUE + "2. Rediģēt personu" + ConsoleColors.RESET);
                System.out.print(ConsoleColors.GREEN + "Ievadie izvēli: " + ConsoleColors.RESET);
                String ievade = scanner.nextLine();
                if (ievade.equals("1")) {
                    System.out.print(ConsoleColors.GREEN + "Ievadi vārdu: " + ConsoleColors.RESET);
                    String vards = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi uzvārdu: " + ConsoleColors.RESET);
                    String uzvards = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi kontaktinformāciju: " + ConsoleColors.RESET);
                    String kontakts = scanner.nextLine();

                    Klients klients = new Klients(vards, uzvards, kontakts);
                    Klients.deletePerson(klients);
                } else if (ievade.equals("2")) {
                    System.out.print(ConsoleColors.GREEN + "Ievadi vārdu: " + ConsoleColors.RESET);
                    String vards = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi uzvārdu: " + ConsoleColors.RESET);
                    String uzvards = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi kontaktinformāciju: " + ConsoleColors.RESET);
                    String kontakts = scanner.nextLine();

                    Klients klients = new Klients(vards, uzvards, kontakts);

                    System.out.print(ConsoleColors.GREEN + "Ievadi jauno vārdu: " + ConsoleColors.RESET);
                    vards = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi jauno uzvārdu: " + ConsoleColors.RESET);
                    uzvards = scanner.nextLine();
                    System.out.print(ConsoleColors.GREEN + "Ievadi jauno kontaktinformāciju: " + ConsoleColors.RESET);
                    kontakts = scanner.nextLine();

                    Klients klients2 = new Klients(vards, uzvards, kontakts);
                    Klients.editPerson(klients, klients2);
                    Thread.sleep(4000);
                    clearConsole();
                }

            } else if (choice.equals("10")) {
                System.out.print(ConsoleColors.GREEN + "Ievadi vārdu: " + ConsoleColors.RESET);
                String vards = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi uzvārdu: " + ConsoleColors.RESET);
                String uzvards = scanner.nextLine();
                System.out.print(ConsoleColors.GREEN + "Ievadi kontaktinformāciju: " + ConsoleColors.RESET);
                String kontakts = scanner.nextLine();

                Klients klients = new Klients(vards, uzvards, kontakts);
                Klients.findperson(klients);
                Thread.sleep(4000);
                clearConsole();
            }
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
