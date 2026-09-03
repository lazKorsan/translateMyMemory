package utilities;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class FileBackupService {

    private static final String CONFIG_FILE_PATH = "src/test/resources/config/configuration.properties";
    private static final String TARGET_DIR_PATH = "C:\\Users\\user\\IdeaProjects\\translateMyMemory\\Documents";

    public static void backupAndClearConfig() {
        Properties properties = new Properties();

        // try (InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_PATH), "UTF-8")) {
        //            properties.load(isr);
        //        }

        // 1. configuration.properties dosyasını okuyoruz
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(CONFIG_FILE_PATH), "UTF-8")) {
            properties.load(isr);
        } catch (IOException e) {
            System.out.println("❌ Config dosyası okunurken hata oluştu: " + e.getMessage());
            return;
        }

        if (properties.isEmpty()) {
            System.out.println("⚠️ configuration.properties dosyası zaten boş! Aktarılacak kelime bulunamadı.");
            return;
        }

        // 2. Hedef "Documents" klasörünü kontrol et, yoksa oluştur
        File targetDir = new File(TARGET_DIR_PATH);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        // 3. Zaman damgalı (timeStamp) dosya adını oluştur
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "vocabulary_" + timeStamp + ".txt";
        File backupFile = new File(targetDir, fileName);

        // 4. Kelimeleri .txt dosyasına UTF-8 ile yaz
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(backupFile), "UTF-8")) {
            osw.write("# Vocabulary Backup - " + timeStamp + "\n");
            osw.write("# ==========================================\n\n");

            for (String key : properties.stringPropertyNames()) {
                osw.write(key + " = " + properties.getProperty(key) + "\n");
            }
            System.out.println("✅ Kelimeler başarıyla aktarıldı: " + backupFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("❌ Yedek dosyasına yazılırken hata oluştu: " + e.getMessage());
        }

        // 5. configuration.properties dosyasını temizle (içeriğini boşaltarak kaydet)
        properties.clear();
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(CONFIG_FILE_PATH), "UTF-8")) {
            properties.store(osw, "Config reset after backup");
            System.out.println("🧹 configuration.properties dosyası temizlendi ve sıfırlandı.");
        } catch (IOException e) {
            throw new RuntimeException("❌ configuration.properties temizlenirken hata oluştu: " + e.getMessage());
        }
    }
}