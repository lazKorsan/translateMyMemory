package utilities;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class QuizService {

    private static final String FILE_PATH = "src/test/resources/config/configuration.properties";

    public static void generateQuiz(int questionCount) {
        Properties properties = new Properties();

        // 1. configuration.properties dosyasını UTF-8 ile okuyoruz
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_PATH), "UTF-8")) {
            properties.load(isr);
        }  catch (IOException e) {
            throw new RuntimeException("configuration.properties dosyası okunamadı: " + e.getMessage());
        }

        List<String> keys = new ArrayList<>();
        for (String key : properties.stringPropertyNames()) {
            keys.add(key);
        }

        // Yeterli kelime var mı kontrolü (En az 5 kelime olmalı ki 5 şık oluşturabilelim)
        if (keys.size() < 5) {
            System.out.println("⚠️ Quiz oluşturabilmek için configuration.properties dosyasında en az 5 kelime olmalıdır!");
            return;
        }

        if (questionCount > keys.size()) {
            System.out.println("⚠️ İstenen soru sayısı (" + questionCount + ") dosyadaki toplam kelime sayısından (" + keys.size() + ") fazla. Toplam kelime sayısı kadar soru hazırlanıyor.\n");
            questionCount = keys.size();
        }

        // Kelimeleri rastgele karıştırıyoruz
        Collections.shuffle(keys);

        System.out.println("\n==================================================");
        System.out.println("            🎯 KELİME QUİZİ (" + questionCount + " Soru)            ");
        System.out.println("==================================================\n");

        char[] optionLetters = {'A', 'B', 'C', 'D', 'E'};

        for (int i = 0; i < questionCount; i++) {
            String correctKey = keys.get(i);
            String correctValue = properties.getProperty(correctKey);

            // Yanlış şıklar için havuz oluşturma (doğru cevap hariç)
            List<String> wrongValues = new ArrayList<>();
            for (String k : keys) {
                if (!k.equals(correctKey)) {
                    wrongValues.add(properties.getProperty(k));
                }
            }
            Collections.shuffle(wrongValues);

            // 4 adet yanlış şık alıyoruz
            List<String> options = new ArrayList<>();
            options.add(correctValue); // Doğru cevabı ekle
            for (int j = 0; j < 4; j++) {
                options.add(wrongValues.get(j)); // 4 yanlış şık ekle
            }

            // Şıkları kendi içinde karıştırıyoruz ki doğru cevap hep aynı şıkta olmasın
            Collections.shuffle(options);

            // Soruyu Ekrana Yazdır
            System.out.println("Soru " + (i + 1) + ": \"" + correctKey.toUpperCase() + "\" kelimesinin Türkçe karşılığı nedir?");

            String correctAnswerLetter = "";
            for (int optIndex = 0; optIndex < options.size(); optIndex++) {
                String optionText = options.get(optIndex);
                System.out.println("  " + optionLetters[optIndex] + ") " + optionText);

                if (optionText.equals(correctValue)) {
                    correctAnswerLetter = String.valueOf(optionLetters[optIndex]);
                }
            }

            System.out.println("  --> [Doğru Cevap: " + correctAnswerLetter + " - " + correctValue + "]\n");
        }
        System.out.println("==================================================\n");
    }
}