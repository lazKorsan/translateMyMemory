package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class GoogleTranslateService {

    /**
     * MyMemory API kullanarak kelime çevirisi yapar.
     * @param textTranslate Çevrilecek kelime
     * @param targetLang    Hedef dil (örn: "tr", "en")
     * @return Çevrilmiş metin
     */
    public static String translate(String textTranslate, String targetLang) {
        String baseUrl = "https://api.mymemory.translated.net/get";

        Response response = RestAssured.given()
                .queryParam("q", textTranslate)
                .queryParam("langpair", "en|" + targetLang) // İngilizce'den hedef dile (örn: en|tr)
                .when()
                .get(baseUrl);

        if (response.getStatusCode() == 200) {
            JSONObject jsonObject = new JSONObject(response.getBody().asString());
            return jsonObject.getJSONObject("responseData").getString("translatedText");
        } else {
            throw new RuntimeException("Çeviri API isteği başarısız! Status Code: " + response.getStatusCode());
        }
    }
}