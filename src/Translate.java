import com.amazonaws.auth.*;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClientBuilder;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;


public class Translate {

    private static final String Region = "us-east-1";
    private String translatedText;


    public String translateText(String textToTranslate,String sourceLang,String targetLang){

        AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();

        AmazonTranslate translate = AmazonTranslateClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds.getCredentials()))
                .withRegion(Region)
                .build();

        TranslateTextRequest request = new TranslateTextRequest()
                    .withText(textToTranslate)
                    .withSourceLanguageCode(sourceLang)
                    .withTargetLanguageCode(targetLang);

        TranslateTextResult result = translate.translateText(request);
//        translatedText = result.getTranslatedText();
        System.out.println(result.getTranslatedText());
        return result.getTranslatedText();
    }
}
