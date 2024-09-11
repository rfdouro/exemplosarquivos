package br.org.manipulatextos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author rfdouro
 */
public class Manipulatextos {

 private static String nomearq = "teste.csv";
 private static String texto = "para;descricao\nromulo;jogar bola\nromulo;tomar café\nromulo;fazer aula\n";

 private static void ler() {
  Charset charset = Charset.forName("UTF-16");
  try (BufferedReader reader = Files.newBufferedReader(Path.of(nomearq), charset)) {
   String line = null;
   texto = "";
   while ((line = reader.readLine()) != null) {
    texto += line + '\n';
   }
  } catch (IOException x) {
   System.err.format("IOException: %s%n", x);
  }
 }

 private static void gravar() {
  Charset charset = Charset.forName("UTF-16");
  try (BufferedWriter writer = Files.newBufferedWriter(Path.of(nomearq), charset)) {
   writer.write(texto);
  } catch (IOException x) {
   System.err.format("IOException: %s%n", x);
  }
 }

 public static void apensar(String txt){
  Charset charset = Charset.forName("UTF-16");
  try (BufferedWriter writer = Files.newBufferedWriter(Path.of(nomearq), charset, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
   writer.append(txt);
   writer.flush();
  } catch (IOException x) {
   System.err.format("IOException: %s%n", x);
  }
 }

 public static void main(String[] args) {
  //gravar();
  apensar("romulo;almoçar\n");
  ler();
  System.out.println(texto);
 }
}
