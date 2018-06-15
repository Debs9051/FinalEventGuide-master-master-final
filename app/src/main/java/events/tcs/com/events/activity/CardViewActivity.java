/*package events.tcs.com.events.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import events.tcs.com.events.R;
import events.tcs.com.events.data.CarRecyclerViewItem;


import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {

    private List<CarRecyclerViewItem> carItemList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        setTitle("dev2qa.com - Android CardView Example.");

        initializeCarItemList();

        // Create the recyclerview.
        RecyclerView carRecyclerView = (RecyclerView)findViewById(R.id.card_view_recycler_list);
        // Create the grid layout manager with 2 columns.
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        // Set layout manager.
        carRecyclerView.setLayoutManager(gridLayoutManager);

        // Create car recycler view data adapter with car item list.
        CarRecyclerViewDataAdapter carDataAdapter = new CarRecyclerViewDataAdapter(carItemList);
        // Set data adapter.
        carRecyclerView.setAdapter(carDataAdapter);

    }

    /* Initialise car items in list. */
   /* private void initializeCarItemList()
    {
        if(carItemList == null)
        {
            carItemList = new ArrayList<CarRecyclerViewItem>();
            carItemList.add(new CarRecyclerViewItem("Audi", R.drawable.car_audi));
            carItemList.add(new CarRecyclerViewItem("BMW", R.drawable.car_bmw));
            carItemList.add(new CarRecyclerViewItem("Benz", R.drawable.car_benz));
            carItemList.add(new CarRecyclerViewItem("Jeep", R.drawable.car_jeep));
            carItemList.add(new CarRecyclerViewItem("Land Rover", R.drawable.car_land_rover));
            carItemList.add(new CarRecyclerViewItem("Future", R.drawable.car_future));
        }
    }
}*/