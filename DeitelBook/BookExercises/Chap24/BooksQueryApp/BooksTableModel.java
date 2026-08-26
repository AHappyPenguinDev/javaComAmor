import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class BooksTableModel extends AbstractTableModel {

  private Connection connection;
  private PreparedStatement selectAllAuthors;
  private PreparedStatement selectBooksbyAuthor; // sort alphabetically by author last name then first name
  private PreparedStatement selectAuthorsByBook; // sort alphabetically by author last name then first name
  private ResultSet resultSet;
  private ResultSetMetaData metaData;
  private int numberOfRows;
  private boolean connectedToDatabase = false;

  // Constructor creates connection to database and prepared statements.
  // Sets selectAllAuthors as Default statement
  public BooksTableModel(String URL, String USERNAME, String PASSWORD)
      throws SQLException {
    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    connectedToDatabase = true;
    selectAllAuthors = connection.prepareStatement(
        "SELECT * FROM Authors ORDER BY LastName, FirstName");
    selectBooksbyAuthor = connection.prepareStatement(
        "SELECT firstName, lastName, title FROM authors" +
            "INNER JOIN authorISBN ON authors.authorID=authorISBN.authorID" +
            "INNER JOIN titles ON authorISBN.isbn=titles.isbn" +
            "WHERE authors.author = ?");
    selectAuthorsByBook = connection.prepareStatement(
        "SELECT firstName, lastName, title FROM authors" +
            "INNER JOIN authorISBN ON authors.authorID=authorISBN.authorID" +
            "INNER JOIN titles ON authorISBN.isbn=titles.isbn" +
            "WHERE authors.author = ?");
    setQuery(selectAllAuthors);
  }

  public BooksTableModel() {
    System.out.printf("Working?%n");
  }

  // For each getter, check if is connected to database before operation
  public Class getColumnClass(int column) throws IllegalStateException {
    if (!connectedToDatabase)
      throw new IllegalStateException("Not Connected to Database");

    try {
      String className = metaData.getColumnName(column + 1);
      return Class.forName(className);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Object.class;
  }

  public int getColumnCount() throws IllegalStateException {
    if (!connectedToDatabase) {
      throw new IllegalStateException("Not Connected to Database");
    }
    // determine number of columns
    try {
      return metaData.getColumnCount();
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
    return 0; // if problems occur above, return 0 for number of columns
  }

  public String getColumnName(int column) throws IllegalStateException {
    if (!connectedToDatabase) {
      throw new IllegalStateException("Not Connected to Database");
    }
    // determine column name
    try {
      return metaData.getColumnName(column + 1);
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
    return ""; // if problems, return empty string for column name
  }

  public int getRowCount() throws IllegalStateException {
    if (!connectedToDatabase) {
      throw new IllegalStateException("Not Connected to Database");
    }
    return numberOfRows;
  }

  public Object getValueAt(int row, int col)
      throws IllegalStateException {
    if (!connectedToDatabase)
      throw new IllegalStateException();

    try {
      resultSet.absolute(row);
      resultSet.getObject(col);
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }

    return "";
  }

  public void setQuery(PreparedStatement statement)
      throws SQLException, IllegalStateException {
    resultSet = statement.executeQuery();
    metaData = resultSet.getMetaData();

    fireTableStructureChanged();

    resultSet.last();
    numberOfRows = resultSet.getRow();
  }

  public PreparedStatement getSelectAllAuthors() {
    return selectAllAuthors;
  }

  public PreparedStatement getSelectBooksbyAuthor() {
    return selectBooksbyAuthor;
  }

  public PreparedStatement getSelectAuthorsByBook() {
    return selectAuthorsByBook;
  }

  public void disconnectFromDatabase() {
    if (connectedToDatabase) {
      try {
        resultSet.close();
        selectAllAuthors.close();
        selectBooksbyAuthor.close();
        selectAuthorsByBook.close();
        connection.close();
      } catch (SQLException sqlException) {
        sqlException.printStackTrace();
      }
    }
  }
}
