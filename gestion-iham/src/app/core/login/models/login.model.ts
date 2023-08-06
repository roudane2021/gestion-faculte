export interface UserSignIn {
    email: string;
    password: string;
 }

 export interface UserApp {
    Authorization? : string[],
    PROFILE?: string,
    exp?: number,
    iat?: number,
    sub?: string;
  }