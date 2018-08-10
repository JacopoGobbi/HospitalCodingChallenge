package domain;

public interface Divinity {
    /**
     * Will the divinity appear to save a patient?
     *
     * @return true if the divinity will save a patient, false otherwise
     */
    default boolean appear() {
        return false;
    }
}
