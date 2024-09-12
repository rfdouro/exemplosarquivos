package br.org.manipulaobjetos;

import java.io.*;
import java.util.*;

public class ManipulaLista {
 private static String nomearq = "listas.txt";
 private static List lista = null;

 private static void le(File f) {
  try {
   FileInputStream fis = new FileInputStream(f);
   ObjectInputStream ois = new ObjectInputStream(fis);
   lista = (List) ois.readObject();
  } catch (Exception ex) {
  }
 }

 private static void grava(File f) {
  try {
   FileOutputStream fos = new FileOutputStream(f);
   ObjectOutputStream oos = new ObjectOutputStream(fos);
   oos.writeObject(lista);
  } catch (Exception ex) {
  }
 }

 public static void main(String[] args) {
  File f = new File(nomearq);
  if (!f.exists())
   try {
    f.createNewFile();
   } catch (Exception e) {
   }
  // lista = List.of("abacate", "morango", "manga");
  // grava(f);
  le(f);
  for (String s : (List<String>) lista) {
   System.out.println(s);
  }

 }
}
