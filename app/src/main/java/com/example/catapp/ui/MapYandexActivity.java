package com.example.catapp.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.catapp.R;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class MapYandexActivity extends AppCompatActivity {
    private MapView mapView; // ОБЪЯВЛЕНИЕ ПЕРЕМЕННЫХ.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // ВКЛЮЧЕНИЕ АКТИВНОСТИ.

        // УСТАНОВКА МАКЕТА ДЛЯ КАРТЫ.
        setContentView(R.layout.map_yandex);

        // АПИ КЛЮЧ ДЛЯ КАРТЫ.
        MapKitFactory.setApiKey("7ba4c325-d140-432e-a660-e5bdca3812d7");
        MapKitFactory.initialize(this);

        // ПОЛУЧЕНИЕ ССЫЛКИ ДЛЯ КАРТЫ.
        mapView = findViewById(R.id.map_yandex);

        // Установка начального положения карты на Кемерово.
        mapView.getMap().move(
                new CameraPosition(
                        new Point(55.3968, 86.0859), // КООРДИНАТЫ КЕМЕРОВО.
                        11.0f, // Уровень масштабирования (zoom)
                        0.0f,  // Азимут (azimuth)
                        0.0f   // Наклон (tilt)
                ),
                new Animation(Animation.Type.SMOOTH, 0F), // АНИМАЦИЯ ДВИЖЕНИЯ.
                null
        );


    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart(); // ЗАПУСК РАБОТЫ ЯНДЕКС КАРТЫ
        mapView.onStart(); // Запуск работы MapView
    }

    @Override
    protected void onStop() {
        mapView.onStop(); // ОСТАНОВКА РАБОТЫ.
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onStop(); // ОСТАНОВКА РАБОТ MapView ДЛЯ УНИЧТОЖЕНИЯ АКТИВНОСТИ.
    }
}
