package com.github.InvestApp.AnalysisService.domain; 
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("stocks")
public class Stocks { 
     
    @PrimaryKeyColumn(name = "account_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private int account_id;
    @PrimaryKeyColumn(name = "symbol", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String symbol;
    private String name; 
    private int owned;
    private double price;   
    private double changesPercentage; 
    private double change; 
    private double dayLow; 
    private double dayHigh; 
    private double yearHigh; 
    private double yearLow;  
    private double marketCap; 
    private double priceAvg50; 
    private double priceAvg200; 
    private double volume; 
    private double avgVolume; 
    private String exchange; 
    private double open; 
    private double previousClose; 
    private double eps; 
    private double pe; 
    private String earningsAnnouncement; 
    private double sharesOutstanding; 
    private double timestamp;
    
    public Stocks( ) { 
        
    }
   
    public Stocks(String symbolInput){ 
        this.symbol = symbolInput.toUpperCase(); 
    }   

    public Stocks(int account_id, String symbol, String name, int owned, double price, double changesPercentage, double change, 
    double dayLow, double dayHigh, double yearHigh, double yearLow, double marketCap, double priceAvg50, 
    double priceAvg200, double volume, double avgVolume, String exchange, double open, double previousClose, 
    double eps, double pe, String earningsAnnouncement, double sharesOutstanding, double timestamp){  
        this.account_id = account_id;
        this.symbol = symbol; 
        this.name = name;  
        this.owned = owned;
        this.price = price; 
        this.changesPercentage = changesPercentage; 
        this.change = change; 
        this.dayLow = dayLow; 
        this.dayHigh = dayHigh; 
        this.yearHigh = yearHigh; 
        this.yearLow = yearLow; 
        this.marketCap = marketCap; 
        this.priceAvg50 =  priceAvg50; 
        this.priceAvg200 = priceAvg200; 
        this.volume = volume; 
        this.avgVolume = avgVolume; 
        this.exchange = exchange; 
        this.open = open; 
        this.previousClose = previousClose; 
        this.eps = eps; 
        this.pe = pe; 
        this.earningsAnnouncement = earningsAnnouncement; 
        this.sharesOutstanding = sharesOutstanding; 
        this.timestamp = timestamp;
    }
    public Stocks getStock(){ 
        return this;
    }

    public int getAccount_Id() {
        return account_id;
    }

    public void setAccount_Id(int account_id) {
        this.account_id = account_id;
    }  

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }  

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getChangesPercentage() {
        return changesPercentage;
    }

    public void setChangesPercentage(double changesPercentage) {
        this.changesPercentage = changesPercentage;
    } 

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    } 

    public double getDayLow() {
        return dayLow;
    }

    public void setDayLow(double dayLow) {
        this.dayLow = dayLow;
    } 

    public double getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    } 

    public double getYearLow() {
        return yearLow;
    }

    public void setYearLow(double yearLow) {
        this.yearLow = yearLow;
    } 

    public double getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(double yearHigh) {
        this.yearHigh = yearHigh;
    } 

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    } 

    public double getPriceAvg50() {
        return priceAvg50;
    }

    public void setPriceAvg50(double priceAvg50) {
        this.priceAvg50 = priceAvg50;
    } 

    public double getPriceAvg200() {
        return priceAvg200;
    }

    public void setPriceAvg200(double priceAvg200) {
        this.priceAvg200 = priceAvg200;
    } 

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    } 

    public double getAvgVolume() {
        return avgVolume;
    }

    public void setAvgVolume(double avgVolume) {
        this.avgVolume = avgVolume;
    }  

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    } 

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }   

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }   

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }   

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }   

    public String getEarningsAnnouncement() {
        return earningsAnnouncement;
    }

    public void setEarningsAnnouncement(String earningsAnnouncement) {
        this.earningsAnnouncement = earningsAnnouncement;
    }  

    public double getSharesOutstanding() {
        return sharesOutstanding;
    }

    public void setSharesOutstanding(double sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }    

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

  
} 