package com.app.roomdatabase.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.app.roomdatabase.room.UserDao;
import com.app.roomdatabase.room.UserDatabase;
import com.app.roomdatabase.room.User;

import java.util.List;

public class UserRepo {
    private UserDao userDao;
    private LiveData<List<User>> allUser;

    public UserRepo(Application application){
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        userDao = userDatabase.userDao();
        allUser = userDao.getAllUser();
    }

    public LiveData<List<User>> getAllUser(){
        return allUser;
    }

    public void addUser(User user){
        new InsertUserAsyncTask(userDao).execute(user);
    }

    public void updateUser(User user){
        new UpdateUserAsyncTask(userDao).execute(user);
    }

    public void deleteUser(User user){
        new DeleteUserAsyncTask(userDao).execute(user);
    }

    public void deleteAllUser(){
        new DeleteAllUserAsyncTask(userDao).execute();
    }

    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao userDao;

        private InsertUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao userDao;

        private UpdateUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao userDao;

        private DeleteUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class DeleteAllUserAsyncTask extends AsyncTask<Void, Void, Void>{
        private UserDao userDao;

        private DeleteAllUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteAll();
            return null;
        }
    }
}
