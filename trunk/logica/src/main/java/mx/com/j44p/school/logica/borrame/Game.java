/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.j44p.school.logica.borrame;

/**
 *
 * @author jaap
 */
public class Game {
private String _targetWord;
private int _incorrectGuessesLeft;
private char[] _letters;
private boolean[] _guessed = new boolean[26];
private boolean _win;
public boolean isWin()
{
  return _win;
}
public char[] getLetters()
{
  return _letters;
}
public int getIncorrectGuessesLeft()
{
  return _incorrectGuessesLeft;
}
public boolean[] getGuessedLetters()
{
  return _guessed;
}
//46 CHAPTER 2
//   Getting started with Tapestry
       public void start(String word)
       {
         _targetWord = word;
         _incorrectGuessesLeft = 5;
         _win = false;
         int count = word.length();
//                                              Starts
//                                              a new
         _letters = new char[count];
//                                              game
         for (int i = 0; i < count; i++)
            _letters[i] = '_';
         for (int i = 0; i < 26; i++)
            _guessed[i] = false;
       }
       public boolean makeGuess(char letter)
       {
         char ch = Character.toLowerCase(letter);
         if (ch < 'a' || ch > 'z')
            throw new IllegalArgumentException(
              "Must provide an alphabetic character.");
         int index = ch - 'a';
         if (_guessed[index])
            return true;
         _guessed[index] = true;
         boolean good = false;
//                                                        Processes
         boolean complete = true;
//                                                        a player’s
//                                                        guess
         for (int i = 0; i < _letters.length; i++)
         {
            if (_letters[i] != '_')
              continue;
            if (_targetWord.charAt(i) == ch)
            {
              good = true;
              _letters[i] = ch;
              continue;
            }
            complete = false;
         }
         if (good)
//                                  Introducing the Hangman application 47
    {
      _win = complete;
      return !complete;
    }
    if (_incorrectGuessesLeft == 0)
//                                                  Processes
    {
//                                                  a player’s
      _letters = _targetWord.toCharArray();
//                                                  guess
      return false;
    }
    _incorrectGuessesLeft--;
    return true;
  }
}
