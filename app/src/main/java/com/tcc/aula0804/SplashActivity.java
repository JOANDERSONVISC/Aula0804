package com.tcc.aula0804;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 9000; // 9 segundos
    private boolean splashShown = false; // evitar redirecionamento repetido

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);

        LottieAnimationView animationView = findViewById(R.id.imageView2);
        animationView.setAnimation(R.raw.animacao3d); // Carrega a animação Lottie do arquivo JSON na pasta raw
        animationView.playAnimation(); // Inicia a animação

        if (!splashShown) {
            splashShown = true;
            boolean b = new Handler().postDelayed(() -> {
                // Cria um intent para iniciar a próxima atividade (tela de login)
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                // Finaliza a atividade da tela de splash para impedir que o usuário retorne para ela ao pressionar o botão "Voltar"
                finish();
            }, SPLASH_DISPLAY_LENGTH);
        } else {
            // Se a tela de splash já foi mostrada, inicie imediatamente a MainActivity e finalize a SplashActivity
            Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }
}
