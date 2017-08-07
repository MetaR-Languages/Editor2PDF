package org.campagnelab.mps.editor2pdf.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptPresentationAspectBase;
import jetbrains.mps.smodel.runtime.ConceptPresentation;
import jetbrains.mps.smodel.runtime.ConceptPresentationBuilder;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.mps.openapi.language.SAbstractConcept;

public class ConceptPresentationAspectImpl extends ConceptPresentationAspectBase {
  private final ConceptPresentation props_DefaultOutputDirectory = new ConceptPresentationBuilder().create();
  private final ConceptPresentation props_DiagramOutputDirectory = new ConceptPresentationBuilder().shortDesc("Output directory for SVG Renderings").create();
  private final ConceptPresentation props_DiagramRef = new ConceptPresentationBuilder().create();
  private final ConceptPresentation props_EditorAnnotation = new ConceptPresentationBuilder().create();
  private final ConceptPresentation props_Font = new ConceptPresentationBuilder().create();
  private final ConceptPresentation props_PdfCollection = new ConceptPresentationBuilder().shortDesc("Collection of PDF editor annotations").create();

  @Override
  @Nullable
  public ConceptPresentation getDescriptor(SAbstractConcept c) {
    StructureAspectDescriptor structureDescriptor = (StructureAspectDescriptor) myLanguageRuntime.getAspect(jetbrains.mps.smodel.runtime.StructureAspectDescriptor.class);
    switch (structureDescriptor.internalIndex(c)) {
      case LanguageConceptSwitch.DefaultOutputDirectory:
        return props_DefaultOutputDirectory;
      case LanguageConceptSwitch.DiagramOutputDirectory:
        return props_DiagramOutputDirectory;
      case LanguageConceptSwitch.DiagramRef:
        return props_DiagramRef;
      case LanguageConceptSwitch.EditorAnnotation:
        return props_EditorAnnotation;
      case LanguageConceptSwitch.Font:
        return props_Font;
      case LanguageConceptSwitch.PdfCollection:
        return props_PdfCollection;
    }
    return null;
  }
}