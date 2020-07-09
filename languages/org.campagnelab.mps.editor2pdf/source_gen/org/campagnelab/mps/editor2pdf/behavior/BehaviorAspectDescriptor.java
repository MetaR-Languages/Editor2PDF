package org.campagnelab.mps.editor2pdf.behavior;

/*Generated by MPS */

import jetbrains.mps.core.aspects.behaviour.BaseBehaviorAspectDescriptor;
import jetbrains.mps.core.aspects.behaviour.api.BHDescriptor;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import jetbrains.mps.lang.smodel.ConceptSwitchIndex;
import jetbrains.mps.lang.smodel.ConceptSwitchIndexBuilder;
import jetbrains.mps.smodel.adapter.ids.MetaIdFactory;

public final class BehaviorAspectDescriptor extends BaseBehaviorAspectDescriptor {
  private final BHDescriptor myDefaultOutputDirectory__BehaviorDescriptor = new DefaultOutputDirectory__BehaviorDescriptor();
  private final BHDescriptor myEditorAnnotation__BehaviorDescriptor = new EditorAnnotation__BehaviorDescriptor();

  public BehaviorAspectDescriptor() {
  }

  @Nullable
  public BHDescriptor getDescriptor(@NotNull SAbstractConcept concept) {
    SAbstractConcept cncpt = concept;
    switch (conceptIndex.index(cncpt)) {
      case 0:
        return myDefaultOutputDirectory__BehaviorDescriptor;
      case 1:
        return myEditorAnnotation__BehaviorDescriptor;
      default:
    }
    return null;
  }
  private static final ConceptSwitchIndex conceptIndex = new ConceptSwitchIndexBuilder().put(MetaIdFactory.conceptId(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0xc65f8233c995462L), MetaIdFactory.conceptId(0x93bc01ac08ca4f11L, 0x9c7d614d04055dfbL, 0x79754067868533ecL)).seal();
}
