/**
 * Created by Håkon
 */
package Main;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import Forsikring.ReiseForsikring;
import Kontroller.Kontroller;
import Person.Kunde;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Kontroller c = new Kontroller(primaryStage);
        c.lesFil();
        //genererKunder(c); // GENERERER MASSE BRUKERE, GJØR PROGRAMMET TREIGT Å STARTE!
        primaryStage.setOnCloseRequest(e -> c.skrivTilFil());
        c.loginVindu(primaryStage);
        
    }
    // alt unner her genereing av kunder

    public void genererKunder(Kontroller c) {

        String[] fornavn = {"Vegard", "Hanne", "Stine", "Hans", "Trovald", "Ole", "Anne", "inger", "Kari", "Marit", "Ingrid", "Liv", "Eva", "Berit", "Astrid", "Bjørg", "Hilde", "Anna", "Solveig", "Marianne", "Randi", "Ida", "Nina", "Maria", "Elisabeth", "Kristin", "Bente", "Heidi", "Silje", "Gerd", "Linda", "Tone", "Tove", "Elin", "Anita", "Wenche", "Ragnhild", "Camilla", "Ellen", "Karin", "Hege", "Ann", "Else", "Mona", "Marie", "Aud", "Monica", "Julie", "Kristine", "Turid", "Laila", "Reidun", "Helene", "Åse", "Jorunn", "Sissel", "Mari", "Line", "Lene", "Mette", "Grethe", "Trine", "Unni", "Malin", "Grete", "Thea", "Gunn", "Emma", "May", "Ruth", "Lise", "Emilie", "Anette", "Kirsten", "Sara", "Nora", "Linn", "Eli", "Siri", "Cecilie", "Irene", "Marte", "Gro", "Britt", "Ingeborg", "Kjersti", "Janne", "Siv", "Sigrid", "Karoline", "Karen", "Vilde", "Martine", "Tonje", "Andrea", "Sofie", "Torill", "Synnøve", "Rita", "Jenny", "Cathrine", "Elise", "Maren", "Hanna", "Lillian", "Lena", "Brit", "Vigdis", "Therese", "Frida", "Amalie", "Ingvild", "Ingunn", "Bodil", "Charlotte", "Signe", "Lisbeth", "Sandra", "Christine", "Victoria", "Marthe", "Caroline", "Mia", "Tina", "Merete", "Oda", "Trude", "Vibeke", "Henriette", "Johanna", "Lisa", "Gunvor", "Katrine", "Mary", "Torunn", "Kirsti", "Beate", "Marita", "Christina", "Sonja", "Hedda", "Susanne", "Tuva", "Aslaug", "Gry", "Kristina", "Aase", "Toril", "Renate", "Kine", "Guro", "Maja", "Helga", "Mathilde", "Ane", "Aina", "Jeanette", "Sunniva", "Ingebjørg", "Eline", "Solfrid", "Rigmor", "Margit", "Gunhild", "Veronica", "Sølvi", "Ella", "Elsa", "Linnea", "Synne", "Birgit", "Kaja", "Anja", "Pernille", "Monika", "Gudrun", "Olaug", "Agnes", "Mina", "Aurora", "Magnhild", "Sarah", "Mariann", "Jorun", "Åshild", "Anne-Lise", "Pia", "Lill", "Kathrine", "Ina", "Julia", "Selma", "Celine", "Olga", "Margrethe", "Inga", "Hannah", "Karina", "Iselin", "Amanda", "Sigrun", "Miriam", "Erna", "Helen", "Torhild", "Benedicte", "Marta", "Birgitte", "Lilly", "Edith", "Evy", "Eirin", "Rikke", "Anniken", "Borghild", "June", "Karianne", "Tiril", "Martha", "Helle", "Carina", "Malene", "Svanhild", "Lina", "Klara", "Merethe", "Edel", "Annette", "Jane", "Anny", "Guri", "Sidsel", "Tordis", "Målfrid", "Leah", "Ellinor", "Hjørdis", "Tine", "Kamilla", "Rebecca", "Ester", "Live", "Kjellaug", "Astri", "Vera", "Siw", "Evelyn", "Maiken", "Dina", "Michelle", "Brita", "Jannicke", "Ine", "Alexandra", "Rebekka", "Oddny", "Dagny", "Torild", "Marion", "Eldbjørg", "Ann-Kristin", "Ada", "Hildegunn", "Madeleine", "Sofia", "Helena", "Greta", "Tora", "Judith", "Yvonne", "Elena", "Natalie", "Mathea", "Nathalie", "Ronja", "Oddbjørg", "Oddrun", "Vivian", "Frøydis", "Gina", "Madelen", "Haldis", "Borgny", "Ragna", "Alma", "Celina", "Laura", "Andrine", "Henny", "Josefine", "Solbjørg", "Lotte", "Rakel", "Ranveig", "Arnhild", "Hildur", "Lea", "Louise", "Stina", "Mai", "Benedikte", "Veronika", "Asbjørg", "Jan", "Per", "Bjørn", "Kjell", "Lars", "Arne", "Knut", "Svein", "Odd", "Tor", "Geir", "Terje", "Thomas", "Morten", "John", "Erik", "Anders", "Rune", "Martin", "Andreas", "Trond", "Tore", "Harald", "Olav", "Gunnar", "Jon", "Rolf", "Leif", "Tom", "Stian", "Kristian", "Nils", "Øyvind", "Helge", "Espen", "Einar", "Marius", "Kåre", "Daniel", "Magnus", "Fredrik", "Christian", "Steinar", "Eirik", "Håkon", "Øystein", "Henrik", "Frode", "Arild", "Ivar", "Jørgen", "Kjetil", "Frank", "Stein", "Johan", "Sverre", "Magne", "Petter", "Dag", "Alf", "Egil", "Vidag", "Vidar", "Stig", "Karl", "Jonas", "Pål", "Kenneth", "Tommy", "Roger", "Ola", "Kristoffer", "Erling", "Håvard", "Thor", "Reidar", "Eivind", "Asbjørn", "Finn", "Jens", "Roy", "Alexander", "Kim", "Torbjørn", "Bjarne", "Roar", "Simen", "Arvid", "Jarle", "Johannes", "Robert", "Sondre", "Mathias", "Ove", "Trygve", "Sigurd", "Sindre", "Jostein", "joakim", "erlend", "jørn", "oddvar", "andre", "atle", "ronny", "mats", "emil", "ragnar", "inge", "henning", "aleksander", "lasse", "paul", "even", "kai", "sander", "markus", "adrian", "johnny", "bjørnar", "arve", "tobias", "åge", "øivind", "sebastian", "david", "sven", "torstein", "christoffer", "robin", "peder", "bård", "benjamin", "audun", "birger", "glenn", "ståle", "kurt", "simon", "peter", "roald", "sigmund", "steffen", "mads", "torgeir", "jakob", "michael", "arnt", "willy", "joachim", "ørjan", "carl", "runar", "bernt", "marcus", "harry", "tormod", "halvor", "dagfinn", "arnfinn", "raymond", "truls", "william", "magnar", "olaf", "richard", "jonny", "mohammad", "christer", "elias", "oddbjørn", "cato", "ruben", "ketil", "endre", "oskar", "ulf", "herman", "kevin", "henry", "georg", "christopher", "kent", "yngve", "bent", "nikolai", "otto", "ottar", "are", "aksel", "haakon", "patrick", "dan", "bjarte", "karsten", "åsmund", "vetle", "sigbjørn", "isak", "tomas", "ingar", "ali", "preben", "edvard", "asle", "amund", "mikael", "oliver", "sivert", "børge", "aage", "fred", "gaute", "sveinung", "ernst", "oddmund", "jacob", "thorbjørn", "bengt", "sten", "trym", "nicolai", "bendik", "arthur", "jarl", "torleif", "alfred", "hallvar", "halvard", "tony", "jim", "jesper", "mikkel", "viggo", "idar", "anton", "oscar", "ingvar", "ken", "leiv", "mohamed", "jonathan", "snorre", "vegar", "gustav", "thore", "victor", "remi", "philip", "kasper", "tord", "vebjørn", "kolbjørn", "eskil", "stefan", "iver", "joar", "gjermund", "edvin", "rasmus", "viktor", "dennis", "sigve", "freddy", "mohammed", "ahmed", "brage", "gudmund", "arnold", "svenn", "kjartan", "gisle", "chris", "hugo", "sjur", "filip", "niklas", "torfinn", "øistein", "odin", "thorleif", "aslak", "asgeir", "ivan", "gard", "arnstein", "julian", "gøran", "ronald", "jan-Erik", "børre", "agnar", "axel", "edgar", "svend", "ulrik", "ingvald", "yngvar", "didrik", "kristen", "kaare", "paal", "gabriel", "august", "hallgeir", "kyrre", "theodor", "jone", "karstein", "tim", "albert", "ragnvald", "ludvig", "erland", "klaus", "kay", "eilif", "mikal", "noah", "matias", "brede", "guttorm", "ådne", "ingolf", "konrad", "jack", "eric", "arnulf", "bernhard", "tarjei", "wilhelm", "leon", "oddgeir", "toralf", "norvald", "samuel", "rene", "hassan", "krister", "Werner", "Casper", "Hermann", "Omar", "Rolv", "Hjalmar", "Nicholas", "adam", "fritz", "walter", "hilmar", "sturla", "charles", "vemund", "fabian", "edmund", "muhammad", "torjus", "jahn", "heine", "brynjar", "felix", "lukas", "mustafa", "njål", "torgrim", "ibrahim", "niels", "torkel", "torleiv", "abdul", "nicolay", "walid", "malvin", "max", "tron", "villy", "brian", "morgan", "allan", "torger", "hermod", "leo", "carsten", "eldar", "jonatan", "gunvald", "tage", "thorstein", "claus", "aron", "jørund", "gerhard", "rudi", "jimmy", "james", "Lars-Erik", "Rikard", "Birk", "Søren", "Elling", "Håvar", "fridtjof", "osvald", "jann", "amir", "lennart", "ahmad", "josef", "ludvik", "patrik", "jose", "thorvald", "ørnulf", "stephen", "wiggo", "eigil", "rudolf", "abdi", "ingebrigt", "oddvin", "mattis", "sture", "stephan", "ben", "ansgar", "Frederik", "Ole-Martin", "Lucas", "alv", "eyvind", "mehmet", "steven", "sigvald", "sølve", "torvald", "ask", "nicolas", "nicklas", "eilert", "eskild", "normann", "baard", "said", "teodor", "alan", "esben", "andrew", "mark", "syver", "brynjulf", "Hans-Petter", "aasmund", "Bror", "haldor", "remy", "steve", "joacim", "mons", "hogne", "ingve", "torben", "ian", "eystein", "kaj", "halfdan", "holger", "alex", "torje", "edward", "Ole-Kristian", "adnan", "rino", "leander", "gjert", "Kim-Andre", "syed", "hasan", "Sigfred", "lauritz", "Osman", "Carlos", "Hallstein", "Jean", "ronnie", "asmund", "juan", "frits", "marco", "gudbrand", "luis", "ismail", "Svein-Erik", "Niclas", "Torkild", "Thanh", "julius", "tonny", "khalid", "torkil", "mattias", "narve", "flemming", "viljar", "Tom-Erik", "annar", "anthony", "mario", "Per-Arne", "Kennet", "olve", "scott", "frithjof", "tarald", "samir", "phillip", "Tor-Erik", "kato", "hussein", "severin", "evald", "gorm", "joseph", "jonn", "Bjørn-Erik", "Johann", "laurits", "abdirahman", "Sean", "skjalg", "Jomar", "abdullah", "bertil", "oddleif", "benny", "andres", "leonard", "antonio", "Martinus", "torolf", "thoralf", "ahmet", "bjørge", "theo", "fredrick", "levi", "borgar", "ferdinand", "lorentz", "george", "torodd", "arnljot", "abdullahi", "jardar", "thormod", "bastian", "minh", "sigvart", "hamza", "Ole-Christian", "Tor-Arne", "Odvar", "Anfinn", "adolf", "andrzej", "Ingmar", "Louis", "Mathis", "Ole-Petter", "Christen", "Hamid", "Marvin", "Olai", "Jarand", "Joel", "Halvdan", "Per-Erik", "bilal", "piotr", "vilhelm", "eddie", "edin", "knud", "gert", "oluf", "artur", "Ole-Jørgen", "Yusuf", "tønnes", "Krzysztof", "reinert", "ted", "nikolas", "noralf", "øyvin", "halvar", "vincent", "enok", "herbjørn", "linus", "sam", "widar", "jamal", "erich", "gunder", "joen", "gulbrand", "michel", "tosten", "poul", "ellev", "siur", "arent", "biørn", "haagen", "hendrich", "abraham", "johanes", "henrich", "isabel", "Anne-Marie", "unn", "iris", "petra", "natalia", "Inger-Lise", "Olivia", "Oddveig", "Mille", "Margrete", "alice", "margot", "ingjerd", "tanja", "annie", "lone", "torbjørg", "kate", "esther", "sylvi", "marina", "Katarzyna", "emily", "isabell", "sylvia", "alfhild", "viktoria", "rannveig", "gunnhild", "Agnieszka", "barbro", "nelly", "magdalena", "May-Britt", "isabella", "margareth", "aleksandra", "ylva", "oline", "gjertrud", "iren", "margaret", "mariell", "christin", "Fatima", "audhild", "marlene", "vivi", "nadia", "hedvig", "elizabeth", "siren", "annika", "anine", "diane", "matilde", "erle", "kaia", "sanna", "jorid", "runa", "mie", "maya", "gøril", "vanja", "alva", "annbjørg", "katarina", "amina", "nancy", "sigrunn", "angelica", "thi", "joanna", "elisabet", "karine", "paula", "ingvill", "rønnaug", "norunn", "asta", "ana", "malgorzata", "inrina", "emilia", "iben", "regine", "oddlaug", "connie", "marielle", "gerda", "lovise", "barbara", "jeanett", "lisbet", "isabelle", "jessica", "sophie", "melissa", "elna", "cornelia", "venke", "bergljot", "herdis", "susann", "Anne-Grethe", "adele", "Milla", "Signy", "Mildrid", "Ulla", "Elida", "Vanessa", "Åsta", "Dagmar", "Ewa", "Kristi", "Harriet", "Julianne", "Valborg", "Tomine", "Karolina", "terese", "arna", "stella", "sanne", "mali", "dagrun", "birthe", "kitty", "cecilia", "elina", "margunn", "maia", "brynhild", "susan", "katharina", "bettina", "Ann-Mari", "tilde", "Beathe", "Alina", "Liss", "Birte", "Jannike", "Carmen", "Torun", "Elisa", "Jennifer", "Mira", "Kjerstin", "Åsa", "Thale", "Ingun", "Åsne", "Gunnvor", "Eira", "Linea", "Mariam", "Idun", "Christel", "Brith", "Maryam", "Ulrikke", "Torgunn", "Svetlana", "Anne-Karin", "Amelia", "Una", "Inger-Johanne", "Nanna", "Halldis", "Aisha", "Veslemøy", "Anneli", "fanny", "hermine", "Zahra", "gretha", "eileen", "beata", "ågot", "synøve", "gitte", "tatiana", "annlaug", "janicke", "reidunn", "elvira", "elly", "alvhild", "Ann-Karin", "Lydia", "Rachel", "Fride", "Doris", "Erica", "Sina", "Agnete", "Pauline", "Renata", "Ingfrid", "Ann-Helen", "Aida", "Kristiane", "Embla", "Solvor", "Sophia", "Jill", "Kari-Anne", "Marian", "Patricia", "Maj", "Ebba", "Kjellrun", "Nicole", "Catharina", "Ingerid", "Vilma", "Tale", "Jolanta", "Anni", "Anett", "Kjellfrid", "Jolene", "Daniela", "Kaisa", "Eldrid", "Katrin", "elen", "silja", "Magda", "alida", "kerstin", "lilli", "Anne-Britt", "Claudia", "Alise", "Dorota", "Mirjam", "Marlen", "Rose", "Lykke", "Yasmin", "Sigfrid", "Paulina", "Katja", "Luna", "Nicoline", "Sol", "Simone", "Silvia", "Adriana", "Frøya", "Snefrid", "Sylwia", "samira", "catrine", "betty", "thora", "Anne-Grete", "Irmelin", "Elzbieta", "Ann-Christin", "Gudny", "Angela", "Vilja", "Elfrid", "Juliane", "Solvår", "Lin", "Anlaug", "Jofrid", "Dorthe", "Agnethe", "Ramona", "Gunnlaug", "Annelise", "Ingelin", "Christiane", "Stephanie", "Cassandra", "Magny", "Irma", "Edna", "Vibecke", "Iwona", "Edle", "Turi", "Kajsa", "Janet", "Valentina", "Ingri", "Maud", "Justyna", "Herborg", "Gyda", "Nikoline", "fatma", "teresa", "wenke", "filippa", "lotta", "tara", "emine", "Anne-Berit", "Aasta", "Gabriela", "åslaug", "Juni", "Anne-Mette", "Leila", "Fadumo", "Tea", "Leonora", "Gudveig", "Rut", "Katinka", "Jasmin", "Magna", "Solrun", "Idunn", "Anbjørg", "Regina", "iman", "eivor", "emmy", "bertha", "Anne-Mari", "Lilja", "Jelena", "Fredrikke", "Martina", "Clara", "Gun", "Rosa", "Bertine", "Marry", "Kathe", "Josephine", "Tatjana", "Amy", "Belinda", "Aagot", "Sonia", "Aashild", "gunnbjørg", "elinor", "magni", "ninni", "Trine-Lise", "Mari-Ann", "Bianca", "Tyra", "Suzanne", "Wiktoria", "Peggy", "Agata", "Izabela", "Aneta", "Ailin", "Sahra", "Cathrin", "Angelika", "Siril", "Møyfrid", "Salma", "Sabrina", "Wilma", "Jana", "Venche", "Rebecka", "Sabine", "Inger-Marie", "Gunda", "Thelma", "Naomi", "Elbjørg", "Vårin", "Dorthea", "Kamila", "Tamara", "Khadilja", "Liva", "Hulda", "Anne-Sofie", "cristina", "serine", "hennie", "gabriella", "beatrice", "alvilde", "mariel", "melina", "amal", "jennie", "hitler", "aylar", "pamela", "donald", "tarzan", "mullah", "son", "Sokrates", "Marve"};
        String[] mellomnavn = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "Ese", "Werner", "hogne", "gamst", "loe", "møller", "Hansen", "klepp", "nordhagen", "nergård", "froholt", "nyberg", "nesset", "fandevik", "nymo", "heung", "sung", "bredal", "omdal", "opdal", "Prestegård", "pilskog", "parveen", "palm", "hadler", "ravndal", "reiersen", "reime", "resell", "Ribe", "Riis", "rinde", "risa", "rokne", "rosenvinge", "sandli", "sand", "salte", "sandve", "Schanche", "schei", "schjetne", "schjølberg", "schou", "schrøder", "selle", "Sem", "Semb", "sirevåg", "sirnes", "Sjo", "Aarstad", "sjaastad", "skaar", "skei", "skinnes", "skjelvik", "skjelbred", "skjerping", "takle", "tande", "telle", "tenold", "tessem", "thon", "tjelle", "tidemann", "tjessem", "toft", "ueland", "undheim", "Keti", "utsi", "ulven", "undrum", "ulland", "ursin", "vaa", "vaage", "vabø", "vagle", "valde", "valla", "valle", "valvik", "valø", "vang", "velle", "venås", "veum", "vie", "vigdal", "wold", "wiik", "wang", "waage", "wahl", "wik", "wangen", "waaler", "winge", "woll", "worren", "wulff", "yri", "yttervik", "ytreland", "zahl", "åkre", "åsebø", "østby", "øye", "øen", "østli", "øksnes", "øwre", "øyan", "nes", "nesse", "ness", "nordbø", "norum", "nordahl", "nybø", "nylund", "nordås", "norberg", "nesje", "Ngo", "nydal", "nyhagen", "nesbø", "nævdal", "narum", "moen", "moe", "meyer", "melby", "mork", "mørk", "midtbø", "mæland", "myhre", "midtun", "myrvoll", "myller", "mjøs", "myhr", "minde", "molnes", "myre", "misje", "moum", "misund", "mittet", "malm", "minge", "molvær", "muren", "moholt", "meek", "mæle", "mehl", "meier", "mogen", "lie", "lund", "lian", "lervik", "lohne", "lange", "løland", "liland", "lothe", "lyng", "lundby", "lode", "langås", "leknes", "lunder", "lindahø", "lindahl", "løvli", "linde", "langli", "liseth", "kleppe", "kvamme", "kvam", "krogh", "kjær", "kvåle", "kroken", "kvalvik", "korsnes", "kjos", "kildal", "kolberg", "krohn", "kaland", "kolnes", "krog", "kjølstad", "kruse", "jørstad", "jama", "jordal", "jahren", "juvik", "jevne", "juul", "jæger", "jentoft", "juell", "jordan", "iden", "idsø", "ihle", "igland", "indahl", "ihlen", "istad", "idland", "holm", "hauge", "hoel", "holmen", "hoff", "hamre", "helle", "holen", "husby", "holte", "haugan", "holt", "hovde", "holst", "holter", "holthe", "hope", "huse", "haugerud", "hernes", "hvidsten", "holdstad", "hals", "holand", "holme", "holtet", "haukås", "hovda", "hellum", "hage", "holden", "haave", "høydal", "hauan", "håvik", "heier", "heggland", "horgen", "hætta", "høiby", "hestad", "hasle", "heldal", "haavik", "hopen", "hynne", "grande", "gran", "gjerde", "grønvold", "granli", "gilje", "grønli", "grønning", "giske", "granheim", "grøndahl", "granum", "gjelsvik", "granberg", "greiner", "gaarder", "grimsrud", "groven", "grinde", "grytten", "godø", "Gaup", "grini", "gustad", "grøtte", "grønstad", "grøtting", "guddal", "graff", "gjelstad", "gjendem", "gunnerud", "grongstad", "gill", "glesnes", "granly", "grue", "groth", "gjestvang", "grønningsæter", "fredheim", "finstad", "fosse", "fjeld", "foss", "fagerli", "furuseth", "falch", "fauske", "fjell", "furulund", "friis", "finne", "furu", "fure", "fagerland", "fylling", "fornes", "fossdal", "frøland", "flem", "fossli", "fiskum", "fallet", "fjærli", "flaa", "formo", "flatebø", "furunes", "farestveit", "forland", "eide", "engen", "enger", "ervik", "evjen", "eidem", "eng", "eik", "engang", "engan", "egge", "erstad", "eie", "eid", "eira", "edland", "engelstad", "egeberg", "eike", "espe", "ege", "engebakken", "ersland", "engstrøm", "eknes", "engevik", "eikås", "engdal", "ekerhovd", "egeli", "engum", "eidsvik", "elvebakk", "evju", "endal", "eltvik", "dahl", "dale", "dybvik", "dreyer", "dalland", "dalheim", "dimmen", "daae", "dirdal", "digernes", "dyrstad", "dalby", "drage", "digre", "devik", "devold", "djønne", "dybwad", "derås", "dragland", "djuve", "dalaker", "Celius", "carlson", "berg", "bergh", "bakke", "berge", "bøe", "brekke", "bjerke", "breivik", "bye", "borge", "bolstad", "bergli", "blindheim", "bang", "bugge", "brenden", "brenna", "bergum", "brun", "bjerknes", "blom", "braaten", "bjørke", "buer", "bralie", "borg", "beck", "birkelund", "blix", "bull", "bjordal", "bore", "bauge", "bru", "brox", "bryhn", "børve", "bolme", "bjerga", "berdal", "busch", "brunstad", "aas", "aune", "ask", "aakre", "alstad", "aarseth", "almås", "alvestad", "alme", "aarnes", "amdal", "angell", "aass", "aske", "aarvik", "apeland", "aasbø", "aardal", "alfsen", "Aker", "aarø", "aanes", "ausland", "asphaug", "aakvik", "aspaas", "aksdal", "askim", "astrup", "aunan", "anwar", "aaby", "aurstad", "aabel", "alsvik", "angvik", "aabø", "aaseth", "andvik", "aarflot", "aam", "amble", "aae", "alver", "aallum", "amdam", "aandahl"};

        String[] etternavn = {"Andersen", "Andreassen", "Amundsen",
            "Andresen", "Aas", "Arnesen", "Antonsen", "Aasen", "Aune", "Abrahamsen", "Ali",
            "Ahmed", "Aase", "Abraham", "Arntsen", "Andersson", "Arntzen", "Aamodt", "Aasheim",
            "Aronsen", "Ask", "Austad", "Askeland", "Alstad", "Aasland", "Aslaksen", "Almås",
            "Akselsen", "Adolfsen", "Aksnes", "Aarseth", "Alvestad", "Aakre", "Asbjørnsen",
            "Akhtar", "Albertsen", "Amdal", "Albrigtsen", "Aarnes", "Abelsen", "Persen", "Aaserud",
            "Angell", "Anderson", "Aspeland", "Aspelid", "Aasbø", "Arvesen", "Aasgaard",
            "Aleksandersen", "Aure", "Alm", "Aalberg", "Asheim", "Aarhus", "Angelsen",
            "Alfsen", "Alfredsen", "Axelsen", "Aarø", "Ausland", "Aasebø", "Aulie", "Arneberg", "Aaberg",
            "Aanestad", "Arnestad", "Aker", "Anfinsen", "Aaslund", "Askvik", "Aagesen", "Asp", "Berg", "Bakken",
            "Bakke", "Berntsen", "Berge", "Bråthen", "Brekke", "Bøe", "Breivik", "Berger", "Borge", "Børresen",
            "Berget", "Bjelland", "Bolstad", "Bergersen", "Bredesen", "Bjørnsen", "Bugge", "Bang", "Bergan",
            "Benjaminsen", "Bertelsen", "Barstad", "Bekken", "Bergh", "Bergli", "Brenden", "Berntzen", "Bruun",
            "Blindheim", "Brenna", "Bårdsen", "Brun", "Begum", "Bentzen", "Bekkelund", "Bjørke", "Byberg", "Brandal",
            "Buer", "Bratlie", "Birkelund", "Beck", "Norge", "Bragesen", "Barli", "Brandt", "Bruland", "Bertheussen", "Berentsen", "Kristiansen", "Kraft", "Bull", "Bech", "Brynhildsen", "Brovold", "Blix", "Brekken", "Berland", "Bratli",
            "Mikkelsen", "Martiniusen", "Karlsen", "Karihaugen", "Christensen", "Carlsen", "Caspersen", "Corneliussen", 
            "Chen", "Claussen", "Carlsson", "Christiansen", "Cappelen", "Celius", "Carlson", "Chaudhry", "Clausen", "Dahl", "Danielsen", "Dahle", "Dale", "Dalen", "Davidsen", "Fredriksen", "Didriksen", "Dybvik", "Dokken", "Drange", "Dammen", "Dahlberg", "Dreyer", "Dyrnes", 
            "Dybdahl", "Dalland", "Djupvik", "Dørum", "Dalheim", "Dalby", "Dimmen", "Dahlstrøm", "Daae", 
            "Ditlefsen", "Dyb", "Dirdal", "Digernes", "Dyrstad", "Dang", "Dyrdal", "Drage", "Dalene", 
            "Dyngeland", "Dehli", "Dæhli", "Dæhlie", "Drønen", "Dagsland", "Drabløs", "Drivenes", "Dalhaug", "duong", 
            "Digre", "Dyrøy", "Devik", "Devold", "Djønne", "Daleng", "Dyrkorn", "Dragland", "Dybwad", "Derås", 
            "Østlund", "Nossum",
            "Rimmen",
            "Fleksnes"};

        // System.out.println(fornavn.length*etternavn.length+" Mulige kombinasjoner av generete brukere, er det flere en dett går genereign metoden i evig løkke");
        // 1674674
        Random randomGenerator = new Random();

        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2013, 2015);
        int dayOfYear;
        if (year == 2015) {
            dayOfYear = 160;
        } else {
            dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        }
        gc.set(gc.YEAR, year);
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        int personnr = (999 + randomGenerator.nextInt(9999));
        int perssnr = (999 + randomGenerator.nextInt(9999));
        String persondnr = Integer.toString(personnr);
        persondnr += Integer.toString(perssnr);
        int telefon = 1 + randomGenerator.nextInt(99999999);
        String epost1 = "";
        String epost = "@hioa.no";
        String adresse = "St. Olavs plass";
        String postadresse = "1413";

        for (int j = 0; j < 1; j++) {

            for (int i = 0; i < etternavn.length; i++) {
                personnr = (999 + randomGenerator.nextInt(9999));
                perssnr = (999 + randomGenerator.nextInt(9999));
                persondnr = Integer.toString(personnr);
                persondnr += Integer.toString(perssnr);
                telefon = 1 + randomGenerator.nextInt(99999999);
                String forrnavn = fornavn[randomGenerator.nextInt(fornavn.length)];
                String etternavne = etternavn[randomGenerator.nextInt(etternavn.length)];
                

                epost1 = forrnavn + epost;

                List<Kunde> liste = c.søkeResultater(forrnavn, etternavne, "0");
                for (Kunde ku : liste) {
                    while ((ku.getFornavn().equals(forrnavn)) && (ku.getEtternavn().equals(etternavne))) {
                        forrnavn = fornavn[randomGenerator.nextInt(fornavn.length)];
                        etternavne = etternavn[randomGenerator.nextInt(etternavn.length)];

                        epost1 = forrnavn + epost;
                    }

                }
                forrnavn = stringforbokstav(forrnavn);
                etternavne = stringforbokstav(etternavne);
                Kunde k = new Kunde(forrnavn, etternavne, persondnr, Integer.toString(telefon),
                        epost1, adresse, postadresse, "pas");

                c.registrerBruker(k);
                c.setInnloggetBruker(k.getNøkkel());

                c.setReiseForsikring(reise("Verden"));
                c.setReiseForsikring(reise("Europa"));
                c.setReiseForsikring(reise("Norden"));
                BilForsikring bil = new BilForsikring(40, 6000, 10000, "AC32123", "BWM", "530xd", "1991", 60000);

                bil.setGenerertDato(dato());
                c.setBilForsikring(bil, k);

                c.setBoligForsikring(true, 40, "Pilestredet 39", "Leilighet", year, "Mur", "Gjennomsnittlig", 300000, 1000000);
                BatForsikring båt = new BatForsikring(100000, 25, "ADC123", "Tresnekke", "Feri", "1945", 22, "Alta");
                båt.beregnOgSetEgenAndel();
                båt.beregnOgSetPremie();
                båt.setGenerertDato(dato());
                c.setBåtForsikring(båt);
                c.setFritidsForsikring(true, 22, "Ekkornveien 63 C", "Leilighet", year, "Mur", "Gjennomsnittlig", 150000, 600000);

            }
        }

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public ReiseForsikring reise(String type) {
        ReiseForsikring r = new ReiseForsikring();
        r.setType(type);
        r.setPremieOgForsSum(type);
        r.setGenerertDato(dato());
        return r;
    }

    public GregorianCalendar dato() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2013, 2015);
        int dayOfYear;
        if (year == 2015) {
            dayOfYear = randBetween(1, 130);
        } else {
            dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        }
        gc.set(gc.YEAR, year);
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc;
    }

    public String stringforbokstav(String forrnavn) {
        String aa = Character.toString(forrnavn.charAt(0));
        aa = aa.toUpperCase();
        String bb;
        forrnavn = forrnavn.substring(1);
        forrnavn = aa + forrnavn;
        
        return forrnavn;
    }

}//End of class
