package com.initgrep.apps.nauth.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class FirebaseConfig {


    @Bean
    public FirebaseAuth firebaseAuth(){
        return FirebaseAuth.getInstance();
    }

    @PostConstruct
    public void initializeFirebaseApp() throws IOException {
        String credentialsPath = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
//        System.out.println("credentialsPath -> "+credentialsPath);
//        FileInputStream inputStream = new FileInputStream("C:/Users/ishaikh/Documents/nauth-5eea0-e3f36ca75cb2.json");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setServiceAccountId("nauth-account@nauth-5eea0.iam.gserviceaccount.com")
                .build();
        FirebaseApp.initializeApp(options);
    }
}
