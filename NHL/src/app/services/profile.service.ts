import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Profile } from '../models/profile.class';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  apiURL = 'api';
  constructor(private httpClient: HttpClient) { }

  getProfile(userId: string) {
    let params = new HttpParams().set("id", userId);
    console.log( "executing HTTP get" );
    //return this.httpClient.get<any>( "api/user", { params: params });

    return this.httpClient.get("api/user", { params: params })
    .pipe(
      map((data: any) => {
        const profile: Profile = new Profile( data.object.id,
                               data.object.username,
                               data.object.password,
                               data.object.fname,
                               data.object.lname,
                               data.object.email,
                               data.object.joined );
        return profile;
      })
    );
   }

}
