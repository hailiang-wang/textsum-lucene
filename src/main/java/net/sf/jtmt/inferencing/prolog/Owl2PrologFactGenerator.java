// $Id: Owl2PrologFactGenerator.java 12 2009-06-12 19:59:09Z spal $
package net.sf.jtmt.inferencing.prolog;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.commons.lang.StringUtils;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Node_URI;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

/**
 * Reads an OWL file representing an ontology, and outputs a Prolog
 * fact base.
 * @author Sujit Pal
 * @version $Revision: 12 $
 */
public class Owl2PrologFactGenerator {

  private String inputOwlFilename;
  private String outputPrologFilename;
  
  public void setInputOwlFilename(String inputOwlFilename) {
    this.inputOwlFilename = inputOwlFilename;
  }

  public void setOutputPrologFilename(String outputPrologFilename) {
    this.outputPrologFilename = outputPrologFilename;
  }

  public void generate() throws Exception {
    PrintWriter prologWriter = 
      new PrintWriter(new FileWriter(outputPrologFilename), true);
    Model model = ModelFactory.createDefaultModel();
    model.read(inputOwlFilename);
    StmtIterator sit = model.listStatements();
    while (sit.hasNext()) {
      Statement st = sit.next();
      Triple triple = st.asTriple();
      String prologFact = getPrologFact(triple);
      if (StringUtils.isNotEmpty(prologFact)) {
        prologWriter.println(getPrologFact(triple));
      }
    }
    model.close();
    prologWriter.flush();
    prologWriter.close();
  }

  private String getPrologFact(Triple triple) {
    StringBuilder buf = new StringBuilder();
    Node subject = triple.getSubject();
    Node object = triple.getObject();
    if ((subject instanceof Node_URI) &&
        (object instanceof Node_URI)) {
      buf.append("isTriple(a").
      append(triple.getSubject().getLocalName()).
      append(",").
      append(triple.getPredicate().getLocalName()).
      append(",a").
      append(triple.getObject().getLocalName()).
      append(").");
    }
    return buf.toString();
  }
}
