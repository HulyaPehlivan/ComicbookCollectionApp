import axios from "axios";

export default {
    getAllComics() {
        return axios.get("/comics")
    }, 

    getComicById(apiID) {
        return axios.get(`/issues/${apiID}`)
    }
}