package org.campagnelab.mps.editor2pdf.behavior;

/*Generated by MPS */

import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.openapi.editor.cells.EditorCell;
import java.awt.Graphics;
import jetbrains.mps.nodeEditor.cells.ParentSettings;
import jetbrains.mps.openapi.editor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Component;
import java.util.Iterator;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import java.awt.Graphics2D;
import com.itextpdf.awt.PdfGraphics2D;
import org.apache.log4j.Priority;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class EditorAnnotation_Behavior {
  public static void init(SNode thisNode) {
    SLinkOperations.setTarget(thisNode, "outputTo", ListSequence.fromList(SModelOperations.getRootsIncludingImported(SNodeOperations.getModel(thisNode), "org.campagnelab.mps.editor2pdf.structure.DefaultOutputDirectory")).first(), false);
    SPropertyOperations.set(thisNode, "outputFormat", "1");
  }

  public static void call_visit_9022082025460316141(SNode thisNode, EditorCell cell, Graphics g2d, ParentSettings settings) {
    if (cell instanceof EditorCell_Collection) {
      EditorAnnotation_Behavior.call_visit_9022082025460320294(thisNode, ((EditorCell_Collection) cell), g2d, settings);
    } else {
      // <node> 
      jetbrains.mps.nodeEditor.cells.EditorCell aCell = ((jetbrains.mps.nodeEditor.cells.EditorCell) cell);
      aCell.paint(g2d, settings);
    }
    if (cell instanceof EditorCell_Component) {
      EditorAnnotation_Behavior.call_visit_9022082025460322112(thisNode, ((EditorCell_Component) cell), g2d, settings);
    }
  }

  public static void call_visit_9022082025460320294(SNode thisNode, EditorCell_Collection collection, Graphics g2d, ParentSettings settings) {
    // <node> 
    Iterator<EditorCell> it = collection.iterator();
    while (it.hasNext()) {
      EditorCell cell = it.next();
      EditorAnnotation_Behavior.call_visit_9022082025460316141(thisNode, cell, g2d, settings);
    }
  }

  public static void call_visit_9022082025460322112(SNode thisNode, EditorCell_Component component, Graphics g2d, ParentSettings settings) {
    // <node> 
    g2d.translate(component.getX(), component.getY());
    component.getComponent().paint(g2d);
    g2d.translate(-component.getX(), -component.getY());
  }

  public static void call_renderNodeEditorToPDF_9022082025460195780(SNode thisNode, SNode annotation, EditorCell editorCell) {
    // jetbrains.mps.nodeEditor.cells.EditorCell 

    // <node> 
    String dir = ((SLinkOperations.getTarget(annotation, "outputTo", false) == null) ? "." : SPropertyOperations.getString(SLinkOperations.getTarget(annotation, "outputTo", false), "path"));
    try {
      File pdfFile = new File(dir + "/" + SPropertyOperations.getString(annotation, "name") + ".pdf");
      FileOutputStream stream = new FileOutputStream(pdfFile);
      editorCell.relayout();

      int width = editorCell.getWidth() + editorCell.getX();
      int height = editorCell.getHeight() + editorCell.getY();
      Document document = new Document(new Rectangle(editorCell.getWidth(), editorCell.getHeight()));
      document.setMargins(0, 0, 0, 0);
      PdfWriter writer = PdfWriter.getInstance(document, stream);
      document.open();
      PdfContentByte cb = writer.getDirectContent();
      PdfTemplate template = cb.createTemplate(width, height);
      ParentSettings settings = new ParentSettings();
      Graphics2D g2d = new PdfGraphics2D(template, width, height, false);
      // <node> 
      EditorAnnotation_Behavior.call_visit_9022082025460316141(thisNode, editorCell, g2d, settings);
      g2d.dispose();
      cb.addTemplate(template, -editorCell.getX(), 0);

      document.close();
      if (LOG.isInfoEnabled()) {
        LOG.info("Editor PDF rendered to " + pdfFile.getAbsolutePath());
      }
    } catch (Exception e) {
      if (LOG.isEnabledFor(Priority.ERROR)) {
        LOG.error("Exception", e);
      }
      e.printStackTrace();
    }


  }

  protected static Logger LOG = LogManager.getLogger(EditorAnnotation_Behavior.class);
}
