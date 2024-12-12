// import { HttpClient } from "@angular/common/http";
// import { Injectable } from "@angular/core";
// import { CanActivate } from "@angular/router";
// import { Observable } from "rxjs";

// @Injectable({

//     providedIn: 'root'
//     endpointURL = '/api/contact'
// })
// export class ProfileService implements CanActivate {
    
//     profile = null

    
//     constructor(
//         private httpClient: HttpClient
//     ){}

//     getProfile(){
//         return new Observable((observer) => {
//             if(this.profile) {
//                 observer.next(this.profile);
//                 observer.complete();
//             } else {
//                 this.httpClient.get()
//             }



//         })
//     }
// }