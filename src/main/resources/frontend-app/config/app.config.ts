export const AppConfig = {
  github: {
    clientId: '<client_id>',
    scope: 'read:user%20repo',
    authUrl: 'https://github.com/login/oauth/authorize',
    redirectUrl: 'http://localhost:4200/login',
  },
  backendUrl: 'http://localhost:8888'
};
