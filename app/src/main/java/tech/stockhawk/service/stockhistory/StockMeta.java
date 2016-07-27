package tech.stockhawk.service.stockhistory;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class StockMeta implements Parcelable {
    public String companyName;
    public String exchangeName;
    public String firstTrade;
    public String lastTrade;
    public String currency;
    public double previousClosePrice;
    public ArrayList<StockSymbol> stockSymbols;

    public StockMeta(String companyName, String exchangeName, String firstTrade, String lastTrade, String currency, double previousClosePrice, ArrayList<StockSymbol> stockSymbols) {
        this.companyName = companyName;
        this.exchangeName = exchangeName;
        this.firstTrade = firstTrade;
        this.lastTrade = lastTrade;
        this.currency = currency;
        this.previousClosePrice = previousClosePrice;
        this.stockSymbols = stockSymbols;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.companyName);
        dest.writeString(this.exchangeName);
        dest.writeString(this.firstTrade);
        dest.writeString(this.lastTrade);
        dest.writeString(this.currency);
        dest.writeDouble(this.previousClosePrice);
        dest.writeTypedList(this.stockSymbols);
    }

    protected StockMeta(Parcel in) {
        this.companyName = in.readString();
        this.exchangeName = in.readString();
        this.firstTrade = in.readString();
        this.lastTrade = in.readString();
        this.currency = in.readString();
        this.previousClosePrice = in.readDouble();
        this.stockSymbols = in.createTypedArrayList(StockSymbol.CREATOR);
    }

    public static final Parcelable.Creator<StockMeta> CREATOR = new Parcelable.Creator<StockMeta>() {
        @Override
        public StockMeta createFromParcel(Parcel source) {
            return new StockMeta(source);
        }

        @Override
        public StockMeta[] newArray(int size) {
            return new StockMeta[size];
        }
    };
}
