package mx.com.j44p.school.logica.borrame;

import java.io.IOException;
import java.io.InputStream;
import  java.io.InputStreamReader;
import  java.io.LineNumberReader;
import  java.io.Reader;
import  java.util.ArrayList;
import  java.util.Collections;
import  java.util.List;
public class WordSource
{
  private int _nextWord;
  private List _words = new ArrayList();
  public WordSource()
  {
    readWords();
  }
  private void readWords()
  {
    try
    {
      InputStream in =
         getClass().getResourceAsStream("WordList.txt");
       Reader r = new InputStreamReader(in);
       LineNumberReader lineReader = new LineNumberReader(r);
      while (true)
      {
         String line = lineReader.readLine();
         if (line == null)
           break;
         if (line.startsWith("#"))
           continue;
         String word = line.trim().toLowerCase();
         if (word.length() == 0)
           continue;
         _words.add(word);
      }
      lineReader.close();
    }
    catch (IOException ex)
    {
       throw new RuntimeException(
         "Unable to read list of words from file WordList.txt.",
//                                   Introducing the Hangman application 49
        ex);
    }
    // Randomize the word order
    Collections.shuffle(_words);
  }
  public String nextWord()
  {
    if (_nextWord >= _words.size())
    {
      _nextWord = 0;
      Collections.shuffle(_words);
    }
    return (String) _words.get(_nextWord++);
  }
}
