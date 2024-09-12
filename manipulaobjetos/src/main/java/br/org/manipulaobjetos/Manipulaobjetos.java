package br.org.manipulaobjetos;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

/**
 *
 * @author rfdouro
 */
public class Manipulaobjetos {

 private static String nomearq = "objs.txt";
 private static Tarefa tarefa = null;

 private static void le(File f) {
  try {
   FileInputStream fis = new FileInputStream(f);
   ObjectInputStream ois = new ObjectInputStream(fis);
   tarefa = (Tarefa) ois.readObject();
  } catch (Exception ex) { }
 }

 private static void grava(File f) {
  try {
   FileOutputStream fos = new FileOutputStream(f);
   ObjectOutputStream oos = new ObjectOutputStream(fos);
   oos.writeObject(tarefa);
  } catch (Exception ex) { }
 }

 public static void main(String[] args) {
  File f = new File(nomearq);
  if (!f.exists()) {
   try {
    f.createNewFile();
   } catch (IOException e) {
   }
  }

  le(f);

  tarefa = (tarefa != null) ? tarefa : new Tarefa("aula de POO");
  tarefa.setDescricao("agora " + (new Date()));

  grava(f);

  System.out.println(tarefa);
 }
}
