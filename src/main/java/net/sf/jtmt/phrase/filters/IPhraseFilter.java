// $Id: IPhraseFilter.java 36 2009-10-30 01:47:39Z spal $
package net.sf.jtmt.phrase.filters;

/**
 * Interface for various phrase filtering mechanisms. Its isPhrase() method
 * is implemented differently in different phrase filters.
 * @author Sujit Pal
 * @version $Revision: 36 $
 */
public interface IPhraseFilter {

  public double getPhraseDeterminant();
}
