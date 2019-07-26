package ru.skillbranch.devintensive.ui.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.skillbranch.devintensive.R

class ProfileActivity : AppCompatActivity() {
    /**
     * Вызывается при первом создании или перезапуске Activity
     *
     * здесь создаётся внешний вид активности (UI) через метод setContentView().
     * инициализируются представления
     * представления связываются с необходимыми данными и ресурсами
     * связываются данные со списками
     *
     * Этот метод также представляет Bundle,
     * содержащий ранее сохраненное состояние Activity, если оно было
     *
     * всегда сопровождается вызовом
     * onStart()
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

}
