package org.campagnelab.mps.editor2pdf.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptPresentationAspectBase;
import jetbrains.mps.smodel.runtime.ConceptPresentation;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.smodel.runtime.ConceptPresentationBuilder;

public class ConceptPresentationAspectImpl extends ConceptPresentationAspectBase {
  private ConceptPresentation props_DefaultOutputDirectory;
  private ConceptPresentation props_DiagramOutputDirectory;
  private ConceptPresentation props_DiagramRef;
  private ConceptPresentation props_EditorAnnotation;
  private ConceptPresentation props_Font;
  private ConceptPresentation props_PdfCollection;

  @Override
  @Nullable
  public ConceptPresentation getDescriptor(SAbstractConcept c) {
    StructureAspectDescriptor structureDescriptor = (StructureAspectDescriptor) myLanguageRuntime.getAspect(jetbrains.mps.smodel.runtime.StructureAspectDescriptor.class);
    switch (structureDescriptor.internalIndex(c)) {
      case LanguageConceptSwitch.DefaultOutputDirectory:
        if (props_DefaultOutputDirectory == null) {
          ConceptPresentationBuilder cpb = new ConceptPresentationBuilder();
          cpb.presentationByName();
          props_DefaultOutputDirectory = cpb.create();
        }
        return props_DefaultOutputDirectory;
      case LanguageConceptSwitch.DiagramOutputDirectory:
        if (props_DiagramOutputDirectory == null) {
          ConceptPresentationBuilder cpb = new ConceptPresentationBuilder();
          cpb.shortDesc("Output directory for SVG Renderings");
          cpb.presentationByName();
          props_DiagramOutputDirectory = cpb.create();
        }
        return props_DiagramOutputDirectory;
      case LanguageConceptSwitch.DiagramRef:
        if (props_DiagramRef == null) {
          ConceptPresentationBuilder cpb = new ConceptPresentationBuilder();
          cpb.presentationByReference(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0xc65f8233c9b5596L, 0xc65f8233c9b5597L, "diagram", "", "");
          props_DiagramRef = cpb.create();
        }
        return props_DiagramRef;
      case LanguageConceptSwitch.EditorAnnotation:
        if (props_EditorAnnotation == null) {
          ConceptPresentationBuilder cpb = new ConceptPresentationBuilder();
          cpb.presentationByName();
          props_EditorAnnotation = cpb.create();
        }
        return props_EditorAnnotation;
      case LanguageConceptSwitch.Font:
        if (props_Font == null) {
          ConceptPresentationBuilder cpb = new ConceptPresentationBuilder();
          cpb.rawPresentation("Font");
          props_Font = cpb.create();
        }
        return props_Font;
      case LanguageConceptSwitch.PdfCollection:
        if (props_PdfCollection == null) {
          ConceptPresentationBuilder cpb = new ConceptPresentationBuilder();
          cpb.shortDesc("Collection of PDF editor annotations");
          cpb.presentationByName();
          props_PdfCollection = cpb.create();
        }
        return props_PdfCollection;
    }
    return null;
  }
}
