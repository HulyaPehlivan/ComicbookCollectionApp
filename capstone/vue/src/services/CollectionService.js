import axios from "axios";


export default {
    getCollections() {
        return axios.get('/collections/userId')
    },
    viewCollection(collectionId) {
        return axios.get(`/collections/${collectionId}`)
    },
    createCollection(collection) {
        return axios.post(`/collections/create`, collection)
    },
    deleteCollection(collectionId) {
        return axios.delete(`collections/collectionId/${collectionId}`)
    }
}