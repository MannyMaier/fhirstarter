export class Encounter {
  constructor(
    public id: string = "",
    public status: EncounterStatus = EncounterStatus.Planned,
    public period: Period = new Period(new Date(), new Date()),
    public type: Array<CodeableConcept> = [],
    public diagnosis: Array<Diagnosis> = [],
    public participant: Array<Participant> = [],
    public identifier: Array<Identifier> = [],
    public appointment: Array<Reference> = [],
    public subject: Reference = new Reference(),
    public episodeOfCare: Reference = new Reference(),
    public reasonReference: Reference = new Reference(),
    public partOf: Reference = new Reference(),
    /*public statusHistory: Array<StatusHistory> = []*/
  ) { }
}

/* export class StatusHistory {
  constructor(
    public period: Period = new Period(new Date("1999-01-01T00:00:00"), new Date("1999-01-01T00:00:00"),
    )
  ) { }
} */

  export class Period {
    constructor(public start: Date | null = null, public end: Date | null = null) {
      console.log("Periodclass: ", start, end);
    }
  }

export class CodeableConcept {
  constructor(public coding: Array<Coding> = [], public text: string = "") { }
}

export class Coding {
  constructor(
    public system: string = "",
    public version: string = "",
    public code: string = "",
    public display: string = "",
    public userSelected: boolean = false
  ) { }
}

export class Diagnosis {
  constructor(
    public condition: Reference = new Reference(),
    public use: CodeableConcept = new CodeableConcept(),
    public rank: number = 0
  ) { }
}

export class Participant {
  constructor(
    public type: Array<CodeableConcept> = [],
    public period: Period = new Period(new Date(), new Date()),
    public individual: Reference = new Reference()
  ) { }
}

export class Reference {  
  constructor(
    public reference: string = "",
    public type: string = "",
    public identifier: Identifier = new Identifier(),
    public display: string = ""
  ) { }
}

export class Identifier {
  constructor(public value: string = "") { }
}

export enum EncounterStatus {
  Planned = "planned",
  Arrived = "arrived",
  Triaged = "triaged",
  InProgress = "in-progress",
  OnLeave = "onleave",
  Finished = "finished",
  Cancelled = "cancelled",
}
