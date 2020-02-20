export class Item {
    public id: string;
    public name: string;
    public value: number;

    public toString = (): string => {
        return `Item (id: ${this.id})`;
    }
}
