package com.app.roomdatabase.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.app.roomdatabase.R;
import com.app.roomdatabase.room.User;
import com.app.roomdatabase.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getAllUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                // Update recycler view
                Toast.makeText(getApplicationContext(), "OnChanged user size - " + users.size(), Toast.LENGTH_SHORT).show();

                for (int i = 0; i < users.size(); i++) {
                    Log.d(TAG, users.get(i).getFirstName());
                }
            }
        });

//        User user = new User("Deepak", "MohanKumar", "9591778104", "Tokyo");
//        userViewModel.insert(user);
    }
}
