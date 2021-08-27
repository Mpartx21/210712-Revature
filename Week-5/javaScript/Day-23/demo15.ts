class Student{
    private id: number;
    private name:string;
    private passMark:40;
    private _x;

    get x(){
        return this._x;
    }
    
    set X(value){
        if(value < 0){
            throw new Error('cannot be a negative value')
        }
    }

}

