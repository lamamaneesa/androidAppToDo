package com.example.todomvvm.addedittask;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.Repository;
import com.example.todomvvm.database.TaskEntry;

public class AddEditTaskViewModel extends AndroidViewModel {

    Repository repository;
    LiveData<TaskEntry> task;

    AddEditTaskViewModel(Application application, int taskId){
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
        task = database.taskDao().loadTaskById(taskId);
        repository = new Repository(AppDatabase.getInstance(application));
        if(taskId != -1)
            task = repository.getTaskById(taskId);
    }


    public LiveData<TaskEntry> getTask(){
        return task;
    }

    public void insertTask(TaskEntry task){
        repository.insertTask(task);
    }

    public void updateTask(TaskEntry task){
        repository.insertTask(task);
    }


}
