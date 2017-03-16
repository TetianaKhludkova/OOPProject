package com.mycompany.oopproject.human;

import java.util.ArrayList;

class Observers<T extends HumanObserver> extends ArrayList<T> {
    void notifyObjectCreated(Object obj) {
        for (T t : this) t.objectCreated(obj);
    }
    void notifyObjectModified(Object obj) {
        for (T t : this) t.objectModified(obj);
    }
}