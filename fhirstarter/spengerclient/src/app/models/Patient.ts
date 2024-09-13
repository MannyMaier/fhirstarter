export class Patient {
    constructor(
    public id: string = '',
    public resourceType: string = 'Patient',
    public identifier?: Array<Identifier>,
    public name?: Array<HumanName>,
    public telecom?: Array<ContactPoint>,
    public active: boolean = false,
    public gender: Gendercode = Gendercode.unknown,
    public birthDate: Date = new Date(),
    public deceasedBoolean?: boolean,
    public deceasedDateTime?: Date,
    public multipleBirthBoolean?: boolean,
    public multipleBirthInteger?: number
    ) {}
    }

    export enum StatusCode {usual, official, temp, nickname, anonymus, old, maiden}

    export enum Gendercode { male, female, other, unknown}


    export class  HumanName {
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
    export class Period {
      constructor(
        public start: Date,
        public end: Date
      ){}
    }
    export class Identifier {
    constructor(public value: string = '') {}
    }
    export class ContactPoint {
    constructor() {}
    }
    