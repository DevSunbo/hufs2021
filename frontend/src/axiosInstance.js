import Axios from 'axios';

const instance = Axios.create({
    baseURL: 'https://domain.com/api/',
    timeout: 1000,
    headers: {'X-Custom-Header': 'foobar'}
});

export default instance;