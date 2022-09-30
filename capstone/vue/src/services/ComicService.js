import axios from "axios";

export default {
    getAllComics() {
        return axios.get("/comics")
    }
}