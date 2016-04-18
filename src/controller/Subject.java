package controller;

/**
 * Created by Ilias on 4/16/2016.
 */
public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObserver();
}
