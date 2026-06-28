package observer;

import java.util.ArrayList;

public class StockMarket {
    ArrayList<Observer> observers = new ArrayList<>();
    String stockName;
    double price;

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}
