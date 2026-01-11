class Expense{
    private double amount;
    private String category;
    private String date;
    private String description;
    public Expense(double a,String c,String d,String desc){
    this.amount=a;
    this.category=c;
    this.date=d;
    this.description=desc;
    }

    public double getAmount() {return amount;}
    public String getCategory(){return category;}
    public String getDate(){return date;}
    public String getDescription(){return description;}
    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setCategory(String category){
        this.category = category;
    }

    @Override
    public String toString(){
        return  date + " | Rs." + amount + " | " + category + " | " + description;
    }
}

