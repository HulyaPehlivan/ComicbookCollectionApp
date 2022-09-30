import axios from "axios";

export default {
    getAllVolumes() {
        return axios.get("/volumes")
    }
}