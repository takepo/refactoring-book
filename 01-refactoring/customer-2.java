class Customer {
  private String _name;
  private Vector _rentals = new Vector();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg)
  }

  public String getName() {
    retunr _name;
  }

  // 配置&再配置
  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints  = 0;
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";
    while (rentals.hasMoreElements()) {
      double thisAmount = 0;
      Rental each = (Reantal) rentals.nextElement();

      thisAmount = amountFor(each);

      // レンタルポイント加算
      frequentRenterPoints++;
      
      //新作を２日以上借りた場合はボーナスポイント
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
        frequentRenterPoints++;
      }

      // この貸出に関する数値の表示
      result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }

    // フッタ部分の追加
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result + = "you earned "String.valueOf(frequentRenterPoints) + " frequent renter ponts";
    return result;
  }

  private double amountFor(Rental each) {
    int thisAmount = 0
    switch (each.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        this.Amount += 2;
        if (each.getDaysRented() > 2) {
          thisAmount += (each.getDaysRented() - 2) * 1.5;
        }
        break;
      case Movie.NEW_RELEASE:
        thisAmount += each.getDaysRented() * 3;
        break;      
      case Movie.CHILDRENS:
        thisAmount += 1.5;
        if (each.getDaysRented() > 3) {
          thisAmount += (each.getDaysRented() - 3) * 1.5;
        }
        break;
    }
    return thisAmount;
  }
}
