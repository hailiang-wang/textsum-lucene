// $Id: WordNGramGeneratorTest.java 51 2010-10-22 23:52:20Z spal $
package net.sf.jtmt.phrase;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for Phrase extractor code.
 * @author Sujit Pal
 * @version $Revision: 51 $
 */
public class WordNGramGeneratorTest {
  
  private final Log log = LogFactory.getLog(getClass());
  
  private static final String SENTENCE = 
    "First, she tried to look down and make out what she was coming to, " +
    "but it was too dark to see anything; then she looked at the sides of " +
    "the well, and noticed that they were filled with cupboards and " +
    "book-shelves; here and there she saw maps and pictures hung upon pegs.";
  
  @Test
  public void testWordNGramGeneration() throws Exception {
    WordNGramGenerator generator = new WordNGramGenerator();
    List<String> wordgrams = generator.generate(SENTENCE, 3, 5);
    log.info("wordgrams = " + wordgrams);
    log.info("wordgrams.size=" + wordgrams.size());
    Assert.assertEquals(146, wordgrams.size());
  }
}
