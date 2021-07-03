import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Kisi} from './kisi';
import {environment} from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class KisiService {
  private apiServerUrl = environment.apiBaseUrl;


  constructor(private http: HttpClient) { }

  public getKisiler(): Observable<Kisi[]>{
    return this.http.get<Kisi[]>(`${this.apiServerUrl}/kisi/all`);
  }

  public addKisi(kisi: Kisi): Observable<Kisi> {
    return this.http.post<Kisi>(`${this.apiServerUrl}/kisi/add`, kisi);
  }

  public updateKisi(kisi: Kisi): Observable<Kisi> {
    return this.http.put<Kisi>(`${this.apiServerUrl}/kisi/update`, kisi);
  }

  public deleteKisi(kisiId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/kisi/delete/${kisiId}`);
  }
}
