# 🌐 Translate My Memory - API Automation Project

**translateMyMemory**, MyMemory Translation API servisi ile entegre olarak çalışan, metin ve kelime çevirilerini API üzerinden gerçekleştiren ve elde edilen çevirileri UTF-8 formatında yapılandırma (`.properties`) dosyasına dinamik olarak kaydeden bir Test Otomasyon projesidir[cite: 2, 3, 5].

Bu projede **BDD (Behavior-Driven Development)** yaklaşımı kullanılarak test senaryoları kaleme alınmış; Rest-Assured, Cucumber, JUnit ve Allure Report teknolojileri harmanlanmıştır[cite: 1, 4, 5].

---

## 🚀 Öne Çıkan Özellikler

- **MyMemory API Entegrasyonu:** Rest-Assured kullanılarak MyMemory API üzerinden anlık ve hızlı çeviri işlemleri[cite: 2, 5].
- **Dinamik Configuration Writer:** Çevrilen kelimeleri Türkçe karakter desteğini (UTF-8) koruyarak `configuration.properties` dosyasına otomatik kaydetme.
- **BDD & Gherkin Yapısı:** Cucumber ve Gherkin dili ile yazılmış, kolay okunabilir ve modüler test adımları[cite: 1, 4, 5].
- **Hız Sınırlaması Yönetimi (Rate Limit Control):** API istek sınırlamalarına (`429 Too Many Requests`) takılmamak adına adım seviyesinde optimize edilmiş bekleme mekanizması.
- **Raporlama:** Allure Report ve Log4j2 entegrasyonu ile detaylı test çalıştırma raporları ve log yönetimi[cite: 1, 5].

---

## 🛠️ Teknolojiler ve Bağımlılıklar

| Teknoloji / Kütüphane | Versiyon / Açıklama |
| :--- | :--- |
| **Java** | OpenJDK 21[cite: 1, 5] |
| **Build Tool** | Apache Maven[cite: 1, 5] |
| **BDD Framework** | Cucumber Java & JUnit (`7.2.3`)[cite: 1, 5] |
| **API Test Automation** | Rest Assured (`4.5.1`)[cite: 1, 5] |
| **JSON Parser** | `org.json` (`20231013`) & Gson (`2.9.0`)[cite: 1, 5] |
| **Reporting** | Allure Cucumber7 JVM (`2.17.3`)[cite: 1, 5] |
| **Logging** | Log4j2 & SLF4J (`2.20.0`)[cite: 1, 5] |
| **Utilities** | Apache POI, Lombok, Java Faker[cite: 1, 5] |

---

## 📂 Proje Mimarisi ve Dizin Yapısı

```text
translateMyMemory/
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



