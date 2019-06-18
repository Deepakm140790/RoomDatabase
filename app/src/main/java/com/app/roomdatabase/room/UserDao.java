package com.app.roomdatabase.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * User DAO class
 */
@Dao
public interface UserDao {
    @Query("Select * from user")
    LiveData<List<User>> getAllUser();

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("Delete from user")
    void deleteAll();

    @Update
    void update(User user);
}
