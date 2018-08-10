package domain;

import utils.Tuple;

import java.util.List;

/**
 * State enum holding the current health state of a patient
 *
 * F: FEVER
 * H: HEALTHY
 * D: DIABETES
 * T: TUBERCULOSIS
 * X: DEAD
 */
public enum State {
    F, H, D, T, X;
    Tuple<State, Boolean> administer(Drug drug, List<Drug> drugsAdministered) {
        State resultingState = this;
        boolean hasReceivedEffectiveTreatment = false;
        switch (drug) {
            case As:
                // Aspirin cures Fever
                if (this == F) {
                    resultingState = H;
                    hasReceivedEffectiveTreatment = true;
                }
                break;
            case An:
                // Antibiotic cures Tuberculosis
                if (this == T) {
                    resultingState = H;
                    hasReceivedEffectiveTreatment = true;
                }
                break;
            case I:
                // Insulin prevents diabetic subject from dying, no changes in state
                if (this == D) {
                    hasReceivedEffectiveTreatment = true;
                }
                // If insulin is mixed with antibiotic, healthy people catch Fever
                if (drugsAdministered.contains(Drug.An)) {
                    resultingState = F;
                    hasReceivedEffectiveTreatment = true;
                }
                break;
            case P:
                // Paracetamol cures Fever
                if (this == F) {
                    resultingState = H;
                    hasReceivedEffectiveTreatment = true;
                }
                // Paracetamol kills subject if mixed with aspirin
                if (drugsAdministered.contains(Drug.As)) {
                    resultingState = X;
                    hasReceivedEffectiveTreatment = true;
                }
                break;

        }
        return new Tuple<>(resultingState, hasReceivedEffectiveTreatment);
    }
}