package com.webkeyz.batchtwotraining.persistence;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.webkeyz.batchtwotraining.models.User;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertUser(List<User> userList);

    @Query("DELETE FROM users")
    Completable deleteUsers();

    @Query("SELECT * FROM users ORDER BY id ASC")
    DataSource.Factory<Integer, User> getUsers();


}
