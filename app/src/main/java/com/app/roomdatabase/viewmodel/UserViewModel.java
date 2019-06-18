package com.app.roomdatabase.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.app.roomdatabase.repository.UserRepo;
import com.app.roomdatabase.room.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel{
    private UserRepo userRepo;
    private LiveData<List<User>> allUser;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepo = new UserRepo(application);
        allUser = userRepo.getAllUser();
    }

    public void insert(User user){
        userRepo.addUser(user);
    }

    public void update(User user){
        userRepo.updateUser(user);
    }

    public void delete(User user){
        userRepo.deleteUser(user);
    }

    public void deleteAll(User user){
        userRepo.deleteAllUser();
    }

    public LiveData<List<User>> getAllUser(){
        return allUser;
    }
}
