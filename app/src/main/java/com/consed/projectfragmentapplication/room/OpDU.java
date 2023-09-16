package com.consed.projectfragmentapplication.room;

public interface OpDU {
    void onUpdateListener(int rowsAffected, Personal personal);
    void onDeleteListener(int rowsAffected, Personal personal);

}
