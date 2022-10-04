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
    }
}
// ComicService.getAllComics().then((response) => {
//     console.log(response.data);
//     this.comics = response.data;
//     this.$store.commit("LOAD_ALL_COMICS", this.comics);