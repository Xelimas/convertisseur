public enum Currency {
    
    Euro("euro","€",1),
    Dollar("dollar","$",0.85), 
    Livre("Livre","\u00A3",1.11), 
    Yen("yen","\u00A5",0.0077), 
    Zloty("zloty","zł",0.22),
    Baht("baht","฿",0.026);

    private String name;
    private double euroConversionRate;
    private String symbol;

    Currency(String name,String symbol, double euroConversionRate){
        this.name = name;
        this.symbol = symbol;
        this.euroConversionRate = euroConversionRate;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return double return the euroConversionRate
     */
    public double getEuroConversionRate() {
        return euroConversionRate;
    }


    /**
     * @return String return the symbol
     */
    public String getSymbol() {
        return symbol;
    }
}