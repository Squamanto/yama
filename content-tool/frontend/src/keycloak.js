import Keycloak from 'keycloak-js'
 
// Setup Keycloak instance as needed
// Pass initialization options as required or leave blank to load from 'keycloak.json'
// load dynamically to avoid localhost issues
const keycloak = new Keycloak({
    realm: "yama",
    clientId: "content-tool",
    url: "http://localhost/auth"
});
 
export default keycloak;