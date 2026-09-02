🌐 Translate My Memory - API Automation ProjecttranslateMyMemory, MyMemory Translation API servisi ile entegre olarak çalışan, metin ve kelime çevirilerini API üzerinden gerçekleştiren ve elde edilen çevirileri UTF-8 formatında yapılandırma (.properties) dosyasına dinamik olarak kaydeden bir Test Otomasyon projesidir.  Bu projede BDD (Behavior-Driven Development) yaklaşımı kullanılarak test senaryoları kaleme alınmış; Rest-Assured, Cucumber, JUnit ve Allure Report teknolojileri harmanlanmıştır.  🚀 Öne Çıkan ÖzelliklerMyMemory API Entegrasyonu: Rest-Assured kullanılarak MyMemory API üzerinden anlık ve hızlı çeviri işlemleri.  Dinamik Configuration Writer: Çevrilen kelimeleri Türkçe karakter desteğini (UTF-8) koruyarak configuration.properties dosyasına otomatik kaydetme.  BDD & Gherkin Yapısı: Cucumber ve Gherkin dili ile yazılmış, kolay okunabilir ve modüler test adımları.  Hız Sınırlaması Yönetimi (Rate Limit Control): API istek sınırlamalarına (429 Too Many Requests) takılmamak adına adım seviyesinde optimize edilmiş bekleme mekanizması.  Raporlama: Allure Report ve Log4j2 entegrasyonu ile detaylı test çalıştırma raporları ve log yönetimi.  🛠️ Teknolojiler ve BağımlılıklarTeknoloji / KütüphaneVersiyon / AçıklamaJavaOpenJDK 21  Build ToolApache Maven  BDD FrameworkCucumber Java & JUnit (7.2.3)  API Test AutomationRest Assured (4.5.1)  JSON Parserorg.json (20231013) & Gson (2.9.0)  ReportingAllure Cucumber7 JVM (2.17.3)  LoggingLog4j2 & SLF4J (2.20.0)  UtilitiesApache POI, Lombok, Java Faker  📂 Proje Mimarisi ve Dizün YapısıPlaintexttranslateMyMemory/
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── stepdefinitions/
│       │   │   └── TranslateStepDefs.java      # Cucumber adım tanımları
│       │   └── utilities/
│       │       ├── ConfigWriter.java           # Configuration.properties yazıcı (UTF-8)
│       │       └── GoogleTranslateService.java # MyMemory API çağrı servisi
│       └── resources/
│           ├── config/
│           │   └── configuration.properties    # Çevirilerin kaydedildiği dosya
│           └── features/                       # Gherkin dilinde yazılmış feature dosyaları
├── pom.xml                                     # Maven bağımlılıkları ve plugin yapılandırması
└── README.md
⚙️ Kurulum ve Çalıştırma1. Repoyu Klonsal Olarak ÇekinBashgit clone https://github.com/lazKorsan/translateMyMemory.git
cd translateMyMemory
2. Bağımlılıkları YükleyinBashmvn clean compile
3. Testleri ÇalıştırınTüm senaryoları çalıştırmak ve Allure sonuçlarını üretmek için:Bashmvn clean test
4. Allure Raporunu GörüntüleyinTest çalıştırması tamamlandıktan sonra görsel raporu açmak için:Bashmvn allure:serve
📝 Örnek Senaryo Kullanımı (Gherkin)GherkinFeature: API ile Çeviri İşlemleri ve Config Kaydı

  Scenario Outline: Kelime çevirisi yapma ve konfigürasyona kaydetme
    Given User translates "<word>" to "<target_lang>" language via API
    Then User saves word "<word>" and its translation to config properties

    Examples:
      | word        | target_lang |
      | Hello World | tr          |
      | Memory      | tr          |
🔧 Teknik Detaylar & İpuçlarıUTF-8 Karakter Desteği: ConfigWriter sınıfı OutputStreamWriter ve StandardCharsets.UTF-8 kullanarak Türkçe karakterlerin (i, ş, ğ, ç, ö, ü) .properties dosyalarında bozulmadan saklanmasını sağlar.  API Rate Limit: Ücretsiz MyMemory API kullanımında oluşabilecek geçici engellemeleri önlemek için istekler arasına Thread.sleep kontrollü gecikmeleri eklenmiştir.  👨‍💻 Geliştirici: lazKorsan