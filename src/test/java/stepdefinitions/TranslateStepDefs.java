package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigWriter;
import utilities.FileBackupService;
import utilities.GoogleTranslateService;
import utilities.QuizService;

public class TranslateStepDefs {

    public static String green(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    public static String greenBold(String text) {
        return ANSI_GREEN_BOLD + text + ANSI_RESET;
    }

    public static String yellowBold(String text) {
        return ANSI_YELLOW_BOLD + text + ANSI_RESET;
    }

    public static String blue(String text) {
        return ANSI_BLUE + text + ANSI_RESET;
    }

    public static String cyan(String text) {
        return ANSI_CYAN + text + ANSI_RESET;
    }

    public static String redBold(String text) {
        return ANSI_RED_BOLD + text + ANSI_RESET;
    }

    public static String purple(String text) {
        return ANSI_PURPLE + text + ANSI_RESET;
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RED_BOLD = "\u001B[31;1m";
    public static final String ANSI_GREEN_BOLD = "\u001B[32;1m";
    public static final String ANSI_YELLOW_BOLD = "\u001B[33;1m";

    private String translatedText;

    @Given("User translates {string} to {string} language via API")
    public void userTranslatesToLanguageViaAPI(String word, String targetLang) throws InterruptedException {
        // IP sınırlamasına (429 Rate Limit) takılmamak için her istek öncesi 1.5 saniye bekleme
        Thread.sleep(1500);

        translatedText = GoogleTranslateService.translate(word, targetLang);
        System.out.println("Orijinal Metin: " + word + " ---> Çeviri: " + translatedText);

        System.out.println( greenBold("Orijinal Metin: ")  +redBold(word)+ greenBold(" ---> Çeviri: ") +redBold(translatedText));


    }



    @Then("User saves word {string} and its translation to config properties")
    public void userSavesWordAndItsTranslationToConfigProperties(String word) {
        String formattedKey = word.toLowerCase().replace(" ", "_");
        ConfigWriter.setProperty(formattedKey, translatedText);
    }

    @Given("User creates a {int} question quiz")
    public void userCreatesAQuestionQuiz(int count) {
        QuizService.generateQuiz(count);
    }

    @Given("User backups vocabulary from config to documents folder and clears config")
    public void userBackupsVocabularyFromConfigToDocumentsFolderAndClearsConfig() {
        FileBackupService.backupAndClearConfig();
    }
}