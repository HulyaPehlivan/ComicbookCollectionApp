import axios from "axios";


export default {
    getCollections() {
        return axios.get('/collections/userId')
    },
    viewCollection() {
        return axios.get('/collections/collectionId')
    }
}