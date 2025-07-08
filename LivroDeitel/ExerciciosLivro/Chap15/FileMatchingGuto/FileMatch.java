/*
 * Objetivo: d) Crie a classe FileMatch para realizar a funcionalidade de correspond�ncia de arquivos. A classe deve conter m�todos que leem
 * oldmast.txt e trans.txt. Quando uma correspond�ncia ocorre (isto �, registros com o mesmo n�mero de conta aparecem tanto
 * no arquivo-mestre como no arquivo de transa��es), adicione o valor monet�rio no registro de transa��o ao saldo atual no registro-mestre
 * e grave o registro em "newmast.txt". (Suponha que compras sejam indicadas por montantes positivos no arquivo de transa��es,
 * e os pagamentos, por valores monet�rios negativos.) Caso haja um registro-mestre para uma conta particular, mas nenhum registro
 * de transa��o correspondente, simplesmente grave o registro-mestre em "newmast.txt". Se houver um registro de transa��o, mas
 * nenhum registro-mestre correspondente, imprima a mensagem "Unmatched transaction record for account number�"
 * [Registro de transa��o n�o correspondente para o n�mero da conta] em um arquivo de log (preencha o n�mero
 * da conta a partir do registro de transa��o). O arquivo de log deve ser um arquivo de texto chamado "log.txt".
 * 
 * Autor: Gustavo Alves
 */

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class FileMatch {
  private static Scanner inputOldMast;
  private static Scanner inputTrans;
  private static Formatter outputNewMast;
  private static Formatter outputLog;
  private static Account account;

  public static void main(String[] args) {
    matcher();

  }

  private static void matcher() {
    try {
      inputOldMast = new Scanner(Paths.get("oldmast.txt"));
      outputNewMast = new Formatter("newmast.txt");
    } catch (IOException e) {
    }

    while (inputOldMast.hasNext()) {
      account = new Account(inputOldMast.nextInt(), inputOldMast.next(), inputOldMast.next(),
          inputOldMast.nextDouble());

      double transValue = someTrans(account.getAccount());

      outputNewMast.format("%d %s %s %.2f%n", account.getAccount(), account.getFirstName(), account.getLastName(),
          account.getBalance() + transValue);

    }

    inputOldMast.close();
    outputNewMast.close();

    checkTrans();
  }

  private static double someTrans(int accountNumber) {
    try {
      inputTrans = new Scanner(Paths.get("trans.txt"));
    } catch (IOException e) {
    }

    while (inputTrans.hasNext()) {
      TransactionRecord trRecord = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble());

      if (trRecord.getAccount() == accountNumber) {
        inputTrans.close();
        return trRecord.getValueForTransaction();
      }
    }
    inputTrans.close();

    return 0;
  }

  public static void checkTrans() {
    try {
      inputTrans = new Scanner(Paths.get("trans.txt"));
      outputLog = new Formatter("log.txt");
    } catch (Exception e) {
    }

    while (inputTrans.hasNext()) {
      TransactionRecord trRecord = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble());

      if (runOldMast(trRecord.getAccount())) {
        outputLog.format("%d %s%n", trRecord.getAccount(),
            "Registro de transa��o n�o correspondente para o n�mero da conta");
      }

    }

    inputTrans.close();
    outputLog.close();

  }

  public static boolean runOldMast(int accountNumber) {
    try {
      inputOldMast = new Scanner(Paths.get("oldmast.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    while (inputOldMast.hasNext()) {
      account = new Account(inputOldMast.nextInt(), inputOldMast.next(), inputOldMast.next(),
          inputOldMast.nextDouble());

      if (account.getAccount() == accountNumber) {
        inputOldMast.close();
        return false;
      }
    }

    inputOldMast.close();
    return true;
  }
}
