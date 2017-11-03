// $Id: Chunk.java 40 2009-11-14 23:15:38Z spal $
package net.sf.jtmt.crawling.textextraction;

/**
 * Holder for a line of text and its attributes.
 * @author Sujit Pal
 * @version $Revision: 40 $
 */
public class Chunk {

  public String text;
  public float density;
  public boolean keep;

  public Chunk(String text, float density, boolean keep) {
    this.text = text;
    this.density = density;
    this.keep = keep;
  }
}
