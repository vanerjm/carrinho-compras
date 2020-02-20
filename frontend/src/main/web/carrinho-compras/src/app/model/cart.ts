import {
    Item
}
from './item';
import {
    User
}
from './user';

export class Cart {
    private id: string;
    private user: User;
    private items: Array < Item > ;

    constructor() {
        this.items = new Array < Item > ();
    }

    public toString = (): string => {
        return `Cart (id: ${this.id})`;
    }

    public get _user(): User {
        return this.user;
    }

    public set _user(user: User) {
        this.user = user;
    }

    public addItem(item: Item) {
        this.items.push(item);
    }

    public set _items(items: Array < Item > ) {
        this.items = items;
    }

    public get _items(): Array < Item > {
        return this.items;
    }
}