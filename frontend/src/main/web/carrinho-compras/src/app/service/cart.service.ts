import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Cart } from '../model/cart';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  
  private cartsUrl: string;

  constructor(private http: HttpClient) {
    this.cartsUrl = 'http://localhost:8080/carts';
  }

  public findAll(): Observable<Cart[]> {
    return this.http.get<Cart[]>(this.cartsUrl);
  }

  public getCart(id: string): Observable<Cart> {
    return this.http.get<Cart>(`${this.cartsUrl}/${id}`);
  }

  public save(cart: Cart) {
    console.log(JSON.stringify(cart));
    return this.http.post<Cart>(this.cartsUrl, cart);
  }

  public updateCart(id: string, value: Cart): Observable<Cart> {
    return this.http.put<Cart>(`${this.cartsUrl}/${id}`, value);
  }

  public deleteCart(id: string): Observable<Cart> {
    return this.http.delete<Cart>(`${this.cartsUrl}/${id}`);
  }
}
