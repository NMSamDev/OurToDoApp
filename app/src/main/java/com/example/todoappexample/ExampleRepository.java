package com.example.todoappexample;

import java.util.List;

public interface ExampleRepository {
    List<String> getThatData();
    boolean isConnectionOk();
}

class ExampleRepositoryImpl implements ExampleRepository{
    @Override
    public List<String> getThatData() {
        // everything of that data
        return null;
    }

    public List<String> getThatData(String data) {
        // only get data that looks like dataPls
        return null;
    }

    @Override
    public boolean isConnectionOk() {
        return false;
    }
}