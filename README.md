## Configuration
  Edit config files:
  - resources/application.yml
  - resources/frontend-app/config/app.config.ts

## Development
- Start backend `./gradlew`
- Start frontend `ng serve`

## Production
Execute `./gradlew clean build` to build backend.
Compiled .jar file will be stored in `build/libs/` and server could be runned by executing
`nohup java -jar github-browsing.jar > /tmp/github-browsing.log &`

Execute `ng build --prod` to build frontend.
The build artifacts will be stored in the `dist/` directory and could be copied to web server.

Useful info for web server setup:
https://angular.io/guide/deployment#routed-apps-must-fallback-to-indexhtml
