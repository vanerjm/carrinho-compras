export class User {
    public id: string;
    public name: string;
    public email: string;

    public toString = (): string => {
        return `User (id: ${this.id})`;
    }
}
