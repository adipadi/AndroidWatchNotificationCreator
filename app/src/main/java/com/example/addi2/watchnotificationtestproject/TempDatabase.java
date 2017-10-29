package com.example.addi2.watchnotificationtestproject;

import android.app.Notification;
import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by addi2 on 28.10.2017.
 */

class TempDatabase {
    private static final TempDatabase ourInstance = new TempDatabase();

    public List<Notification> getNotifyList() {
        return notifyList;
    }

    private List<Notification> notifyList;


    static TempDatabase getInstance() {
        return ourInstance;
    }

    private TempDatabase() {
        notifyList= new List<Notification>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Notification> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Notification notification) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Notification> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Notification> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Notification get(int i) {
                return null;
            }

            @Override
            public Notification set(int i, Notification notification) {
                return null;
            }

            @Override
            public void add(int i, Notification notification) {

            }

            @Override
            public Notification remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Notification> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Notification> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Notification> subList(int i, int i1) {
                return null;
            }
        };
    }//constructor


}
