import AbstractService from './AbstractService';
export default class UserService extends AbstractService {
        constructor(){
            super();
            this.url = this.baseUrl + "/users"
        }
        
        async all(){
            console.log(this.url);
            const data = await fetch(this.url, {
                method: 'get',
                headers: {
                    'Accept': 'application/json'
                }
            })
                    .then(response => response.json())
                    .catch(res => console.error(res))
            return data;
        }
}

