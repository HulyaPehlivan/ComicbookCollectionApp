import axios from "axios";

export default {
    getAllComics() {
        return axios.get("/comicvine/comics")
    },

    getComicById(apiID) {
        return axios.get(`/issues/${apiID}`)
    },

    getComicByTitle(name) {
        // console.log("insearch" + name)
        return axios.get(`/comicvine/title/${name}`)
    },

    addComicToCollection(comic, collectionId, apiID) {
        return axios.post(`/${collectionId}/add/${apiID}`, comic)
    },

    getComicByStoryArc(name) {
        return axios.get(`/story_arc/${name}`)
    },
    getComicByCollectionId(collectionId) {
        return axios.get(`/comics/collectionId/${collectionId}`)
    },
    getComicByCollectionAndAPIID(collectionId, apiID) {
        return axios.get(`/${collectionId}/comic/${apiID}`)
    },

    deleteComic(collectionId, apiID) {
        return axios.delete(`/${collectionId}/delete/${apiID}`)
    },

    updateComicQuantity(comic, comicId) {
        return axios.put(`/comics/updateQuantity/${comicId}`, comic)
    }
}
