export class Repo {
  constructor(public name: string,
              public html_url: string,
              public created_at: string,
              public pushed_at: string,
              public language: string) {
  }
}
