import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Item } from '../model/item';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private itemsUrl: string;

  constructor(private http: HttpClient) {
    this.itemsUrl = 'http://localhost:8080/items';
  }

  public findAll(): Observable<Item[]> {
    return this.http.get<Item[]>(this.itemsUrl);
  }

  public getItem(id: number): Observable<Item> {
    return this.http.get<Item>(`${this.itemsUrl}/${id}`);
  }

  public save(item: Item) {
    return this.http.post<Item>(this.itemsUrl, item);
  }

  public updateItem(id: number, value: Item): Observable<Item> {
    return this.http.put<Item>(`${this.itemsUrl}/${id}`, value);
  }

  public deleteItem(id: number): Observable<Item> {
    return this.http.delete<Item>(`${this.itemsUrl}/${id}`);
  }
}
