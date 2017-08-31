package org.campagnelab.mps.editor2pdf.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.AbstractIntentionDescriptor;
import jetbrains.mps.openapi.intentions.IntentionFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import java.util.Collection;
import jetbrains.mps.openapi.intentions.IntentionExecutable;
import jetbrains.mps.openapi.intentions.Kind;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.openapi.editor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;
import java.util.Collections;
import jetbrains.mps.intentions.AbstractIntentionExecutable;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import org.jetbrains.mps.openapi.module.SRepository;
import jetbrains.mps.baseLanguage.logging.runtime.model.LoggingRuntime;
import org.apache.log4j.Level;
import jetbrains.mps.editor.runtime.HeadlessEditorComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import org.campagnelab.mps.editor2pdf.behavior.EditorAnnotation__BehaviorDescriptor;
import jetbrains.mps.openapi.intentions.IntentionDescriptor;

public final class RefreshRenderings_Intention extends AbstractIntentionDescriptor implements IntentionFactory {
  private static final Logger LOG = LogManager.getLogger(RefreshRenderings_Intention.class);
  private Collection<IntentionExecutable> myCachedExecutable;
  public RefreshRenderings_Intention() {
    super(Kind.NORMAL, false, new SNodePointer("r:6bb9f222-b46c-45b3-85b5-99e8faaeadce(org.campagnelab.mps.editor2pdf.intentions)", "893392931327280422"));
  }
  @Override
  public String getPresentation() {
    return "RefreshRenderings";
  }
  @Override
  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }
  private boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0xc65f8233c9b555cL, 0xc65f8233c9b5594L, "diagrams"))).count() > 0;
  }
  @Override
  public boolean isSurroundWith() {
    return false;
  }
  public Collection<IntentionExecutable> instances(final SNode node, final EditorContext context) {
    if (myCachedExecutable == null) {
      myCachedExecutable = Collections.<IntentionExecutable>singletonList(new RefreshRenderings_Intention.IntentionImplementation());
    }
    return myCachedExecutable;
  }
  /*package*/ final class IntentionImplementation extends AbstractIntentionExecutable {
    public IntentionImplementation() {
    }
    @Override
    public String getDescription(final SNode node, final EditorContext editorContext) {
      return "Refresh Renderings";
    }
    @Override
    public void execute(final SNode node, final EditorContext editorContext) {
      final Set<String> names = SetSequence.fromSet(new HashSet<String>());
      for (SNode svgExport : ListSequence.fromList(SLinkOperations.getChildren(node, MetaAdapterFactory.getContainmentLink(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0xc65f8233c9b555cL, 0xc65f8233c9b5594L, "diagrams")))) {
        SetSequence.fromSet(names).addElement(SPropertyOperations.getString(SLinkOperations.getTarget(svgExport, MetaAdapterFactory.getReferenceLink(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0xc65f8233c9b5596L, 0xc65f8233c9b5597L, "diagram")), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")));
      }

      ListSequence.fromList(SModelOperations.nodesIncludingImported(SNodeOperations.getModel(node), MetaAdapterFactory.getConcept(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x10802efe25aL, "jetbrains.mps.lang.core.structure.BaseConcept"))).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (AttributeOperations.getAttribute(it, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0x79754067868533ecL, "org.campagnelab.mps.editor2pdf.structure.EditorAnnotation"))) != null) && SetSequence.fromSet(names).contains(SPropertyOperations.getString(AttributeOperations.getAttribute(it, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0x79754067868533ecL, "org.campagnelab.mps.editor2pdf.structure.EditorAnnotation"))), MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")));
        }
      }).visitAll(new IVisitor<SNode>() {
        public void visit(SNode node) {
          SRepository repository = SNodeOperations.getModel(node).getRepository();
          final SNode annotation = AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(MetaAdapterFactory.getConcept(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0x79754067868533ecL, "org.campagnelab.mps.editor2pdf.structure.EditorAnnotation")));
          if (LOG.isInfoEnabled()) {
            LoggingRuntime.legacyLog(Level.INFO, "Rendering " + SPropertyOperations.getString(annotation, MetaAdapterFactory.getProperty(0xceab519525ea4f22L, 0x9b92103b95ca8c0cL, 0x110396eaaa4L, 0x110396ec041L, "name")), RefreshRenderings_Intention.class, null);
          }

          HeadlessEditorComponent editorComponent = new HeadlessEditorComponent(node, repository);
          final EditorCell nodeCell = editorComponent.findNodeCell(node);

          SNodeOperations.getModel(node).getRepository().getModelAccess().runReadInEDT(new Runnable() {
            public void run() {
              if (SPropertyOperations.hasValue(annotation, MetaAdapterFactory.getProperty(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0x79754067868533ecL, 0x4aa50c0bd1ec9bf1L, "outputFormat"), "1", "1")) {
                EditorAnnotation__BehaviorDescriptor.renderNodeEditorToPDF_id7OORWOlZu74.invoke(annotation, annotation, nodeCell);
              } else if (SPropertyOperations.hasValue(annotation, MetaAdapterFactory.getProperty(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0x79754067868533ecL, 0x4aa50c0bd1ec9bf1L, "outputFormat"), "0", "1")) {
                EditorAnnotation__BehaviorDescriptor.renderNodeEditorToSVG_id46q0f$BiLBY.invoke(annotation, annotation, nodeCell);
              }
            }
          });

        }
      });

    }
    @Override
    public IntentionDescriptor getDescriptor() {
      return RefreshRenderings_Intention.this;
    }
  }
}
