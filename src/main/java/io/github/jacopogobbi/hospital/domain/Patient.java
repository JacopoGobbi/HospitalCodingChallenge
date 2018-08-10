package io.github.jacopogobbi.hospital.domain;

import io.github.jacopogobbi.hospital.utils.Tuple;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private State state;
    private List<Drug> drugsAdministered;
    private boolean hasReceivedEffectiveTreatment;

    public Patient(State state) {
        this.state = state;
        this.drugsAdministered = new ArrayList<>();
        this.hasReceivedEffectiveTreatment = false;
    }

    /**
     * Administer a drug to a patient
     *
     * @param drug the drug to administer
     */
    public void administer(Drug drug) {
        if (state != State.X) {
            Tuple<State, Boolean> results = state.administer(drug, drugsAdministered);
            this.hasReceivedEffectiveTreatment =
                    !this.hasReceivedEffectiveTreatment ? results._2 : this.hasReceivedEffectiveTreatment;
            this.drugsAdministered.add(drug);
            this.state = results._1;
        }
    }

    /**
     * Get patient state at the end of the treatments
     *
     * @return the patient state if the treatment was effective, dead otherwise
     */
    public State getResultingState() {
        // If patient has received an effective treatment he is going to resist until the next series of treatments
        if (this.hasReceivedEffectiveTreatment)
            return this.state;
        else
            return State.X;
    }
}
