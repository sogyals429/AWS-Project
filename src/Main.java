import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    private static String userId;
    private static boolean tText;
    private static String rText;
    private static String option;
    private static Scanner scanner = new Scanner(System.in);
    private static DB db = new DB();
    private static ArrayList<String> details = new ArrayList<>();
    private static String textTranslate;
    private static Translate translate = new Translate();
    private static String translatedText;

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
        translatedText = translate.translateText(rText,"en",textTranslate);
        tText=true;
        db.addItems(userId,rText,translatedText,tText);
        details = db.loadTable();
        System.out.println(details);
        main.showMenu();
    }

    public void showMenu(){
        System.out.println("Enter user ID: " );
        userId = scanner.nextLine();
        System.out.println("Enter text to translate: ");
        rText = scanner.nextLine();

        System.out.println("Which language you want to translate to: ");
        System.out.println(
                "1) Arabic (ar)\n" +
                        "2) Chinese (Simplified) (zh)\n"+
                        "3) French (fr)\n"+
                        "4) German (de)\n" +
                        "5) Italian (it)\n" +
                        "6) Japanese (ja)\n" +
                        "7) Portuguese (pt)\n" +
                        "8) Russian (ru)\n" +
                        "9) Spanish (es)\n" +
                        "10) Turkish (tr)\n");

        System.out.println("Enter option: ");
        option = scanner.nextLine();
        switch (option){
            case "Arabic" :
            case "ar":
                if(option=="Arabic"){
                    textTranslate = option.replaceAll("Arabic","ar");
                }
                textTranslate = option;
                break;
            case "Chinese":
            case "zh":
                if(option=="Chinese"){
                    textTranslate = option.replace("Chinese","zh");
                }
                textTranslate = option;
                break;

            case "French":
            case "fr":
                if(option=="French"){
                    textTranslate = option.replace("French","fr");
                }
                textTranslate = option;
                break;
            case "German":
            case "de":
                if(option=="German"){
                    textTranslate = option.replace("German","de");
                }
                textTranslate = option;
                break;
            case "Italian":
            case "it":
                if(option=="Italian"){
                    textTranslate = option.replace("Italian","it");
                }
                textTranslate = option;
                break;
            case  "Japanese":
            case "ja":
                if(option=="Japanese"){
                    textTranslate = option.replace("Italian","ja");
                }
                textTranslate = option;
                break;
            case "Portuguese":
            case "pt":
                if(option=="Portuguese"){
                    textTranslate = option.replace("Portuguese","pt");
                }
                textTranslate = option;
                break;
            case "Russian":
            case "ru":
                if(option=="Russian"){
                    textTranslate = option.replace("Russian","ru");
                }
                textTranslate = option;
                break;
            case "Spanish":
            case "es":
                if(option=="Spanish"){
                    textTranslate = option.replace("Spanish","es");
                }
                textTranslate = option;
                break;
            case "Turkish":
            case "tr":
                if(option=="Turkish"){
                    textTranslate = option.replace("Turkish","tr");
                }
                textTranslate = option;
                break;

            default:
                System.out.println("Enter a valid destination language");
                break;

        }
    }

}
