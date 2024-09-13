  export class Practitioner {
    constructor(
      public id: string = '',
        public active: boolean = false,
        public name: Array<HumanName> = [],
        public identifier?: Array<Identifier>,
        public telecom: Array<ContactPoint> = [],
        public gender: string = 'unknown',
        public birthDate: Date = new Date(),
        public address: Array<Address> = [],
        public photo: Array<Attachment> = [],
        public qualification: Array<Qualification> = [],
        public communication: Array<Communication> = []
    ) {}
  }

  export class Attachment {
    constructor(
        public data: string = ''
    ) {}
  } 

  export class Identifier {
    constructor(
        public value: string = ''
    ) {}
  }

  export enum StatusCode {usual, official, temp, nickname, anonymus, old, maiden}


  export class HumanName {
    constructor(
        public use: StatusCode = StatusCode.usual,
        public text: string = '',
        public family: string = '',
        public given: Array<string> = [],
        public prefix: Array<string> = [],
        public suffix: Array<string> = [],
        public period: Period = new Period(new Date(), new Date())
    ) {}
  }


  export class ContactPoint {
    constructor() {}
  }

  export class Address {
    constructor() {}
  }

  export class Period {
    constructor(
      public start: Date,
      public end: Date
    ){}
  }

  export class CodeableConcept {
    constructor(
      public coding: Array<Coding> = [],
      public text: String
    ){}
  }

  export class Coding {
    constructor(
      public system: Date,
      public version: Date,
      public code: String,
      public display: String,
      public userSelected: Boolean  
    ){}
  }

  export class Qualification {
    constructor(
        public identifier: Array<Identifier> = [],
        public code: CodeableConcept = new CodeableConcept([], ""),
        public period: Period = new Period(new Date(), new Date() ),
    ) {}
  }

  export class Communication {
    constructor() {}
  }
