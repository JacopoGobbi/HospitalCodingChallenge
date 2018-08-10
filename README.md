# Hospital Challenge

## How to use
Package with maven to generate a jar (in case is not present):
```
mvn package
```

Run the jar using:
```
java -jar hospital-1.0.jar <PATIENTS> ?DRUGS?
```

## How to run tests
```
mvn test
```

## Considerations
Since from the exercise description it was not clear at which stage patients
start dying the solutions assumes that at the end of a series of treatments
(program execution) all patient that have not received a valid treatment that
changed their state, cured them or prevent them from dying, will die (apart
from healthy ones).