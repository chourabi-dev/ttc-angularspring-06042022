import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'email'
})
export class EmailPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    // tchourabi@gmail.com

    //tch************@gamil.com


    const partTwo = value.split('@')[1];

    const partOne = value.substring(0,3);


    return (partOne)+'*************@'+partTwo;
  }

}
