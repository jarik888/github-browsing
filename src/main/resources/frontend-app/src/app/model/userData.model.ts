import { User } from "./user.model";
import { Repo } from "./repo.model";

export class UserData {
  constructor(public user: User,
              public repos: Array<Repo>) {
  }
}
