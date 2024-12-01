package com.example.catapp.ui
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.catapp.R

class LoginActivity : AppCompatActivity() {

    // Объявляем переменную для SharedPreferences
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Устанавливаем разметку для LoginActivity
        setContentView(R.layout.activity_login2)

        // Инициализация SharedPreferences
        sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)

        // Инициализация спиннеров и привязка к данным
        val spinnerTypeFood: Spinner = findViewById(R.id.spinner_type_food)
        val spinnerAgeCategory: Spinner = findViewById(R.id.spinner_age_category)
        val spinnerBudgetPremium: Spinner = findViewById(R.id.spinner_budget_premium)
        val spinnerSterilizedRegular: Spinner = findViewById(R.id.spinner_sterilized_regular)

        // Привязка массива строк к каждому спиннеру с использованием ArrayAdapter
        val adapterTypeFood = ArrayAdapter.createFromResource(
            this,
            R.array.type_food_options,
            android.R.layout.simple_spinner_item
        )
        val adapterAgeCategory = ArrayAdapter.createFromResource(
            this,
            R.array.age_category_options,
            android.R.layout.simple_spinner_item
        )
        val adapterBudgetPremium = ArrayAdapter.createFromResource(
            this,
            R.array.budget_premium_options,
            android.R.layout.simple_spinner_item
        )
        val adapterSterilizedRegular = ArrayAdapter.createFromResource(
            this,
            R.array.sterilized_regular_options,
            android.R.layout.simple_spinner_item
        )

        // Настроим внешний вид выпадающих списков
        adapterTypeFood.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterAgeCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterBudgetPremium.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterSterilizedRegular.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Устанавливаем адаптеры
        spinnerTypeFood.adapter = adapterTypeFood
        spinnerAgeCategory.adapter = adapterAgeCategory
        spinnerBudgetPremium.adapter = adapterBudgetPremium
        spinnerSterilizedRegular.adapter = adapterSterilizedRegular

        // Слушатели для обработки выбора
        spinnerTypeFood.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                val selectedItem = parentView?.getItemAtPosition(position).toString()
                sharedPreferences.edit().putString("selected_type_food", selectedItem).apply()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        spinnerAgeCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                val selectedItem = parentView?.getItemAtPosition(position).toString()
                sharedPreferences.edit().putString("selected_age_category", selectedItem).apply()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        spinnerBudgetPremium.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                val selectedItem = parentView?.getItemAtPosition(position).toString()
                sharedPreferences.edit().putString("selected_budget_premium", selectedItem).apply()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        spinnerSterilizedRegular.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                val selectedItem = parentView?.getItemAtPosition(position).toString()
                sharedPreferences.edit().putString("selected_sterilized_regular", selectedItem).apply()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {}
        }

        // Восстановление ранее выбранных значений из SharedPreferences (если они есть)
        restoreSelections()
    }

    // Функция для восстановления значений из SharedPreferences
    private fun restoreSelections() {
        val selectedTypeFood = sharedPreferences.getString("selected_type_food", null)
        val selectedAgeCategory = sharedPreferences.getString("selected_age_category", null)
        val selectedBudgetPremium = sharedPreferences.getString("selected_budget_premium", null)
        val selectedSterilizedRegular = sharedPreferences.getString("selected_sterilized_regular", null)

        selectedTypeFood?.let {
            val spinnerTypeFood: Spinner = findViewById(R.id.spinner_type_food)
            val position = resources.getStringArray(R.array.type_food_options).indexOf(it)
            if (position >= 0) spinnerTypeFood.setSelection(position)
        }

        selectedAgeCategory?.let {
            val spinnerAgeCategory: Spinner = findViewById(R.id.spinner_age_category)
            val position = resources.getStringArray(R.array.age_category_options).indexOf(it)
            if (position >= 0) spinnerAgeCategory.setSelection(position)
        }

        selectedBudgetPremium?.let {
            val spinnerBudgetPremium: Spinner = findViewById(R.id.spinner_budget_premium)
            val position = resources.getStringArray(R.array.budget_premium_options).indexOf(it)
            if (position >= 0) spinnerBudgetPremium.setSelection(position)
        }

        selectedSterilizedRegular?.let {
            val spinnerSterilizedRegular: Spinner = findViewById(R.id.spinner_sterilized_regular)
            val position = resources.getStringArray(R.array.sterilized_regular_options).indexOf(it)
            if (position >= 0) spinnerSterilizedRegular.setSelection(position)
        }
    }
}

























