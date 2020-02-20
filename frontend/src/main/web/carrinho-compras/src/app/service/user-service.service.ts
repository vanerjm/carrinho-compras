import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public getUser(id: string): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/${id}`);
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }

  public updateUser(id: string, value: User): Observable<User> {
    return this.http.put<User>(`${this.usersUrl}/${id}`, value);
  }

  public deleteUser(id: string): Observable<User> {
    return this.http.delete<User>(`${this.usersUrl}/${id}`);
  }
}
