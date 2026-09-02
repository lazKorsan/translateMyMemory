package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigWriter;
import utilities.GoogleTranslateService;

public class TranslateStepDefs {

    private String translatedText;

    @Given("User translates {string} to {string} language via API")
    public void userTranslatesToLanguageViaAPI(String word, String targetLang) throws InterruptedException {
        // IP sınırlamasına (429 Rate Limit) takılmamak için her istek öncesi 1.5 saniye bekleme
        Thread.sleep(1500);

        translatedText = GoogleTranslateService.translate(word, targetLang);
        System.out.println("Orijinal Metin: " + word + " ---> Çeviri: " + translatedText);
    }

    @Then("User saves word {string} and its translation to config properties")
    public void userSavesWordAndItsTranslationToConfigProperties(String word) {
        String formattedKey = word.toLowerCase().replace(" ", "_");
        ConfigWriter.setProperty(formattedKey, translatedText);
    }
}