import axios from 'axios';
import { environment } from '../environment/env';

export class api {

    static async news(jsonFile) {
        return await axios.get(`${environment.news}/${jsonFile}`);
    }

    static async videos() {
        return await axios.get(`${environment.videos}/videos.json`);
    }

    static contact(contact) {
        return axios.post(`${environment}/mail`, contact);
    }
}