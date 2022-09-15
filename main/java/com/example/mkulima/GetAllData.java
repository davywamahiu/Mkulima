package com.example.mkulima;

import java.util.List;

public interface GetAllData {
    void onDataLoaded(List<Buyersmkulima> listData);

    void onError(String errorMsg);
}
