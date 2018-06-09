package com.les.salaomaia.classes.auxiliares;

/**
 * Classe com metódos utilizados para controle e verificação de determiados dados.
 *
 * @version 1.0
 */
public class Controle {

   /**
    * Verifica se um cpf é válido ou não.
    *
    * @param cpf CPf
    * @return True caso o cpf seja válido ou false caso seja inválido.
    * @throws IllegalArgumentException Se ouver algum caracter que não seja um digito.
    */
   public static boolean isCPFValido(String cpf) {
      // Se o cpf conter caracteres inválidos, lançar exceção.
      if (!cpf.matches("^[0-9]*$")) {
         throw new IllegalArgumentException("CPF com caracteres inválidos.");
      }

      // Se todos os digitos forem iguais ou o tamanho do cpf for diferente de 11, retornar falso.
      if (cpf.matches("0{11}") || cpf.matches("1{11}") || cpf.matches("2{11}")
              || cpf.matches("3{11}") || cpf.matches("4{11}") || cpf.matches("5{11}")
              || cpf.matches("6{11}") || cpf.matches("7{11}") || cpf.matches("8{11}")
              || cpf.matches("9{11}") || cpf.length() != 11) {
         return false;
      }

      // Realizando os calculos de verificação para o decimo digito
      char decimoDigito;
      int soma = 0, resto, numero, peso = 10;
      for (int posicao = 0; posicao < 9; posicao++) {
         numero = (int) (cpf.charAt(posicao) - 48);
         soma = soma + (numero * peso);
         peso = peso - 1;
      }
      resto = 11 - (soma % 11);
      if ((resto == 10) || (resto == 11)) {
         decimoDigito = '0';
      }
      else {
         decimoDigito = (char) (resto + 48);
      }

      // Realizando os calculos de verificação para o decimo primeiro digito
      char decimoPrimeiroDigito;
      soma = 0;
      peso = 11;
      for (int posicao = 0; posicao < 10; posicao++) {
         numero = (int) (cpf.charAt(posicao) - 48);
         soma = soma + (numero * peso);
         peso = peso - 1;
      }
      resto = 11 - (soma % 11);
      if ((resto == 10) || (resto == 11)) {
         decimoPrimeiroDigito = '0';
      }
      else {
         decimoPrimeiroDigito = (char) (resto + 48);
      }

      // Verifica se os digitos calculados conferem com os digitos informados.
      return (decimoDigito == cpf.charAt(9)) && (decimoPrimeiroDigito == cpf.charAt(10));
   }
}
