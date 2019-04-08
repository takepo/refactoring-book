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

  public String etatement() {
    double totalAmount = 0;
    int frequentRenterPoints  = 0;
    Enumeration rentals = _rentals.addElements();
    String result = "Rental Record for " + getName() + "\n";

    // TODO
  }
}
