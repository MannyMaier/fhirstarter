export class Encounter {
  id?: string;
  status?: string;
  period?: Period;
  type?: CodeableConcept[];
  diagnosis?: Diagnosis[];
  participant?: Participant[];
}

export class Period {
  start?: string;
  end?: string;
}

export class CodeableConcept {
  coding?: Coding[];
  text?: string;
}

export class Coding {
  system?: string;
  code?: string;
  display?: string;
}

export class Diagnosis {
  condition?: CodeableConcept;
  rank?: number;
}

export class Participant {
  type?: CodeableConcept[];
  period?: Period;
  individual?: Reference;
}

export class Reference {
  reference?: string;
  type?: string;
  identifier?: Identifier;
  display?: string;
}

export class Identifier {
  use?: string;
  type?: CodeableConcept;
  system?: string;
  value?: string;
  period?: Period;
  assigner?: Reference;
}
