
public class PieceWorkerEmployee extends Employee {

  public PieceWorkerEmployee(String firstName, String lastName,
      String socialSecurityNumber, Date birthDate, int piecesSold, double wagePerPiece) {
    super(firstName, lastName, socialSecurityNumber, birthDate);

    this.piecesSold = piecesSold;
    this.wagePerPiece = wagePerPiece;
  }

  private int piecesSold;
  private double wagePerPiece;

  public double calculateEarnings() {
    return wagePerPiece * piecesSold;
  }

  @Override
  public double earnings() {
    return calculateEarnings();
  }

  @Override
  public String toString() {
    return String.format("Piece worker employee: %s%nPieces sold: %d %nWage per piece: $%,.2f",
        super.toString(), piecesSold, wagePerPiece);
  }
}
