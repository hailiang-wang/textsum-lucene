// $Id: CategoryCounterTest.java 30 2009-09-27 04:56:49Z spal $
// $Source$
package net.sf.jtmt.crawling.gdata;

import org.junit.Test;

/**
 * TODO: Class level Javadocs
 * @author Sujit Pal
 * @version $Revision: 30 $
 */
public class CategoryCounterTest {

  @Test
  public void testCount() throws Exception {
    CategoryCounter counter = new CategoryCounter();
    counter.count();
  }
}
