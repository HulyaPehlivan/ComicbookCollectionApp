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
    }
}