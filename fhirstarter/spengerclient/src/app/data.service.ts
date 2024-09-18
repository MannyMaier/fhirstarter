import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Patient } from "./models/Patient";
import { Practitioner } from "./models/Practitioner";
import { Observable, catchError, of } from "rxjs";
import { Contract } from "./models/Contract";
import {Encounter} from "./models/Encounter";

@Injectable({
  providedIn: "root",
})
export class DataService {
  constructor(private http: HttpClient) {}

  private patientUrl: string = "http://localhost:8080/api/patient/";
  private practitionerUrl: string = "http://localhost:8080/api/practitioner/";
  private contractUrl: string = "http://localhost:8080/api/contract/";
  private encounterUrl: string = "http://localhost:8080/api/encounter/";


  //#region  Patient methods
  public getPatients(): Observable<Patient[]> {

    console.log("GET PATIENTS");

    return this.http
      .get<Patient[]>(this.patientUrl)
      .pipe(catchError(this.handleError("getPatients", [])));
  }

  public getPatient(id: string): Observable<Patient> {

    console.log("1 GET PATIENT");

    return this.http
      .get<Patient>(this.patientUrl + id)
      .pipe(catchError(this.handleError("getPatientDetail", new Patient())));
  }

  public deletePatient(id: string): Observable<{}> {
    return this.http
      .delete(this.patientUrl + id)
      .pipe(catchError(this.handleError("deletePatient", new Patient())));
  }

  public addPatient(patient: Patient): Observable<Patient> {
    return this.http
      .post<Patient>(this.patientUrl, patient)
      .pipe(catchError(this.handleError("addPatient", patient)));
  }

  public updatePatient(patient: Patient): Observable<Patient> {
    return this.http
      .put<Patient>(this.patientUrl + patient.id, patient)
      .pipe(catchError(this.handleError("updatePatient", patient)));
  }

  //#endregion


  //#region  Practitioner methods
  public getPractitioners(): Observable<Practitioner[]> {
    return this.http
      .get<Practitioner[]>(this.practitionerUrl)
      .pipe(catchError(this.handleError("getPractitioners", [])));
  }

  public getPractitioner(id: string): Observable<Practitioner> {
    return this.http
      .get<Practitioner>(this.practitionerUrl + id)
      .pipe(catchError(this.handleError("getPractitioner", new Practitioner())));
  }

  public deletePractitioner(id: string): Observable<{}> {
    return this.http
      .delete(this.practitionerUrl + id)
      .pipe(catchError(this.handleError("deletePractitioner", new Practitioner())));
  }

  public addPractitioner(practitioner: Practitioner): Observable<Practitioner> {

    console.log("CLIENT PRACT" + JSON.stringify(practitioner));

    return this.http
      .post<Practitioner>(this.practitionerUrl, practitioner)
      .pipe(catchError(this.handleError("addPractitioner", practitioner)));

  }

  public updatePractitioner(practitioner: Practitioner): Observable<Practitioner> {
    return this.http
      .put<Practitioner>(this.practitionerUrl + practitioner.id, practitioner)
      .pipe(catchError(this.handleError("updatePractitioner", practitioner)));
  }

  //#endregion

  //#region  Contract methods
  public getContracts(): Observable<Contract[]> {
    return this.http
      .get<Contract[]>(this.contractUrl)
      .pipe(catchError(this.handleError("getContracts", [])));
  }

  public getContract(id: string): Observable<Contract> {
    return this.http
      .get<Contract>(this.practitionerUrl + id)
      .pipe(catchError(this.handleError("getContract", new Contract())));
  }

  //#endregion

  //#region Encounters methods
  public getEncounters(): Observable<Encounter[]> {

    console.log("GET Encounters");

    return this.http
      .get<Encounter[]>(this.encounterUrl)
      .pipe(catchError(this.handleError("getEncounters", [])));
  }

  public getEncounter(id: string): Observable<Encounter> {

    console.log("GET 1 Encounter");

    return this.http
      .get<Encounter>(this.encounterUrl + id)
      .pipe(catchError(this.handleError("getEncounter", new Encounter())));
  }

  public deleteEncounter(id: string): Observable<{}> {
    return this.http
      .delete(this.encounterUrl + id)
      .pipe(catchError(this.handleError("deleteEncounter", new Encounter())));
  }

  public addEncounter(encounter: Encounter): Observable<Encounter> {
    return this.http
      .post<Encounter>(this.encounterUrl, encounter)
      .pipe(catchError(this.handleError("addEncounter", encounter)));
  }

  public updateEncounter(encounter: Encounter): Observable<Encounter> {
    return this.http
      .put<Encounter>(this.encounterUrl + encounter.id, encounter)
      .pipe(catchError(this.handleError("updateEncounter", encounter)));
  }
  //#endregion





  private handleError<T>(operation = "operation", result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as any);
    };
  }
}
