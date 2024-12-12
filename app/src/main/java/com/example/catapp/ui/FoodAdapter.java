package com.example.catapp.ui;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.catapp.R;
import com.example.catapp.data.model.FoodItem;
import java.util.List;
import android.content.Context;
import android.widget.Button;
import android.content.Intent;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<FoodItem> foodList;
    private Context context; //кКОНТЕКСТ XML

    public FoodAdapter(List<FoodItem> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_card, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodItem foodItem = foodList.get(position);
        holder.bind(foodItem);

        // ОБРАБОТЧИК КНОПКИ.
        holder.buttonShowMap.setOnClickListener(v -> {
            // Здесь вы можете установить координаты ближайшего магазина
            double shopLatitude = 55.3968; // Примерные координаты Кемерово (можно заменить на реальные)
            double shopLongitude = 86.0859; // Примерные координаты Кемерово (можно заменить на реальные)

            Intent intent = new Intent(context, MapYandexActivity.class);
            intent.putExtra("shop_latitude", shopLatitude);
            intent.putExtra("shop_longitude", shopLongitude);
            context.startActivity(intent); // Запуск активности карты
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView foodName;
        TextView foodDescription;
        TextView foodPrice; // Объявление TextView для цены
        TextView foodCalories; // Объявление TextView для калорийности
        Button buttonShowMap; // Кнопка для перехода на карту

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.food_image);
            foodName = itemView.findViewById(R.id.food_name);
            foodDescription = itemView.findViewById(R.id.food_description);
            foodPrice = itemView.findViewById(R.id.food_price); // Инициализация TextView для цены
            foodCalories = itemView.findViewById(R.id.food_calories); // Инициализация TextView для калорийности
            buttonShowMap = itemView.findViewById(R.id.add_corm_in_map); // Инициализация кнопки
        }

        public void bind(FoodItem foodItem) {
            // Устанавливаем данные в соответствующие TextViews
            foodName.setText(foodItem.getName());
            foodDescription.setText(foodItem.getDescription());
            foodPrice.setText(String.valueOf(foodItem.getPrice())); // Устанавливаем цену
            foodCalories.setText(String.valueOf(foodItem.getColorieContent())); // Устанавливаем калорийность

            // Если у вас есть изображение, вы можете установить его здесь:
            // foodImage.setImageResource(foodItem.getImageResId());
        }
    }
}

